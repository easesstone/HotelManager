package com.sydney.hotelmanager.entity;

public class User {
	private String username;
	private String password;
	private String realname;
	private String hotelNo;
	private int isManager;
	
	
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	public String getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(String hotelNo) {
		this.hotelNo = hotelNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	//构造函数，无参构造函数和有参构造函数
	public User() {}
	public User(String username, String password, String realname,
			String hotelNo, int isManager) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.hotelNo = hotelNo;
		this.isManager = isManager;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", realname=" + realname + ", hotelNo=" + hotelNo
				+ ", isManager=" + isManager + "]";
	}
	
	
	
}
