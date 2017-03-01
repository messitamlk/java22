package window;

import java.sql.ResultSet;
import java.util.Random;

import Class.Question;
import DataBase.BaseDao;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
public class Interface extends Application{

	
	@Override

	public void start(Stage primaryStage){
		
		Button Chioce = new Button("选题");
		StackPane pane =new StackPane();
		pane.getChildren().add(Chioce);
		Scene scene = new Scene( pane,500,400);
		
		
		primaryStage.setTitle("考试学习系统");
		primaryStage.setScene(scene);
		primaryStage.show();
		Chioce.setOnAction(new EventHandler<ActionEvent>() {
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
			
	}

	
public   static void main(String[]args){
		
		Application.launch( args);
		
		
		
		
}
}