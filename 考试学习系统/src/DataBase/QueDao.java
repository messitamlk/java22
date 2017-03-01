package DataBase;

import java.sql.ResultSet;//查询结果接口

import Class.Question;
public class QueDao{
	//根据编号，获得单个实体
	public  Question selectquestion(int id) {
		String sql = "select *  from que where queid='" + id +"'";//select查询语句
		ResultSet rs = BaseDao.executeQuery(sql);//获取结果集
		Question question = null;
		try {
			if (rs.next()) {//判断结果集中是否还有下一条记录
				question  = new Question();//创建一个movie类对象
				question.setid(rs.getInt("queid"));//为question类中queid字段赋值
				question.setque(rs.getString("que"));//为question类中que字段赋值
				question.setans(rs.getString("ans"));//为question类中ans字段赋值
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return question;//返回question类对象
	}
	
	}
	
