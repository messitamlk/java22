package Thing;

import java.sql.Date;

/**
 * @author Administrator
 *
 */
public class Movies{
	private String M_name;	//��Ӱ����
	private int    Seat;//��λ��
	private String Showingtime;	//��ӳʱ��
	private int id;	//��Ӱ���
	private double price;	//Ʊ��
	
	/**
	 * @return the author
	 */
	public String getName1() {
		return M_name;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setShowingtime(String name) {
		this.Showingtime = name;
	}
	public String getShowingtime() {
		return Showingtime;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setName1(String name) {
		this.M_name = name;
	}
	
	/**
	 * @return the id
	 */
	public int getSeat() {
		return  Seat;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setSeat(int id1) {
		this.Seat = id1;
	}
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id1) {
		this.id = id1;
	}
	


	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
