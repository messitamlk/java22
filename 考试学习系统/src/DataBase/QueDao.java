package DataBase;

import java.sql.ResultSet;//��ѯ����ӿ�

import Class.Question;
public class QueDao{
	//���ݱ�ţ���õ���ʵ��
	public  Question selectquestion(int id) {
		String sql = "select *  from que where queid='" + id +"'";//select��ѯ���
		ResultSet rs = BaseDao.executeQuery(sql);//��ȡ�����
		Question question = null;
		try {
			if (rs.next()) {//�жϽ�������Ƿ�����һ����¼
				question  = new Question();//����һ��movie�����
				question.setid(rs.getInt("queid"));//Ϊquestion����queid�ֶθ�ֵ
				question.setque(rs.getString("que"));//Ϊquestion����que�ֶθ�ֵ
				question.setans(rs.getString("ans"));//Ϊquestion����ans�ֶθ�ֵ
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return question;//����question�����
	}
	
	}
	
