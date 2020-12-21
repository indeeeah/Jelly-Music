package music.more.info.model.vo;

import java.sql.Date;

public class MusicMoreVO {
	
	// 음원
	private String mem_aka;
	private String sear_word;	
	private String mu_no;
	private String art_no;
	private String al_no;
	private String mu_name;
	private String mu_ly;
	private String mu_genre;
	private int mu_mood;
	private int mu_every_play;
	private int mu_every_heart;
	private String f_no;
	private String mu_yn;
	
	public String getMu_no() {
		return mu_no;
	}
	public void setMu_no(String mu_no) {
		this.mu_no = mu_no;
	}
	public String getArt_no() {
		return art_no;
	}
	public void setArt_no(String art_no) {
		this.art_no = art_no;
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
	public String getMu_genre() {
		return mu_genre;
	}
	public void setMu_genre(String mu_genre) {
		this.mu_genre = mu_genre;
	}
	public int getMu_mood() {
		return mu_mood;
	}
	public void setMu_mood(int mu_mood) {
		this.mu_mood = mu_mood;
	}
	public int getMu_every_play() {
		return mu_every_play;
	}
	public void setMu_every_play(int mu_every_play) {
		this.mu_every_play = mu_every_play;
	}
	public int getMu_every_heart() {
		return mu_every_heart;
	}
	public void setMu_every_heart(int mu_every_heart) {
		this.mu_every_heart = mu_every_heart;
	}
	public String getMu_yn() {
		return mu_yn;
	}
	public void setMu_yn(String mu_yn) {
		this.mu_yn = mu_yn;
	}
	
	// 아티스트
	private String art_name;  
	private String art_intro;
	
		
	public String getArt_name() {
		return art_name;
	}
	public void setArt_name(String art_name) {
		this.art_name = art_name;
	}
	public String getArt_intro() {
		return art_intro;
	}
	public void setArt_intro(String art_intro) {
		this.art_intro = art_intro;
	}

	//앨범
	private String al_name;
	private Date al_release;
	private String al_intro;
	private String al_type;
	
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
	public Date getAl_release() {
		return al_release;
	}
	public void setAl_release(Date al_release) {
		this.al_release = al_release;
	}
	public String getAl_intro() {
		return al_intro;
	}
	public void setAl_intro(String al_intro) {
		this.al_intro = al_intro;
	}
	public String getAl_type() {
		return al_type;
	}
	public void setAl_type(String al_type) {
		this.al_type = al_type;
	}
	public String getF_no() {
		return f_no;
	}
	public void setF_no(String f_no) {
		this.f_no = f_no;
	}
	public String getMem_aka() {
		return mem_aka;
	}
	public void setMem_aka(String mem_aka) {
		this.mem_aka = mem_aka;
	}
	public String getSear_word() {
		return sear_word;
	}
	public void setSear_word(String sear_word) {
		this.sear_word = sear_word;
	}
	
	
	
	
}
