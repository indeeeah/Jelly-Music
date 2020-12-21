package post.model.vo;

import java.sql.Date;
//한글 
public class PostVO {
	private int que_no;
	private String mem_id;
	private String que_name;
	private String que_content;
	private String que_file;
	private String que_secret;
	private int que_ref;
	private int que_step;
	private int que_level;
	private int que_cnt;
	private Date que_date;
	
	public int getQue_no() {
		return que_no;
	}
	public void setQue_no(int que_no) {
		this.que_no = que_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQue_name() {
		return que_name;
	}
	public void setQue_name(String que_name) {
		this.que_name = que_name;
	}
	public String getQue_content() {
		return que_content;
	}
	public void setQue_content(String que_content) {
		this.que_content = que_content;
	}
	public Date getQue_date() {
		return que_date;
	}
	public void setQue_date(Date que_date) {
		this.que_date = que_date;
	}
	public String getQue_file() {
		return que_file;
	}
	public void setQue_file(String que_file) {
		this.que_file = que_file;
	}
	public String getQue_secret() {
		return que_secret;
	}
	public void setQue_secret(String que_secret) {
		this.que_secret = que_secret;
	}
	public int getQue_ref() {
		return que_ref;
	}
	public void setQue_ref(int que_ref) {
		this.que_ref = que_ref;
	}
	public int getQue_step() {
		return que_step;
	}
	public void setQue_step(int que_step) {
		this.que_step = que_step;
	}
	public int getQue_level() {
		return que_level;
	}
	public void setQue_level(int que_level) {
		this.que_level = que_level;
	}
	public int getQue_cnt() {
		return que_cnt;
	}
	public void setQue_cnt(int que_cnt) {
		this.que_cnt = que_cnt;
	}
	
	
}
