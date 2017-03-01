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
public class BookingPage extends Application {

	public void start(final Stage primaryStage) throws Exception{
		String sql = "select  Name,Price from movies";//select查询语句
		ResultSet rs = BaseDao.executeQuery(sql);//获取结果集
		GridPane DLPane = new GridPane();
		GridPane p_ane = new GridPane();
		DLPane.setAlignment(Pos.CENTER);
		DLPane.setPadding(new Insets(20,20,20,20));
		DLPane.setHgap(10);
		DLPane.setVgap(10);
			final ComboBox comboBox = new ComboBox();
			//final ComboBox priceBox = new ComboBox();
			String[] _name= new String[20];
			double[] _price = new double[20];
			int i=0;
			while (rs.next()){
				_name[i] =rs.getString("Name");
				_price[i]= rs.getDouble("Price");
				i++;
			}
			
			comboBox.getItems().addAll(_name);
			for(i=0;i<20;i++)
			{
				if(_price[i]==0)break;
			//	priceBox.getItems().addAll(_price[i]);
			}
			comboBox.setValue(_name[0]);
			//priceBox.setValue(_price[0]);
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		hb2.getChildren().add(new Label("订票张数:")); //标签名，列，排
		TextField Ticketscounts = new TextField();
		hb2.getChildren().add(Ticketscounts);
		// int counts = Integer.parseInt(Ticketscounts.getText());
		// ObservableList Name = comboBox.getItems();
		Button btSureDL = new Button("确定");  //按钮名
		Button btCancelDL = new Button("取消"); 
		hb3.getChildren().add(btSureDL);
		hb3.getChildren().add(btCancelDL);
		hb1.getChildren().add(comboBox);
		//hb3.getChildren().add(priceBox);
		hb1.setAlignment(Pos.TOP_CENTER);
		hb3.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		VBox vb = new VBox();
		
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		vb.getChildren().add(hb3);
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
				int ticketnum=Integer.parseInt(Ticketscounts.getText());
				String name =String.valueOf(comboBox.getValue()) ;
			
			
				BookingSuccess Booking= new BookingSuccess( );
				 Booking.setCounts(ticketnum);
				 Booking.setname(name);
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
		
		


