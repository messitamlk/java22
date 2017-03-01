package 程序;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
@SuppressWarnings("unused")
public class StuDenglu extends Application {
	public void start(final Stage primaryStage) throws Exception{
		GridPane DLPane = new GridPane();
		GridPane p_ane = new GridPane();
		DLPane.setAlignment(Pos.CENTER);
		DLPane.setPadding(new Insets(20,20,20,20));
		DLPane.setHgap(10);
		DLPane.setVgap(10);
		
		
		Label btStuDL = new Label("学生登录");
		p_ane.getChildren().add(btStuDL);
		Button btShiDL = new Button("食堂登录");
		//GridPane.setHalignment(btStuDL, HPos.RIGHT);
		p_ane.getChildren().add(btShiDL);
		Button btManDL = new Button("管理员登录");
		HBox hb = new HBox();
		hb.getChildren().add(btStuDL);
		hb.getChildren().add(btShiDL);
		hb.getChildren().add(btManDL);
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		hb1.getChildren().add(new Label("学号:"));   //标签名，列，排
		hb1.getChildren().add(new TextField());
		hb2.getChildren().add(new Label("密码:"));
		hb2.getChildren().add(new PasswordField());
		Button btSureDL = new Button("确定");  //按钮名
		hb3.getChildren().add(btSureDL);
		hb3.setAlignment(Pos.BOTTOM_RIGHT);
		VBox vb = new VBox();
		vb.getChildren().add(hb);
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		vb.getChildren().add(hb3);
		vb.setSpacing(10);
		DLPane.getChildren().add(vb);
		
		
		Scene DLScene = new Scene(DLPane,300,300);
		Scene scene = new Scene(p_ane,300,300);
		primaryStage.setTitle("登录");
		primaryStage.setScene(DLScene);
		primaryStage.show();
		btSureDL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				TLYShangpinCaidan Shang = new TLYShangpinCaidan();
				Stage stage = new Stage();
				try {
					Shang.start(stage);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				primaryStage.close();
			}
		}
		);
		btShiDL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				ShiDenglu Shi = new ShiDenglu();
				Stage stage = new Stage();
				try {
					Shi.start(stage);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				primaryStage.close();
			}
		}
		);
		btManDL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				ManDenglu Man = new ManDenglu();
				Stage stage = new Stage();
				try {
					Man.start(stage);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				primaryStage.close();
			}
		}
		);
		/*index i = new index();
		Stage stage = new Stage();
		i.start(stage);*/
	}

}
