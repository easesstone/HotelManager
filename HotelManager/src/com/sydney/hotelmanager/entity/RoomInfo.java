package com.sydney.hotelmanager.entity;

public class RoomInfo {
	private String roomInfoNo;
	private String roomTypeNo;
	private String hotelNo;
	private int isOrdered;
	private int isPreOrder;
	private String preOderGuestNo;
	private String preOderGuestPhone;
	public String getRoomInfoNo() {
		return roomInfoNo;
	}
	public void setRoomInfoNo(String roomInfoNo) {
		this.roomInfoNo = roomInfoNo;
	}
	public String getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(String roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(String hotelNo) {
		this.hotelNo = hotelNo;
	}
	public int getIsOrdered() {
		return isOrdered;
	}
	public void setIsOrdered(int isOrdered) {
		this.isOrdered = isOrdered;
	}
	public int getIsPreOrder() {
		return isPreOrder;
	}
	public void setIsPreOrder(int isPreOrder) {
		this.isPreOrder = isPreOrder;
	}
	public String getPreOderGuestNo() {
		return preOderGuestNo;
	}
	public void setPreOderGuestNo(String preOderGuestNo) {
		this.preOderGuestNo = preOderGuestNo;
	}
	public String getPreOderGuestPhone() {
		return preOderGuestPhone;
	}
	public void setPreOderGuestPhone(String preOderGuestPhone) {
		this.preOderGuestPhone = preOderGuestPhone;
	}
	
	
	public RoomInfo() {
		super();
	}
	public RoomInfo(String roomInfoNo, String roomTypeNo, String hotelNo,
			int isOrdered, int isPreOrder, String preOderGuestNo,
			String preOderGuestPhone) {
		super();
		this.roomInfoNo = roomInfoNo;
		this.roomTypeNo = roomTypeNo;
		this.hotelNo = hotelNo;
		this.isOrdered = isOrdered;
		this.isPreOrder = isPreOrder;
		this.preOderGuestNo = preOderGuestNo;
		this.preOderGuestPhone = preOderGuestPhone;
	}
	@Override
	public String toString() {
		return "RoomInfo [roomInfoNo=" + roomInfoNo + ", roomTypeNo="
				+ roomTypeNo + ", hotelNo=" + hotelNo + ", isOrdered="
				+ isOrdered + ", isPreOrder=" + isPreOrder
				+ ", preOderGuestNo=" + preOderGuestNo + ", preOderGuestPhone="
				+ preOderGuestPhone + "]";
	}
	
	
	
}
