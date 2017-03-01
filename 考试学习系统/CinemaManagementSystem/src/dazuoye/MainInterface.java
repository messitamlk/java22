package dazuoye;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
@SuppressWarnings("unused")
public class MainInterface extends Application {

	@Override
	public void start(final Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane MainInterfacePane = new GridPane();
		ImageView  imageview=new ImageView(new Image("1.jpg"));
		//MainInterfacePane.getChildren().add(imageview);
		MainInterfacePane.setAlignment(Pos.CENTER);
		MainInterfacePane.setPadding(new Insets(20,20,20,20));
		MainInterfacePane.setHgap(20);    
		MainInterfacePane.setVgap(20);  
		Button btBook = new Button("订票");  
		MainInterfacePane.add(btBook, 1, 1);
		btBook.setPrefSize(150, 30);
		Button btReturning = new Button("退票");  
		MainInterfacePane.add(btReturning, 1, 2);
		btReturning.setPrefSize(150, 30);
		Button btOnShwoning = new Button("正在上映");  
		MainInterfacePane.add( btOnShwoning, 1, 3);
		 btOnShwoning.setPrefSize(150, 30);
		 Button btSetting = new Button("设置");  
			MainInterfacePane.add( btSetting, 1, 4);
			btSetting.setPrefSize(150, 30);
		Scene MainInterfaceScene = new Scene(MainInterfacePane,300,300);
		primaryStage.setTitle("辽大信息学院电影院票务管理系统");
		primaryStage.setScene(MainInterfaceScene);
		primaryStage.show();
		btBook.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				BookingPage Booking= new BookingPage();
				Stage stage = new Stage();
				try {
					Booking.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
			
		btSetting.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Setting Setting= new Setting();
				Stage stage = new Stage();
				try {
					Setting.start(stage);
					//d.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
		btReturning.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				ReturningTicket Returning= new ReturningTicket();
				Stage stage = new Stage();
				try {
					Returning.start(stage);//d.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
		btOnShwoning.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				OnShowning OnShwoning= new OnShowning();
				Stage stage = new Stage();
				try {
					OnShwoning.start(stage);//d.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
			
	}
	public static void main(String args[]){
		launch(args);
	}

}
