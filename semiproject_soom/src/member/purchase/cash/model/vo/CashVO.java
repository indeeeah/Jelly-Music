package member.purchase.cash.model.vo;

public class CashVO {
	private String mem_id;
	private int cs_price;
	private int cs_left;
	public CashVO() {
		
	}
	public CashVO(String mem_id, int cs_price, int cs_left) {
		super();
		this.mem_id = mem_id;
		this.cs_price = cs_price;
		this.cs_left = cs_left;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCs_price() {
		return cs_price;
	}
	public void setCs_price(int cs_price) {
		this.cs_price = cs_price;
	}
	public int getCs_left() {
		return cs_left;
	}
	public void setCs_left(int cs_left) {
		this.cs_left = cs_left;
	}
	
}
