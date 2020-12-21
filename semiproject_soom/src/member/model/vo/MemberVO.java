package member.model.vo;

import java.sql.Date;

public class MemberVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_aka;
	private String mem_addr;
	private String mem_email;
	private int mem_phone;
	private String mem_sns;
	private String mem_name;
	private Date mem_birth;
	private Date mem_reg_date;
	private Date mem_wd_date;
	
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
	public String getMem_aka() {
		return mem_aka;
	}
	public void setMem_aka(String mem_aka) {
		this.mem_aka = mem_aka;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
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
	public String getMem_sns() {
		return mem_sns;
	}
	public void setMem_sns(String mem_sns) {
		this.mem_sns = mem_sns;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public Date getMem_reg_date() {
		return mem_reg_date;
	}
	public void setMem_reg_date(Date mem_reg_date) {
		this.mem_reg_date = mem_reg_date;
	}
	public Date getMem_wd_date() {
		return mem_wd_date;
	}
	public void setMem_wd_date(Date mem_wd_date) {
		this.mem_wd_date = mem_wd_date;
	}
	
}
