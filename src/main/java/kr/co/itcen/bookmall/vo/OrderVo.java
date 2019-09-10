package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private Long user_no;
	private int total_price;
	private String send_address;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getSend_address() {
		return send_address;
	}
	public void setSend_address(String send_address) {
		this.send_address = send_address;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", user_no=" + user_no + ", total_price=" + total_price + ", send_address="
				+ send_address + "]";
	}
	
}
