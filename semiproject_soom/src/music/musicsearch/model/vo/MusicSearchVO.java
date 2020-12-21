package music.musicsearch.model.vo;


public class MusicSearchVO {
	private String art_no;
	private String art_name;
	private String mu_no;
	private String mu_name;
	private String al_no;
	private String al_name;
	private String mu_ly;
	private String f_no;
	public MusicSearchVO() {
		
	}
	public MusicSearchVO(String art_no, String art_name, String mu_no, String mu_name, String al_no, String al_name,
			String mu_ly, String f_no) {
		super();
		this.art_no = art_no;
		this.art_name = art_name;
		this.mu_no = mu_no;
		this.mu_name = mu_name;
		this.al_no = al_no;
		this.al_name = al_name;
		this.mu_ly = mu_ly;
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
	public String getAl_no() {
		return al_no;
	}
	public void setAl_no(String al_no) {
		this.al_no = al_no;
	}
	public String getAl_name() {
		return al_name;
	}
	public void setAl_name(String al_name) {
		this.al_name = al_name;
	}
	public String getMu_ly() {
		return mu_ly;
	}
	public void setMu_ly(String mu_ly) {
		this.mu_ly = mu_ly;
	}
	public String getF_no() {
		return f_no;
	}
	public void setF_no(String f_no) {
		this.f_no = f_no;
	}
	
}