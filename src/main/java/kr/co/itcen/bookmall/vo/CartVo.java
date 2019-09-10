package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long no;
	private Long book_no;
	private Long user_no;
	private int stock;
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
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", book_no=" + book_no + ", user_no=" + user_no + ", stock=" + stock + "]";
	}
	

}
