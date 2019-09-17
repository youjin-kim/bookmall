package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private Long no;
	private Long bookNo;
	private String bookName;
	private Long orderNo;
	private int totalCount;
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
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", bookNo=" + bookNo + ", bookName=" + bookName + ", orderNo=" + orderNo
				+ ", totalCount=" + totalCount + "]";
	}
	
	
}
