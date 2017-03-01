package DataBase;

import java.sql.ResultSet;//��ѯ����ӿ�
import java.util.ArrayList;
import java.util.List;
import Thing.Movies;


public class MoviesDao {
	//���ݱ�ţ���õ���ʵ��
	public static Movies selectmovie(int id) {
		String sql = "select *  from movie where id='" + id +"'";//select��ѯ���
		ResultSet rs = BaseDao.executeQuery(sql);//��ȡ�����
		Movies movie = null;
		try {
			if (rs.next()) {//�жϽ�������Ƿ�����һ����¼
				movie = new Movies();//����һ��movie�����
				movie.setId(rs.getInt("idMovies"));//Ϊmovie����id�ֶθ�ֵ
				movie.setName1(rs.getString("Name"));//Ϊmovie����name�ֶθ�ֵ
				movie.setShowingtime("ShowningTime");//Ϊmovie����ShowningTime�ֶθ�ֵ
				movie.setPrice(rs.getDouble("Price"));//Ϊmovie����price�ֶθ�ֵ
				movie.setSeat(rs.getInt("Seat"));//Ϊmovie�����ֶθ�ֵ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return movie;//����movie�����
	}
	
	public static List selectBookList(String sql) {
		List list = new ArrayList();//����һ��List�б�
		ResultSet rs = BaseDao.executeQuery(sql);//���ز�ѯ��Ľ����
		try {
			while (rs.next()) {//��������л�����һ����¼ʱ
			Movies	movie = new Movies();//����һ��movie�����
			movie.setId(rs.getInt("idMovies"));//Ϊmovie����id�ֶθ�ֵ
			movie.setName1(rs.getString("Name"));//Ϊmovie����name�ֶθ�ֵ
			movie.setShowingtime("ShowningTime");//Ϊmovie����ShowningTime�ֶθ�ֵ
			movie.setPrice(rs.getDouble("Price"));//Ϊmovie����price�ֶθ�ֵ
			movie.setSeat(rs.getInt("Seat"));//Ϊmovie�����ֶθ�ֵ
				list.add(movie);//��book�������ӵ�list�б���
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
	
}
