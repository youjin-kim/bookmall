package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private Long userNo;
	private String userName;
	private String userEmail;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	private int totalPrice;
	private String sendAddress;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", userNo=" + userNo + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", totalPrice=" + totalPrice + ", sendAddress=" + sendAddress + "]";
	}
	
}
