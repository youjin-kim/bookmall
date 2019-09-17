package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long no;
	private Long bookNo;
	private Long userNo;
	private int stock;
	private String userName;
	private String bookName;
	private int bookPrice;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", bookNo=" + bookNo + ", userNo=" + userNo + ", stock=" + stock + ", userName="
				+ userName + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
}
