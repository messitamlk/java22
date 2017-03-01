package window;
import Class.Question;
import DataBase.QueDao;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;
public class Choiceque extends Application{
	private int Seed;//生成1-10的随机数
	
	@Override
	public void start(Stage primaryStage){
		QueDao que = new QueDao();
		Question Question1=new Question();
		Question1=que.selectquestion(Seed);
		System.out.println(Question1.getans());
		HBox h1 = new HBox();
		Label l1 = new Label("								");
		
		Button Chioce = new Button("提交");
		h1.getChildren().addAll(l1, Chioce);
		BorderPane pane =new BorderPane();
		TextField text1 =new TextField();
	
		text1.setPrefSize(80, 30);
		pane.setCenter(text1);
		pane.setBottom(h1);
		Text text =new Text(1000,10,Question1.getque());
		pane.setTop(text);
		Scene scene = new Scene( pane,500,400);
		
		primaryStage.setTitle("考试学习系统");
		primaryStage.setScene(scene);
		primaryStage.show();
		String text2=text1.getText();
		System.out.println(text2);
		final String ques = Question1.getans();
		Chioce.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				boolean Result;
				if(text1.getText().equals(ques))
				{
				 Result=true;
				 System.out.println(Result);
			}
			else { Result=false;System.out.println(Result);}
				consequence consequence= new consequence ();
				consequence.setRsult(Result);
				Stage stage = new Stage();
				try {
					consequence.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
		
	}
	
	public int getSeed(){
		return Seed;
	}
	public void setSeed(){
		int number=(int)(Math.random()*10);//创建一个新的随机数生成器。
		this.Seed = number+1;
		System.out.print(+Seed);
	}
	
	
}
