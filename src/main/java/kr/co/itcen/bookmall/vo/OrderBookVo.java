package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private Long no;
	private Long book_no;
	private Long order_no;
	private int totalCount;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", book_no=" + book_no + ", order_no=" + order_no + ", totalCount="
				+ totalCount + "]";
	}

}
