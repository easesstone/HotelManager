package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sydney.hotelmanager.dao.GuestDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.Guest;

public class GuestDaoImpl implements GuestDao {

	
	//按身份证查找客人住房记录
	@Override
	public List<Guest> findById(String guestShenfenNo) throws SQLException {
		String sql="select guestNo,guestName,guestShenFenNo,"
				+ "guestPhoneNo,bookDate,bookTime,roomInfoNo"
				+ " from guest where guestShenFenNo=?";
		Connection conn=DBUtils.getConnectTion();
		List<Guest> guests=new QueryRunner().query(conn, sql, 
				new BeanListHandler<Guest>(Guest.class), guestShenfenNo);
		conn.close();
		return guests;
	}

	//获取当前在店客人信息
	@Override
	public List<Guest> findByInNow() throws SQLException {
		String sql="select guestNo,guestName,guestShenFenNo,"
				+ "guestPhoneNo,bookDate,bookTime,roomInfoNo"
				+ " from guest where curdate() between bookDate and bookTime";
		Connection conn=DBUtils.getConnectTion();
		List<Guest> guests=new QueryRunner().query(conn, sql,
				new BeanListHandler<Guest>(Guest.class));
		conn.close();
		return guests;
	}
	
	//根据日期查询
	public List<Guest>findByDate(String date)throws SQLException{
		String sql="select guestNo,guestName,guestShenFenNo,"
				+ "guestPhoneNo,bookDate,bookTime,roomInfoNo"
				+ " from guest where ? between bookDate and bookTime";
		Connection conn=DBUtils.getConnectTion();
		List<Guest> guests=new QueryRunner().query(conn, sql,
				new BeanListHandler<Guest>(Guest.class),date);
		conn.close();
		return guests;
	}

	@Override
	public int addGuest(Guest guest) throws SQLException {
		String sql="insert into guest(guestNo,guestName,guestShenFenNo,"
				+ "guestPhoneNo,bookDate,bookTime,roomInfoNo) "
				+ "values(?,?,?,?,?,?,?)";
		Connection conn=DBUtils.getConnectTion();
		
		int a=new QueryRunner().update(conn, sql, guest.getGuestNo(),guest.getGuestName(),
				guest.getGuestShenFenNo(),guest.getGuestPhoneNo(),
				guest.getBookDate(),guest.getBookDate(),guest.getRoomInfoNo());
		return a;
	}

}
