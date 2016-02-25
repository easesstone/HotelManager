package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.Guest;

public interface GuestDao {
	public int addGuest(Guest guest)throws SQLException;
	public List<Guest> findById(String guestShenfenNo)throws SQLException;//���ҿ���ס����¼
	public List<Guest> findByInNow()throws SQLException;//���ҵ�ǰ�ڵ������Ϣ
	public List<Guest>findByDate(String date)throws SQLException;//�������ڲ�ѯ������Ϣ
}
