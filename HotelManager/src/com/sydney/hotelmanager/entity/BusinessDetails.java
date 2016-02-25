package com.sydney.hotelmanager.entity;
/**
 * 营业详细信息
 * @author dell
 *
 */
public class BusinessDetails {
	
	/**
	 * 
	 */
	
	private String curDate;
	private String roomTypeme;
	private double roomPrice;
	private String hotelName;
	private String hotelAdress;
	private String bookDate;
	private String bookTime;
	private int howLong;
	public String getCurDate() {
		return curDate;
	}
	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}
	public String getRoomTypeme() {
		return roomTypeme;
	}
	public void setRoomTypeme(String roomTypeme) {
		this.roomTypeme = roomTypeme;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAdress() {
		return hotelAdress;
	}
	public void setHotelAdress(String hotelAdress) {
		this.hotelAdress = hotelAdress;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public int getHowLong() {
		return howLong;
	}
	public void setHowLong(int howLong) {
		this.howLong = howLong;
	}
	
	
	public BusinessDetails() {
		super();
	}
	public BusinessDetails(String curDate, String roomTypeme, double roomPrice,
			String hotelName, String hotelAdress, String bookDate,
			String bookTime, int howLong) {
		super();
		this.curDate = curDate;
		this.roomTypeme = roomTypeme;
		this.roomPrice = roomPrice;
		this.hotelName = hotelName;
		this.hotelAdress = hotelAdress;
		this.bookDate = bookDate;
		this.bookTime = bookTime;
		this.howLong = howLong;
	}
	@Override
	public String toString() {
		return "BusinessDetails [curDate=" + curDate + ", roomTypeme="
				+ roomTypeme + ", roomPrice=" + roomPrice + ", hotelName="
				+ hotelName + ", hotelAdress=" + hotelAdress + ", bookDate="
				+ bookDate + ", bookTime=" + bookTime + ", howLong=" + howLong
				+ "]";
	}
	
	
}
