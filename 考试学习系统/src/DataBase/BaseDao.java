package DataBase;

import java.sql.Connection;//数据库连接接口
import java.sql.DriverManager;//管理驱动程序类
import java.sql.ResultSet;//查询结果接口，表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。 
import java.sql.SQLException;//异常信息,提供数据库访问错误或其他错误
import java.util.ArrayList; 
import java.util.List;

import Class.Question;
 

public class BaseDao {
	protected static String driver = "com.mysql.jdbc.Driver"; // 数据库驱动
	protected static String url = "jdbc:mysql://localhost:3306/movingdatebase"; // 连接url
	protected static String dbUser = "root"; // 数据库用户名
	protected static String dbPwd = "138814"; // 数据库密码
	private static Connection conn = null;//与一个特定数据库的连接(会话)。执行SQL语句和返回一个连接的上下文结果。
	// 构造方法，创建数据库连接
	private BaseDao() {
			try {
				if (conn == null) {
					//返回与带有给定字符串名的类或接口相关联的 Class 对象。
					Class.forName(driver); // 加载数据库驱动
					conn = DriverManager.getConnection(url, dbUser, dbPwd); // 建立数据库连接
					//管理一组数据库程序的基本服务
				} else
					return;
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	// 执行数据库查询操作
		public static ResultSet executeQuery(String sql) {
			try {
				if (conn == null)
					new BaseDao();
				/*创建一个Statement对象发送SQL语句语到数据库。通常使用语句执行SQL语句没有参数对象。
				TYPE_SCROLL_SENSITIVE 该常量指示可滚动并且通常受 ResultSet 底层数据更改影响的
				 ResultSet 对象的类型。
				 创建一个 Statement 对象，该对象将生成具有给定类型和并发性的 ResultSet 对象。
				 */
				//TYPE_SCROLL_SENSITIVE该常量指示可滚动并且通常受 ResultSet 底层数据更改影响的 ResultSet 对象的类型。
				//CONCUR_UPDATABLE该常量指示可以更新的 ResultSet 对象的并发模式。
				return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE).executeQuery(sql); // 执行数据库查询
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

		// 执行数据库更新操作
		public static int executeUpdate(String sql) {

			try {
				if (conn == null)
					new BaseDao();
				//创建一个statement对象发送到数据库的SQL语句。通常使用语句执行SQL语句没有参数对象。
				return conn.createStatement().executeUpdate(sql); // 执行数据库更新
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return -1;
			} finally {
			}
		}

		public static void close() {//关闭连接
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
}
