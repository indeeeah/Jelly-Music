package artist.more.comment.model.vo;

import java.sql.Date;
//한글

public class ArtistCommentVO {
	private int art_co_no;
	private String mem_id;
	private String art_no;
	private String art_cont;
	private int art_ref;
	private int art_step;
	private int art_level;
	private int art_likes;
	private int art_hates;
	private int art_report;
	private Date art_date;
	
	public int getArt_co_no() {
		return art_co_no;
	}
	public void setArt_co_no(int art_co_no) {
		this.art_co_no = art_co_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getArt_no() {
		return art_no;
	}
	public void setArt_no(String art_no) {
		this.art_no = art_no;
	}
	public String getArt_cont() {
		return art_cont;
	}
	public void setArt_cont(String art_cont) {
		this.art_cont = art_cont;
	}
	public int getArt_ref() {
		return art_ref;
	}
	public void setArt_ref(int art_ref) {
		this.art_ref = art_ref;
	}
	public int getArt_step() {
		return art_step;
	}
	public void setArt_step(int art_step) {
		this.art_step = art_step;
	}
	public int getArt_level() {
		return art_level;
	}
	public void setArt_level(int art_level) {
		this.art_level = art_level;
	}
	public int getArt_likes() {
		return art_likes;
	}
	public void setArt_likes(int art_likes) {
		this.art_likes = art_likes;
	}
	public int getArt_hates() {
		return art_hates;
	}
	public void setArt_hates(int art_hates) {
		this.art_hates = art_hates;
	}
	public int getArt_report() {
		return art_report;
	}
	public void setArt_report(int art_report) {
		this.art_report = art_report;
	}
	public Date getArt_date() {
		return art_date;
	}
	public void setArt_date(Date art_date) {
		this.art_date = art_date;
	}
	
	public String mem_name;

	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
}
