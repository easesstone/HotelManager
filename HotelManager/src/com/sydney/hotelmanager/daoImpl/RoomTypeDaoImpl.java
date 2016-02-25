package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sydney.hotelmanager.dao.RoomTypeDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.RoomType;

public class RoomTypeDaoImpl implements RoomTypeDao {

	@Override
	public int update(RoomType roomTypeNo) throws SQLException {
		String sql="update roomtype set roomTypeName=?,roomprice=?"
				+ " where roomTypeNo=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn,sql,roomTypeNo.getRoomTypeName(),
				roomTypeNo.getPrice(),roomTypeNo.getRoomTypeNo());
		conn.close();
		return a;
	}

	@Override
	public int delete(String roomTypeNo) throws SQLException {
		String sql="delete from roomtype where rooTypeNo=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn,sql,roomTypeNo);
		conn.close();
		return a;
	}

	@Override
	public int add(RoomType roomType) throws SQLException {
		String sql="insert into roomtype(roomTypeNo,roomTypeName,roomprice)"
				+ " values(?,?,?)";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn,sql,roomType.getRoomTypeNo(),
				roomType.getRoomTypeName(),roomType.getPrice());
		conn.close();
		return a;
	}

	@Override
	public RoomType findById(String roomTypeNo) throws SQLException {
		String sql="select roomTypeNo,roomTypeName,roomprice from roomtype"
				+ " where roomTypeNo=?";
		Connection conn=DBUtils.getConnectTion();
		RoomType roomType=new QueryRunner().query(conn, sql, 
				new BeanHandler<RoomType>(RoomType.class), roomTypeNo);
		conn.close();
		return roomType;
	}

	@Override
	public List<RoomType> findAll() throws SQLException {
		String sql="select roomTypeNo,roomTypeName,roomprice from roomtype";
		Connection conn=DBUtils.getConnectTion();
		List<RoomType> roomTypes=new QueryRunner().query(conn, sql,
				new BeanListHandler<RoomType>(RoomType.class));
		conn.close();
		return roomTypes;
	}

}
