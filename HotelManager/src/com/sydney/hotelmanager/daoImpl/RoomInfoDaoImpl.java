package com.sydney.hotelmanager.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sydney.hotelmanager.dao.RoomInfoDao;
import com.sydney.hotelmanager.dbutils.DBUtils;
import com.sydney.hotelmanager.entity.RoomInfo;

public class RoomInfoDaoImpl implements RoomInfoDao {

	@Override
	public int add(RoomInfo roomInfo) throws SQLException {
		String sql="insert into roominfo(roominfoNo,roomTypeNo,"
				+ "hotelNo,isOrdered,isPreOrder,"
				+ "preOrderGuestNo,preOrderGuestPhone) values(?,?,?,?,?,?,?)";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn,sql,roomInfo.getRoomInfoNo(),
				roomInfo.getRoomInfoNo(),roomInfo.getHotelNo(),
				roomInfo.getIsOrdered(),roomInfo.getIsPreOrder(),
				roomInfo.getPreOderGuestNo(),roomInfo.getPreOderGuestPhone());
		conn.close();
		return a;
	}

	@Override
	public int update(RoomInfo roomInfo) throws SQLException {
		String sql="update roominfo set roominfoNo=?,roooTypeNo=?,"
				+ "hotelNo=?,isOrdered=?,isPreOrder=?,PreOrderGuestNo=?"
				+ ",preOrderGuestPhone=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn, sql,roomInfo.getRoomInfoNo(),
				roomInfo.getRoomInfoNo(),roomInfo.getHotelNo(),
				roomInfo.getIsOrdered(),roomInfo.getIsPreOrder(),
				roomInfo.getPreOderGuestNo(),roomInfo.getPreOderGuestPhone());
		conn.close();
		return a;
	}

	@Override
	public int delete(String roomInfoNo) throws SQLException {
		String sql="delete from roominfo where roomInfoNo=?";
		Connection conn=DBUtils.getConnectTion();
		int a=new QueryRunner().update(conn, sql, roomInfoNo);
		conn.close();
		return a;
	}

	@Override
	public RoomInfo findById(String roomInfoNo) throws SQLException {
		String sql="select roominfoNo,roomTypeNo,"
				+ "hotelNo,isOrdered,isPreOrder,"
				+ "preOrderGuestNo,preOrderGuestPhone from roominfo"
				+ " where roominfoNo=?";
		Connection conn=DBUtils.getConnectTion();
		RoomInfo roomInfo=(RoomInfo) new QueryRunner().query(conn, sql,
				new BeanListHandler<RoomInfo>(RoomInfo.class), roomInfoNo);
		conn.close();
		return roomInfo;
	}

	@Override
	public List<RoomInfo> findAll() throws SQLException {
		String sql="select roominfoNo,roomTypeNo,"
				+ "hotelNo,isOrdered,isPreOrder,"
				+ "preOrderGuestNo,preOrderGuestPhone from roominfo";
		Connection conn=DBUtils.getConnectTion();
		List<RoomInfo>roomInfos=new QueryRunner().query(conn, sql, 
				new BeanListHandler<RoomInfo>(RoomInfo.class));
		conn.close();
		return roomInfos;
	}

}
