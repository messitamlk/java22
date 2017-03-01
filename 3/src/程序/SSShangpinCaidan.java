package 程序;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class SSShangpinCaidan extends Application {
	public void start(final Stage primaryStage)throws Exception{
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		HBox hb0 = new HBox();
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		VBox vb1 = new VBox();
		
		final ComboBox<String> cbo = new ComboBox<>();
		cbo.getItems().addAll("桃李园","三四食堂","友园","桃源居");
		cbo.setStyle("-fx-color: white");
		cbo.setValue("三四食堂");
		hb0.getChildren().add(cbo);
		
		Image image1 = new Image("images/三四食堂/刀削面.jpg");
		ImageView imageview1 = new ImageView(image1);
		imageview1.setFitHeight(50);
		imageview1.setFitWidth(50);
		Label l1 = new Label("刀  削   面     ￥7.00",imageview1);
		l1.setContentDisplay(ContentDisplay.RIGHT);
		Button bt1 = new Button("购买");
		hb1.getChildren().addAll(l1,bt1);
		
		
		Image image2 = new Image("images/三四食堂/烧麦.jpg");
		ImageView imageview2 = new ImageView(image2);
		imageview2.setFitHeight(50);
		imageview2.setFitWidth(50);
		Label l2 = new Label("烧        麦     ￥6.00",imageview2);
		l2.setContentDisplay(ContentDisplay.RIGHT);
		Button bt2 = new Button("购买");
		hb2.getChildren().addAll(l2,bt2);
		
		
		Image image3 = new Image("images/三四食堂/小笼包.jpg");
		ImageView imageview3 = new ImageView(image3);
		imageview3.setFitHeight(50);
		imageview3.setFitWidth(50);
		Label l3 = new Label("小   笼   包    ￥6.00",imageview3);
		l3.setContentDisplay(ContentDisplay.RIGHT);
		Button bt3 = new Button("购买");
		hb3.getChildren().addAll(l3,bt3);
		
		
		Image image4 = new Image("images/三四食堂/馄饨.jpg");
		ImageView imageview4 = new ImageView(image4);
		imageview4.setFitHeight(50);
		imageview4.setFitWidth(50);
		Label l4 = new Label("馄         饨    ￥6.00",imageview4);
		l4.setContentDisplay(ContentDisplay.RIGHT);
		Button bt4 = new Button("购买");
		hb4.getChildren().addAll(l4,bt4);
		
		hb0.setSpacing(10);
		hb1.setSpacing(10);
		hb2.setSpacing(10);
		hb3.setSpacing(10);
		hb4.setSpacing(10);
		
		vb1.getChildren().addAll(hb0,hb1,hb2,hb3,hb4);
		vb1.setSpacing(10);
		pane.getChildren().add(vb1);
		Scene scene = new Scene(pane,300,300);
		primaryStage.setTitle("商品栏");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		cbo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String aaa;
				aaa = cbo.getValue();
				if(aaa == "三四食堂"){
					SSShangpinCaidan SS = new SSShangpinCaidan();
					Stage stage = new Stage();
					try {
						SS.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(aaa == "友园"){
					YYShangpinCaidan YY = new YYShangpinCaidan();
					Stage stage = new Stage();
					try {
						YY.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(aaa == "桃源居"){
					TYJShangpinCaidan TYJ = new TYJShangpinCaidan();
					Stage stage = new Stage();
					try {
						TYJ.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(aaa == "桃李园"){
					TLYShangpinCaidan TLY = new TLYShangpinCaidan();
					Stage stage = new Stage();
					try {
						TLY.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		}
		);
	}
	/*public static void main(String args[]){
		launch(args);
	}*/

}
