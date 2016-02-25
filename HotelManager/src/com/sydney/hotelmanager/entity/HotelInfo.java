package com.sydney.hotelmanager.entity;

public class HotelInfo {
	private String hotelNo;
	private String hotelName;
	private String hotelManager;
	private String hotelTel;
	private String hotelAdress;
	private int isMainHotel;
	public String getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(String hotelNo) {
		this.hotelNo = hotelNo;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelManager() {
		return hotelManager;
	}
	public void setHotelManager(String hotelManager) {
		this.hotelManager = hotelManager;
	}
	public String getHotelTel() {
		return hotelTel;
	}
	public void setHotelTel(String hotelTel) {
		this.hotelTel = hotelTel;
	}
	public String getHotelAdress() {
		return hotelAdress;
	}
	public void setHotelAdress(String hotelAdress) {
		this.hotelAdress = hotelAdress;
	}
	public int getisMainHotel() {
		return isMainHotel;
	}
	public void setisMainHotel(int isMainHotel) {
		this.isMainHotel = isMainHotel;
	}
	
	
	public HotelInfo() {
		super();
	}
	public HotelInfo(String hotelNo, String hotelName, String hotelManager,
			String hotelTel, String hotelAdress, int isMainHotel) {
		super();
		this.hotelNo = hotelNo;
		this.hotelName = hotelName;
		this.hotelManager = hotelManager;
		this.hotelTel = hotelTel;
		this.hotelAdress = hotelAdress;
		this.isMainHotel = isMainHotel;
	}
	@Override
	public String toString() {
		return "HotelInfo [hotelNo=" + hotelNo + ", hotelName=" + hotelName
				+ ", hotelManager=" + hotelManager + ", hotelTel=" + hotelTel
				+ ", hotelAdress=" + hotelAdress + ", isMainHotel="
				+ isMainHotel + "]";
	}
	
	
}
