package 程序;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
@SuppressWarnings("unused")
public class Zhuce extends Application {
	public void start(final Stage primaryStage) throws Exception{
		GridPane ZCPane = new GridPane();
		GridPane p_ane = new GridPane();
		ZCPane.setAlignment(Pos.CENTER);
		ZCPane.setPadding(new Insets(20,20,20,20));
		ZCPane.setHgap(10);
		ZCPane.setVgap(10);
		
		
		Button btStuZC = new Button("学生注册");
		p_ane.getChildren().add(btStuZC);
		/*Button btShiZC = new Button("食堂注册");
		//GridPane.setHalignment(btStuZC, HPos.RIGHT);
		p_ane.getChildren().add(btShiZC);*/
		Button btManZC = new Button("管理员注册");
		HBox hb = new HBox();
		hb.getChildren().add(btStuZC);
		//hb.getChildren().add(btShiZC);
		hb.getChildren().add(btManZC);
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		Label lb = new Label("账        号:");
		hb1.getChildren().add(lb);   //标签名，列，排
		final TextField tf = new TextField();
		hb1.getChildren().add(tf);
		hb2.getChildren().add(new Label("密         码:"));
		final PasswordField mima = new PasswordField();
		hb2.getChildren().add(mima);
		hb3.getChildren().add(new Label("确 认 密 码:"));
		final PasswordField qrmm = new PasswordField();
		hb3.getChildren().add(qrmm);
		Button btSureZC = new Button("确定");  //按钮名
		Button btQuitZC = new Button("放弃");  //按钮名
		HBox hb4 = new HBox();
		hb4 .getChildren().add(btQuitZC);
		hb4.getChildren().add(new Label("                               "));
		hb4 .getChildren().add(btSureZC);
		hb4.setAlignment(Pos.BOTTOM_RIGHT);
		VBox vb = new VBox();
		vb.getChildren().add(hb);
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		vb.getChildren().add(hb3);
		vb.getChildren().add(hb4);
		vb.setSpacing(10);
		ZCPane.getChildren().add(vb);
		
		
		Scene ZCScene = new Scene(ZCPane,300,300);
		Scene scene = new Scene(p_ane,300,300);
		primaryStage.setTitle("注册");
		primaryStage.setScene(ZCScene);
		primaryStage.show();
		btSureZC.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(mima.getText() == qrmm.getText()){	
					ZCCG CG1 = new ZCCG();
					Stage stage = new Stage();
					try {
					
						CG1.start(stage,tf.getText(),mima.getText());
						primaryStage.close();
					} catch (Exception e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		);
		btQuitZC.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Index index2 = new Index();
				Stage stage = new Stage();
				try {
					index2.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
		/*index i = new index();
		Stage stage = new Stage();
		i.start(stage);*/
	}

	


}
