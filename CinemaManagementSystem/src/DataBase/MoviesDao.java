package DataBase;

import java.sql.ResultSet;//查询结果接口
import java.util.ArrayList;
import java.util.List;
import Thing.Movies;


public class MoviesDao {
	//根据编号，获得单个实体
	public static Movies selectmovie(int id) {
		String sql = "select *  from movie where id='" + id +"'";//select查询语句
		ResultSet rs = BaseDao.executeQuery(sql);//获取结果集
		Movies movie = null;
		try {
			if (rs.next()) {//判断结果集中是否还有下一条记录
				movie = new Movies();//创建一个movie类对象
				movie.setId(rs.getInt("idMovies"));//为movie类中id字段赋值
				movie.setName1(rs.getString("Name"));//为movie类中name字段赋值
				movie.setShowingtime("ShowningTime");//为movie类中ShowningTime字段赋值
				movie.setPrice(rs.getDouble("Price"));//为movie类中price字段赋值
				movie.setSeat(rs.getInt("Seat"));//为movie类中字段赋值
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return movie;//返回movie类对象
	}
	
	public static List selectBookList(String sql) {
		List list = new ArrayList();//创建一个List列表
		ResultSet rs = BaseDao.executeQuery(sql);//返回查询后的结果集
		try {
			while (rs.next()) {//当结果集中还有下一条记录时
			Movies	movie = new Movies();//创建一个movie类对象
			movie.setId(rs.getInt("idMovies"));//为movie类中id字段赋值
			movie.setName1(rs.getString("Name"));//为movie类中name字段赋值
			movie.setShowingtime("ShowningTime");//为movie类中ShowningTime字段赋值
			movie.setPrice(rs.getDouble("Price"));//为movie类中price字段赋值
			movie.setSeat(rs.getInt("Seat"));//为movie类中字段赋值
				list.add(movie);//将book类对象添加到list列表中
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
	
}
