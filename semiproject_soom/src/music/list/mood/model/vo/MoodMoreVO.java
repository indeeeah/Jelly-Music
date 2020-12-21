package music.list.mood.model.vo;

public class MoodMoreVO {
	private String al_no;
	private String al_name;
	private String art_no;
	private String art_name;
	private String mu_no;
	private String mu_name;
	private String mu_ly;
	private int mu_every_heart;
	public MoodMoreVO() {
		
	}
	public MoodMoreVO(String al_no, String al_name, String art_no, String art_name, String mu_no, String mu_name,
			String mu_ly, int mu_every_heart) {
		super();
		this.al_no = al_no;
		this.al_name = al_name;
		this.art_no = art_no;
		this.art_name = art_name;
		this.mu_no = mu_no;
		this.mu_name = mu_name;
		this.mu_ly = mu_ly;
		this.mu_every_heart = mu_every_heart;
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
	public String getMu_ly() {
		return mu_ly;
	}
	public void setMu_ly(String mu_ly) {
		this.mu_ly = mu_ly;
	}
	public int getMu_every_heart() {
		return mu_every_heart;
	}
	public void setMu_every_heart(int mu_every_heart) {
		this.mu_every_heart = mu_every_heart;
	}
}
