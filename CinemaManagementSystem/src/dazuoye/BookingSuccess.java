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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.awt.BorderLayout;
import DataBase.MoviesDao;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;//ϵͳ��ɫ

import java.awt.event.ActionListener;//�¼�������
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
public  class BookingSuccess extends Application {
private int counts;
private String name;
private int last;
public void  setCounts(int a){this.counts= a;}
public void  setname(String a){this.name= a;}
	public void start(final Stage primaryStage) throws Exception{
		
		
		String sql = "select Price,Seat from movies WHERE Name='"+name+"'";//select��ѯ���
		ResultSet rs = BaseDao.executeQuery(sql);//��ȡ�����
		BorderPane DLPane = new BorderPane();
		//GridPane p_ane = new GridPane();
		//DLPane.setAlignment(Pos.CENTER);
		//DLPane.setPadding(new Insets(20,20,20,20));
		//DLPane.setHgap(10);
		//DLPane.setVgap(10);
		HBox vb = new HBox();
		while (rs.next()){
			
			double moneny = rs.getDouble("Price")*counts;
			last= rs.getInt("Seat")-counts;
			String sql2 = "update movies set  Seat="+last+" WHERE Name='"+name+"'";
			int i = BaseDao.executeUpdate(sql2);
			if (i == 1) {
				vb.getChildren().add(new Label("\n\n\n\n\n\n\n\n\n"+"                  ��Ҫ���:"+rs.getDouble("Price")*counts+" "+"ʣ����λ����"+last));
				
			}
		}
		
		//HBox hb1 = new HBox();
		VBox hb2 = new VBox();
		HBox hb3 = new HBox();
		Label label=new Label("                                   ");
		Button btCancelDL = new Button("ȷ��");
		hb3.getChildren().addAll(label,btCancelDL);
	
		DLPane.setCenter(vb);
		hb2.getChildren().addAll(hb3);
		 DLPane .setBottom(hb2);
		//hb1.getChildren().add(btCancelDL);
		//hb1.setAlignment(Pos.CENTER);
		//vb.getChildren().add(hb1);
		//DLPane.setBottom(hb2);
		Scene scene = new Scene( DLPane ,300,300);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
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
		);

	}}