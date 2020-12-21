package member.purchase.membership.model.vo;

import java.sql.Date;

public class BuypackageVO {
	private String mem_id;
	private String ms_no;
	private Date ms_p_date;
	private Date ms_p_left;
	public BuypackageVO() {
		
	}
	
	public BuypackageVO(String mem_id, String ms_no, Date ms_p_date, Date ms_p_left) {
		super();
		this.mem_id = mem_id;
		this.ms_no = ms_no;
		this.ms_p_date = ms_p_date;
		this.ms_p_left = ms_p_left;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMs_no() {
		return ms_no;
	}
	public void setMs_no(String ms_no) {
		this.ms_no = ms_no;
	}
	public Date getMs_p_date() {
		return ms_p_date;
	}
	public void setMs_p_date(Date ms_p_date) {
		this.ms_p_date = ms_p_date;
	}
	public Date getMs_p_left() {
		return ms_p_left;
	}
	public void setMs_p_left(Date ms_p_left) {
		this.ms_p_left = ms_p_left;
	}
	
	
}