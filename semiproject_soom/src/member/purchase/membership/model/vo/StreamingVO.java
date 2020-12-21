package member.purchase.membership.model.vo;

import java.sql.Date;

public class StreamingVO {
	private String mem_id;
	private String ms_no;
	private Date ms_str_date;
	private Date ms_str_left;
	public StreamingVO() {
		
	}
	public StreamingVO(String mem_id, String ms_no, Date ms_str_date, Date ms_str_left) {
		super();
		this.mem_id = mem_id;
		this.ms_no = ms_no;
		this.ms_str_date = ms_str_date;
		this.ms_str_left = ms_str_left;
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
	public Date getMs_str_date() {
		return ms_str_date;
	}
	public void setMs_str_date(Date ms_str_date) {
		this.ms_str_date = ms_str_date;
	}
	public Date getMs_str_left() {
		return ms_str_left;
	}
	public void setMs_str_left(Date ms_str_left) {
		this.ms_str_left = ms_str_left;
	}
	@Override
	public String toString() {
		return "StreamingVO [mem_id=" + mem_id + ", ms_no=" + ms_no + ", ms_str_date=" + ms_str_date + ", ms_str_left="
				+ ms_str_left + "]";
	}
	
}