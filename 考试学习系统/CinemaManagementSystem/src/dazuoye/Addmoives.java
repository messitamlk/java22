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
public class Addmoives extends Application {

	public void start(final Stage primaryStage) throws Exception{
		String sql = "select  Name,Price from movies";//select查询语句
		ResultSet rs = BaseDao.executeQuery(sql);//获取结果集
		GridPane DLPane = new GridPane();
		GridPane p_ane = new GridPane();
		DLPane.setAlignment(Pos.CENTER);
		DLPane.setPadding(new Insets(20,20,20,20));
		DLPane.setHgap(10);
		DLPane.setVgap(10);
			
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4= new HBox();
		HBox hb5= new HBox();
		HBox hb6= new HBox();
		hb3.getChildren().add(new Label("电影名:"));
		hb1.getChildren().add(new Label("编    号:"));
		hb2.getChildren().add(new Label("坐席数:")); //标签名，列，排
		hb5.getChildren().add(new Label("票     价:"));
		hb6.getChildren().add(new Label("上映时间:"));
		TextField NewmoivesName= new TextField();
		TextField NewmoivesId = new TextField();
		TextField  NewmoivesSeat = new TextField();
		TextField  NewmoivesPrice = new TextField();
		TextField  ShowTime= new TextField();
		hb3.getChildren().add(NewmoivesSeat);
		hb1.getChildren().add(NewmoivesId);
		hb2.getChildren().add(NewmoivesName);
		hb5.getChildren().add(NewmoivesPrice);
		hb6.getChildren().add( ShowTime);
	
		Button btSureDL = new Button("确定");  //按钮名
		Button btCancelDL = new Button("取消"); 
		hb4.getChildren().addAll(new Label("                  "),btSureDL,new Label("                  "),btCancelDL);
		
		hb1.setAlignment(Pos.TOP_CENTER);
		hb3.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		VBox vb = new VBox();
		vb.getChildren().add(hb6);
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		vb.getChildren().add(hb3);
		vb.getChildren().add(hb5);
		vb.getChildren().add(hb4); 
		
		vb.setSpacing(10);
		DLPane.getChildren().add(vb);
		
		
		Scene DLScene = new Scene(DLPane,300,300);
		Scene scene = new Scene(p_ane,300,300);
		primaryStage.setTitle("订票");
		primaryStage.setScene(DLScene);
		primaryStage.show();
		btSureDL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage stage = new Stage();
				String name=NewmoivesName.getText();
				int  id=Integer.parseInt( NewmoivesId.getText());
				int seat=Integer.parseInt(NewmoivesSeat.getText());
			double price=Double.parseDouble(NewmoivesPrice .getText());
			String times = ShowTime.getText();
				
				String sql2 = "insert into movies (idMovies,Name,Price,Seat,ShowningTime)values('"+id+"','"+name+"','"+price+"','"+seat+"','"+times+"')";
				int i = BaseDao.executeUpdate(sql2);
				if (i == 1) {
					vb.getChildren().add(new Label("添加成功！"));
					
				}
		 
			
				BookingSuccess Booking= new BookingSuccess( );
			
				try {
					Booking.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				primaryStage.close();
			}
		}
		);
		btCancelDL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				MainInterface Booking= new MainInterface();
				Stage stage = new Stage();
				try {
					Booking.start(stage);
					primaryStage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				primaryStage.close();
			}
		}
		);}}
		
		


