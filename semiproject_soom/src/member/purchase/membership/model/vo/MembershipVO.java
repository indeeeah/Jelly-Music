package member.purchase.membership.model.vo;

//membership
public class MembershipVO {
	private String ms_no;
	private String ms_type;
	private int ms_price;
	
	public MembershipVO(){
		
	}
	public MembershipVO(String ms_no, String ms_type, int ms_price) {
		super();
		this.ms_no = ms_no;
		this.ms_type = ms_type;
		this.ms_price = ms_price;
	}
	public String getMs_no() {
		return ms_no;
	}
	public void setMs_no(String ms_no) {
		this.ms_no = ms_no;
	}
	public String getMs_type() {
		return ms_type;
	}
	public void setMs_type(String ms_type) {
		this.ms_type = ms_type;
	}
	public int getMs_price() {
		return ms_price;
	}
	public void setMs_price(int ms_price) {
		this.ms_price = ms_price;
	}
	@Override
	public String toString() {
		return "MembershipVO [ms_no=" + ms_no + ", ms_type=" + ms_type + ", ms_price=" + ms_price + "]";
	}

}

