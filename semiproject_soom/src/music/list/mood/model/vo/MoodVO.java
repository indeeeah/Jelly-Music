package music.list.mood.model.vo;

public class MoodVO {
	private String md_no;
	private String md_name;
	private String f_no;
	public MoodVO() {
		
	}
	public MoodVO(String md_no, String md_name, String f_no) {
		super();
		this.md_no = md_no;
		this.md_name = md_name;
		this.f_no = f_no;
	}
	public String getMd_no() {
		return md_no;
	}
	public void setMd_no(String md_no) {
		this.md_no = md_no;
	}
	public String getMd_name() {
		return md_name;
	}
	public void setMd_name(String md_name) {
		this.md_name = md_name;
	}
	public String getF_no() {
		return f_no;
	}
	public void setF_no(String f_no) {
		this.f_no = f_no;
	}
}
