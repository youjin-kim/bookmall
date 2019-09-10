package kr.co.itcen.bookmall.vo;

public class BookVo {
	private Long no;
	private Long category_no;
	private String name;
	private int price;
	private int stock;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", category_no=" + category_no + ", name=" + name + ", price=" + price + ", stock="
				+ stock + "]";
	}
}
