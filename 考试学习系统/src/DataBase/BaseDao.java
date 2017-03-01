package DataBase;

import java.sql.Connection;//���ݿ����ӽӿ�
import java.sql.DriverManager;//��������������
import java.sql.ResultSet;//��ѯ����ӿڣ���ʾ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ� 
import java.sql.SQLException;//�쳣��Ϣ,�ṩ���ݿ���ʴ������������
import java.util.ArrayList; 
import java.util.List;

import Class.Question;
 

public class BaseDao {
	protected static String driver = "com.mysql.jdbc.Driver"; // ���ݿ�����
	protected static String url = "jdbc:mysql://localhost:3306/movingdatebase"; // ����url
	protected static String dbUser = "root"; // ���ݿ��û���
	protected static String dbPwd = "138814"; // ���ݿ�����
	private static Connection conn = null;//��һ���ض����ݿ������(�Ự)��ִ��SQL���ͷ���һ�����ӵ������Ľ����
	// ���췽�����������ݿ�����
	private BaseDao() {
			try {
				if (conn == null) {
					//��������и����ַ����������ӿ�������� Class ����
					Class.forName(driver); // �������ݿ�����
					conn = DriverManager.getConnection(url, dbUser, dbPwd); // �������ݿ�����
					//����һ�����ݿ����Ļ�������
				} else
					return;
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	// ִ�����ݿ��ѯ����
		public static ResultSet executeQuery(String sql) {
			try {
				if (conn == null)
					new BaseDao();
				/*����һ��Statement������SQL����ﵽ���ݿ⡣ͨ��ʹ�����ִ��SQL���û�в�������
				TYPE_SCROLL_SENSITIVE �ó���ָʾ�ɹ�������ͨ���� ResultSet �ײ����ݸ���Ӱ���
				 ResultSet ��������͡�
				 ����һ�� Statement ���󣬸ö������ɾ��и������ͺͲ����Ե� ResultSet ����
				 */
				//TYPE_SCROLL_SENSITIVE�ó���ָʾ�ɹ�������ͨ���� ResultSet �ײ����ݸ���Ӱ��� ResultSet ��������͡�
				//CONCUR_UPDATABLE�ó���ָʾ���Ը��µ� ResultSet ����Ĳ���ģʽ��
				return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE).executeQuery(sql); // ִ�����ݿ��ѯ
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

		// ִ�����ݿ���²���
		public static int executeUpdate(String sql) {

			try {
				if (conn == null)
					new BaseDao();
				//����һ��statement�����͵����ݿ��SQL��䡣ͨ��ʹ�����ִ��SQL���û�в�������
				return conn.createStatement().executeUpdate(sql); // ִ�����ݿ����
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return -1;
			} finally {
			}
		}

		public static void close() {//�ر�����
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
}
