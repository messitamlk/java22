package dazuoye;

import java.awt.BorderLayout;
import DataBase.MoviesDao;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;//系统颜色
import java.awt.event.ActionEvent;//监听事件
import java.awt.event.ActionListener;//事件监听者
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
		String[] heads = { "电影编号", "影片名称",  "票价", "剩余座位数", "上映时间" };
		String sql = "select *  from movies";//select查询语句
		ResultSet rs = BaseDao.executeQuery(sql);//获取结果集
		
		VBox vb = new VBox();
	
	while (rs.next()) {//判断结果集中是否还有下一条记录
		
			vb.getChildren().add(new Label(" "+rs.getInt("idMovies")+" "+rs.getString("Name")+" "+rs.getDouble("Price")+" "+rs.getInt("Seat")));		
		}
		Scene scene = new Scene(vb,300,300);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();


		
		
		}

}

