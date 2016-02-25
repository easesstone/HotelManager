package com.sydney.hotelmanager.entity;

public class RoomType {
	private String roomTypeNo;
	private String roomTypeName;
	private double price;
	
	/**
	 * getterºÍsetter
	 * @return
	 */
	public String getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(String roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public RoomType() {}
	public RoomType(String roomTypeNo, String roomTypeName, double price) {
		super();
		this.roomTypeNo = roomTypeNo;
		this.roomTypeName = roomTypeName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "RoomType [roomTypeNo=" + roomTypeNo + ", roomTypeName="
				+ roomTypeName + ", price=" + price + "]";
	}
	
	
	
}
