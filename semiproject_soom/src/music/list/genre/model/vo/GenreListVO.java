package music.list.genre.model.vo;

public class GenreListVO {
	private String gn_no;
	private String gn_name;
	private String f_no;
	public GenreListVO() {
		
	}
	public GenreListVO(String gn_no, String gn_name, String f_no) {
		super();
		this.gn_no = gn_no;
		this.gn_name = gn_name;
		this.f_no = f_no;
	}
	public String getGn_no() {
		return gn_no;
	}
	public void setGn_no(String gn_no) {
		this.gn_no = gn_no;
	}
	public String getGn_name() {
		return gn_name;
	}
	public void setGn_name(String gn_name) {
		this.gn_name = gn_name;
	}
	public String getF_no() {
		return f_no;
	}
	public void setF_no(String f_no) {
		this.f_no = f_no;
	}
}

