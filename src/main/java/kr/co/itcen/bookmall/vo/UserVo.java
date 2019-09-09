package kr.co.itcen.bookmall.vo;

public class UserVo {
	private Long no;
	private String name;
	private String tell;
	private String email;
	private String pwd;
	private String address;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", tell=" + tell + ", email=" + email + ", pwd=" + pwd
				+ ", address=" + address + "]";
	}
	

}
