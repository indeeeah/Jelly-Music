package music.more.comment.model.vo;

import java.sql.Date;

public class MusicCommentVO {
	private int mu_co_no;
	private String mem_id;
	private String mu_no;
	private String mu_cont;
	private int mu_ref;
	private int mu_step;
	private int mu_level;
	private int mu_likes;
	private int mu_hates;
	private int mu_report;
	private Date mu_date;
	
	
	public int getMu_co_no() {
		return mu_co_no;
	}
	public void setMu_co_no(int mu_co_no) {
		this.mu_co_no = mu_co_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMu_no() {
		return mu_no;
	}
	public void setMu_no(String mu_no) {
		this.mu_no = mu_no;
	}
	public String getMu_cont() {
		return mu_cont;
	}
	public void setMu_cont(String mu_cont) {
		this.mu_cont = mu_cont;
	}
	public int getMu_ref() {
		return mu_ref;
	}
	public void setMu_ref(int mu_ref) {
		this.mu_ref = mu_ref;
	}
	public int getMu_step() {
		return mu_step;
	}
	public void setMu_step(int mu_step) {
		this.mu_step = mu_step;
	}
	public int getMu_level() {
		return mu_level;
	}
	public void setMu_level(int mu_level) {
		this.mu_level = mu_level;
	}
	public int getMu_likes() {
		return mu_likes;
	}
	public void setMu_likes(int mu_likes) {
		this.mu_likes = mu_likes;
	}
	public int getMu_hates() {
		return mu_hates;
	}
	public void setMu_hates(int mu_hates) {
		this.mu_hates = mu_hates;
	}
	public int getMu_report() {
		return mu_report;
	}
	public void setMu_report(int mu_report) {
		this.mu_report = mu_report;
	}
	public Date getMu_date() {
		return mu_date;
	}
	public void setMu_date(Date mu_date) {
		this.mu_date = mu_date;
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
