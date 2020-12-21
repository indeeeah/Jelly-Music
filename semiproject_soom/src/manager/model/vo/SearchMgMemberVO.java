package manager.model.vo;

import java.sql.Date;

//MEM_ID       NOT NULL VARCHAR2(30) 
//MEM_PWD      NOT NULL VARCHAR2(30) 
//MEM_NAME     NOT NULL VARCHAR2(30) 
//MEM_EMAIL    NOT NULL VARCHAR2(30) 
//MEM_PHONE    NOT NULL NUMBER(11)   
//MEM_GENDER   NOT NULL NUMBER(1)    
//MEM_REG_DATE          DATE  

public class SearchMgMemberVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_email;
	private int mem_phone;
	private int mem_gender;
	private Date mem_reg_date;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public int getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(int mem_phone) {
		this.mem_phone = mem_phone;
	}
	public int getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(int mem_gender) {
		this.mem_gender = mem_gender;
	}
	public Date getMem_reg_date() {
		return mem_reg_date;
	}
	public void setMem_reg_date(Date mem_reg_date) {
		this.mem_reg_date = mem_reg_date;
	}
	
	public String getmem_sexual() {
		if(mem_gender==1) {
			return "남";
		} else {
			return "여";
		}
	}
}
