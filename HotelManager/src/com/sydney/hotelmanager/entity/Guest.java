package com.sydney.hotelmanager.entity;


public class Guest {
	private String guestNo;
	private String guestName;
	private String guestShenFenNo;
	private String guestPhoneNo;
	private String bookDate;
	private String bookTime;
	private String roomInfoNo;
	
	
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public String getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(String guestNo) {
		this.guestNo = guestNo;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestShenFenNo() {
		return guestShenFenNo;
	}
	public void setGuestShenFenNo(String guestShenFenNo) {
		this.guestShenFenNo = guestShenFenNo;
	}
	public String getGuestPhoneNo() {
		return guestPhoneNo;
	}
	public void setGuestPhoneNo(String guestPhoneNo) {
		this.guestPhoneNo = guestPhoneNo;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getRoomInfoNo() {
		return roomInfoNo;
	}
	public void setRoomInfoNo(String roomInfoNo) {
		this.roomInfoNo = roomInfoNo;
	}
	public Guest() {
		super();
	}
	public Guest(String guestNo, String guestName, String guestShenFenNo,
			String guestPhoneNo, String bookDate, String bookTime, String roomInfoNo) {
		super();
		this.guestNo = guestNo;
		this.guestName = guestName;
		this.guestShenFenNo = guestShenFenNo;
		this.guestPhoneNo = guestPhoneNo;
		this.bookDate = bookDate;
		this.bookTime = bookTime;
		this.roomInfoNo = roomInfoNo;
	}
	@Override
	public String toString() {
		return "Guest [guestNo=" + guestNo + ", guestName=" + guestName
				+ ", guestShenFenNo=" + guestShenFenNo + ", guestPhoneNo="
				+ guestPhoneNo + ", bookDate=" + bookDate + ", bookTime="
				+ bookTime + ", roomInfoNo=" + roomInfoNo + "]";
	}
	
	
}
