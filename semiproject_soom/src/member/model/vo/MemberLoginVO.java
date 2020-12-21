package member.model.vo;

import java.sql.Date;
import java.util.Calendar;


public class MemberLoginVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_email;
	private String mem_birth;
	private String mem_phone;
	private int mem_gender;
	private Date mem_reg;
	private String sear_word;	


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

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public int getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(int mem_gender) {
		this.mem_gender = mem_gender;
	}

	public Date getMem_reg() {
		return mem_reg;
	}

	public void setMem_reg(Date mem_reg) {
		this.mem_reg = mem_reg;
	}

	public String getSexual() {
		if(mem_gender==1) {
			return "남";
		} else {
			return "여";
		}
	}
	
	public int getAge() {
		Calendar currDate = Calendar.getInstance();
		int currYear = currDate.get(Calendar.YEAR);
		int age = 0;
		age = currYear - Integer.parseInt(mem_birth.substring(0, 4)) + 1;
		return age;
	}

	public String getSear_word() {
		return sear_word;
	}

	public void setSear_word(String sear_word) {
		this.sear_word = sear_word;
	}
	
	
	
	
	
	
	
	
	
	
}

