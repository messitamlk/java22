package dazuoye;

import java.awt.BorderLayout;
import DataBase.MoviesDao;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;//ϵͳ��ɫ
import java.awt.event.ActionEvent;//�����¼�
import java.awt.event.ActionListener;//�¼�������
import java.sql.ResultSet;
import java.util.List;


import DataBase.BaseDao;
import DataBase.MoviesDao;
import Thing.Movies;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class OnShowning extends Application {
	
	public void start(Stage primaryStage) throws Exception {
	 
		// TODO Auto-generated method stub
		String[] heads = { "��Ӱ���", "ӰƬ����",  "Ʊ��", "ʣ����λ��", "��ӳʱ��" };
		String sql = "select *  from movies";//select��ѯ���
		ResultSet rs = BaseDao.executeQuery(sql);//��ȡ�����
		
		VBox vb = new VBox();
	
	while (rs.next()) {//�жϽ�������Ƿ�����һ����¼
		
			vb.getChildren().add(new Label(" "+rs.getInt("idMovies")+" "+rs.getString("Name")+" "+rs.getDouble("Price")+" "+rs.getInt("Seat")));		
		}
		Scene scene = new Scene(vb,300,300);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();


		
		
		}

}

