package ����;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class ZCCG extends Application{
	public void start(final Stage primaryStage,String xh,String mima){
		GridPane ZCCG_pane = new GridPane();
		ZCCG_pane.setAlignment(Pos.CENTER);
		Button btReturn = new Button("����");
		Label l = new Label("ע��ɹ���");
		ZCCG_pane.add(l,0,0);	
		Label l1 = new Label("�˺ţ�"+xh);
		ZCCG_pane.add(l1,0,1);	
		Label l2 = new Label("���룺"+mima);
		ZCCG_pane.add(l2,0,2);	
		ZCCG_pane.add(btReturn,2,3);
		btReturn.setAlignment(Pos.BOTTOM_RIGHT);
		Scene CGScene1 = new Scene(ZCCG_pane,300,300);
		primaryStage.setTitle("���");
		primaryStage.setScene(CGScene1);
		primaryStage.show();
		btReturn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Index index = new Index();
				Stage stage = new Stage();
				try {
					index.start(stage);
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
