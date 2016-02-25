package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.RoomInfoDao;
import com.sydney.hotelmanager.daoImpl.RoomInfoDaoImpl;
import com.sydney.hotelmanager.entity.RoomInfo;

public class RoomInfoManager {
	
	/**
	 * 客房管理
	 */
	public static void initRoomInfoManager(){
		System.out.println("------客房管理--------------");
		System.out.println("---1，客房信息一览，2，新增客房信息--------------");
		System.out.println("---3，修改客房信息，2，删除客房信息--------------");
		System.out.println("----请输入数字选择功能操作（1,2,3,4）---------");
	}
	
	
	@SuppressWarnings("resource")
	public static void doRoomInfoManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			findAll();
			break;
		case 2:
			add();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;

		default:
			break;
		}
	}


	@SuppressWarnings("resource")
	private static void delete() {
		System.out.println("请输入要删除的房间号，，，");
		Scanner scanner=new Scanner(System.in);
		String roomInfoNo=scanner.next();
		
		try {
			new RoomInfoDaoImpl().delete(roomInfoNo);
			System.out.println("delete success, please continue...");
			BackUp.roomInfoManagerBackUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@SuppressWarnings("resource")
	private static void update() {
		System.out.println("请输入要修改的房间号码：");
		Scanner scanner=new Scanner(System.in);
		String roomInfoNo=scanner.next();
		
		RoomInfoDao dao=new RoomInfoDaoImpl();
		RoomInfo roomInfo=null;
		try {
			roomInfo=dao.findById(roomInfoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("要修改的房间信息如下：");
		System.out.println(roomInfo);
		System.out.println("请输入要修改的字段编号：1，客房是否入住，2，客房是否被预订，"
				+ "3，预订者身份证号，4预订者手机号。");
		int num=scanner.nextInt();
		while(num!=1&&num!=2&&num!=3&&num!=4){
			System.out.println("请从新输入，数字只能是1到4中的任意一个整数：");
			num=scanner.nextInt();
		}
		
		boolean flag=false;
		switch (num) {
		case 1:
			System.out.println("请输入是否被入住，1,或者0");
			int isOrdered=scanner.nextInt();
			roomInfo.setIsOrdered(isOrdered);
			flag=true;
			break;
		case 2:
			System.out.println("请输入是否被预订，1或0");
			int isPreOrder=scanner.nextInt();
			roomInfo.setIsPreOrder(isPreOrder);
			flag=true;
			break;
		case 3:
			System.out.println("输入预订者身份证号：");
			String preOrderGuestNo=scanner.next();
			roomInfo.setPreOderGuestNo(preOrderGuestNo);;
			flag=true;
			break;
		case 4:
			System.out.println("请输入预订者手机号：");
			String preOrderGuestPhone=scanner.next();
			roomInfo.setPreOderGuestPhone(preOrderGuestPhone);
			flag=true;
			break;

		default:
			break;
		}
		if (roomInfo!=null&&flag) {
			try {
				dao.update(roomInfo);
				System.out.println("update success..please continue...");
				BackUp.roomInfoManagerBackUp();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@SuppressWarnings("resource")
	private static void add() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入客房编号：");
		String roomInfoNo=scanner.next();
		System.out.println("请输入客房类型编号：");
		String roomTypeNo=scanner.next();
		System.out.println("请输入所属酒店编号：");
		String hotelNo=scanner.next();
		System.out.println("是否入住。（1,0）");
		int isOrdered=scanner.nextInt();
		System.out.println("是否被预订。（1,0）");
		int isPreOrder=scanner.nextInt();
		System.out.println("输入预订者身份证号：");
		String preOrderGuestNo=scanner.next();
		System.out.println("输入预订者电话号码。");
		String preOrderGuestPhone=scanner.next();
		
		RoomInfo roomInfo=new RoomInfo(roomInfoNo, roomTypeNo, hotelNo, 
				isOrdered, isPreOrder, preOrderGuestNo, preOrderGuestPhone);
		try {
			new RoomInfoDaoImpl().add(roomInfo);
			System.out.println("insert success..please continue...");
			BackUp.roomInfoManagerBackUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static void findAll() {
		List<RoomInfo> roomInfos=new ArrayList<RoomInfo>();
		try {
			roomInfos=new RoomInfoDaoImpl().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("success...");
		System.out.println("以下是所有的客房信息：");
		for(RoomInfo roomInfo:roomInfos){
			System.out.println(roomInfo);
		}
		BackUp.roomInfoManagerBackUp();
		
	}
}
