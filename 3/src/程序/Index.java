package ³ÌÐò;

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
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
@SuppressWarnings("unused")
public class Index extends Application {

	@Override
	public void start(final Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane IndexPane = new GridPane();
		IndexPane.setAlignment(Pos.CENTER);
		IndexPane.setPadding(new Insets(20,20,20,20));
		IndexPane.setHgap(10);    
		IndexPane.setVgap(10);  
		Button btDL = new Button("µÇÂ¼");  
		IndexPane.add(btDL, 1, 1);
		btDL.setPrefSize(50, 50);
		Button btZC = new Button("×¢²á");  
		IndexPane.add(btZC, 1, 2);
		btZC.setPrefSize(50, 50);
		Scene IndexScene = new Scene(IndexPane,300,300);
		primaryStage.setTitle("Index");
		primaryStage.setScene(IndexScene);
		
		primaryStage.show();
		btZC.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Zhuce z = new Zhuce();
				Stage stage = new Stage();
				try {
					z.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
			
		btDL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				StuDenglu d = new StuDenglu();
				Stage stage = new Stage();
				try {
					d.start(stage);
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
