package manager.managerPost.vo;

import java.sql.Date;

public class ManagerPostVo {
//	P_NO      NOT NULL VARCHAR2(7)      
//	P_NAME    NOT NULL VARCHAR2(90)   
//	P_CONTENT NOT NULL VARCHAR2(4000) 
//	MNG_ID             VARCHAR2(30)   
//	P_HITS             NUMBER(8)      
//	P_TIME             DATE
	
	private String p_no;
	private String p_name;
	private String p_content;
	private String mng_id;
	private int p_hits;
	private Date p_time;
	
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getMng_id() {
		return mng_id;
	}
	public void setMng_id(String mng_id) {
		this.mng_id = mng_id;
	}
	public int getP_hits() {
		return p_hits;
	}
	public void setP_hits(int p_hits) {
		this.p_hits = p_hits;
	}
	public Date getP_time() {
		return p_time;
	}
	public void setP_time(Date p_time) {
		this.p_time = p_time;
	}
}
