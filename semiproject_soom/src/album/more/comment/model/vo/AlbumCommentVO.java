package album.more.comment.model.vo;

import java.sql.Date;
//한글
public class AlbumCommentVO {
	private int al_co_no;
	private String mem_id;
	private String al_no;
	private String al_cont;
	private int al_ref;
	private int al_step ;
	private int al_level ;
	private int al_likes ;
	private int al_hates ;
	private int al_report ;
	private Date al_date;
	
	
	public int getAl_co_no() {
		return al_co_no;
	}
	public void setAl_co_no(int al_co_no) {
		this.al_co_no = al_co_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getAl_no() {
		return al_no;
	}
	public void setAl_no(String al_no) {
		this.al_no = al_no;
	}
	public String getAl_cont() {
		return al_cont;
	}
	public void setAl_cont(String al_cont) {
		this.al_cont = al_cont;
	}
	public int getAl_ref() {
		return al_ref;
	}
	public void setAl_ref(int al_ref) {
		this.al_ref = al_ref;
	}
	public int getAl_step() {
		return al_step;
	}
	public void setAl_step(int al_step) {
		this.al_step = al_step;
	}
	public int getAl_level() {
		return al_level;
	}
	public void setAl_level(int al_level) {
		this.al_level = al_level;
	}
	public int getAl_likes() {
		return al_likes;
	}
	public void setAl_likes(int al_likes) {
		this.al_likes = al_likes;
	}
	public int getAl_hates() {
		return al_hates;
	}
	public void setAl_hates(int al_hates) {
		this.al_hates = al_hates;
	}
	public int getAl_report() {
		return al_report;
	}
	public void setAl_report(int al_report) {
		this.al_report = al_report;
	}
	public Date getAl_date() {
		return al_date;
	}
	public void setAl_date(Date al_date) {
		this.al_date = al_date;
	}
	
	//닉네임
	private String mem_name;
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
}
