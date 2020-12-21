package music.list.memberRec.model.vo;

public class MemberRecVO {
	private String mem_id;
	private String f_no;
	private String art_no;
	private String art_name;
	private String mu_no;
	private String mu_name;
	public MemberRecVO() {
	}
	public MemberRecVO(String mem_id, String f_no, String art_no, String art_name, String mu_no, String mu_name) {
		super();
		this.mem_id = mem_id;
		this.f_no = f_no;
		this.art_no = art_no;
		this.art_name = art_name;
		this.mu_no = mu_no;
		this.mu_name = mu_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getF_no() {
		return f_no;
	}
	public void setF_no(String f_no) {
		this.f_no = f_no;
	}
	public String getArt_no() {
		return art_no;
	}
	public void setArt_no(String art_no) {
		this.art_no = art_no;
	}
	public String getArt_name() {
		return art_name;
	}
	public void setArt_name(String art_name) {
		this.art_name = art_name;
	}
	public String getMu_no() {
		return mu_no;
	}
	public void setMu_no(String mu_no) {
		this.mu_no = mu_no;
	}
	public String getMu_name() {
		return mu_name;
	}
	public void setMu_name(String mu_name) {
		this.mu_name = mu_name;
	}
	
}