package dazuoye;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.awt.BorderLayout;
import DataBase.MoviesDao;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;//系统颜色

import java.awt.event.ActionListener;//事件监听者
import java.sql.ResultSet;
import java.util.List;


import DataBase.BaseDao;
import DataBase.MoviesDao;
import Thing.Movies;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
@SuppressWarnings("unused")
public class Setting extends Application {

	public void start(final Stage primaryStage) throws Exception {
		GridPane SettingPane = new GridPane();
		SettingPane.setAlignment(Pos.CENTER);
		SettingPane.setPadding(new Insets(20,20,20,20));
		SettingPane.setHgap(20);    
		SettingPane.setVgap(20);
		Button Setting = new Button("新增电影");  
		SettingPane.add(Setting, 1, 1);
		Setting.setPrefSize(150, 30);
		Scene SettingScene = new Scene(SettingPane,300,300);
		primaryStage.setTitle("设置");
		primaryStage.setScene(SettingScene);
		primaryStage.show();
	
		Setting.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Addmoives addmoives= new Addmoives();
				Stage stage = new Stage();
				try {
					addmoives.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
		}
		
		
		}
		
		


