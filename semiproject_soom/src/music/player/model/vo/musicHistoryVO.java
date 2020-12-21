package music.player.model.vo;

import java.sql.Date;

/*mem_id varchar2(30),
mu_no varchar2(20),
play_more_min char(1),
play_date date default sysdate,
play_now char(1) default 'Y',*/
public class musicHistoryVO {
	private String mem_id;
	private String mu_no;
	private String play_more_min;
	private Date play_date;
	private String play_now;
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
	public String getPlay_more_min() {
		return play_more_min;
	}
	public void setPlay_more_min(String play_more_min) {
		this.play_more_min = play_more_min;
	}
	public Date getPlay_date() {
		return play_date;
	}
	public void setPlay_date(Date play_date) {
		this.play_date = play_date;
	}
	public String getPlay_now() {
		return play_now;
	}
	public void setPlay_now(String play_now) {
		this.play_now = play_now;
	}
	
	
}
