package window;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class consequence extends Application{
	private boolean Result;
	@Override

	public void start(Stage primaryStage){
		VBox VB = new VBox(100);
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		String a= new String();
		
		if(this.Result) a="				回答正确！		是否继续答题?";
		else a="					回答错误！		是否继续答题?";
		Label L1 = new Label(a);
		Button Chioce1 = new Button("是");
		Label L2 = new Label("								");
		Button Chioce2 = new Button("否");
		Label L3 = new Label("								");
		StackPane pane =new StackPane();
		hb1.getChildren().addAll(L2,Chioce1);
		hb2.getChildren().addAll(L3,Chioce2);
		VB.getChildren().addAll(L1,hb1,hb2);
		pane.getChildren().add(VB);
		Scene scene = new Scene( pane,500,400);
		
		
		primaryStage.setTitle("考试学习系统");
		primaryStage.setScene(scene);
		primaryStage.show();
		Chioce1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Choiceque Choiceque= new Choiceque ();
				Choiceque.setSeed();
				Stage stage = new Stage();
				try {
					Choiceque.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
			
	Chioce2.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			try {
				primaryStage.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	);
		
}
	
	public void setRsult(boolean r){
		this.Result=r;
	
	}

}
