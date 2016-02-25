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
	 * �ͷ�����
	 */
	public static void initRoomInfoManager(){
		System.out.println("------�ͷ�����--------------");
		System.out.println("---1���ͷ���Ϣһ����2�������ͷ���Ϣ--------------");
		System.out.println("---3���޸Ŀͷ���Ϣ��2��ɾ���ͷ���Ϣ--------------");
		System.out.println("----����������ѡ���ܲ�����1,2,3,4��---------");
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
		System.out.println("������Ҫɾ���ķ���ţ�����");
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
		System.out.println("������Ҫ�޸ĵķ�����룺");
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
		System.out.println("Ҫ�޸ĵķ�����Ϣ���£�");
		System.out.println(roomInfo);
		System.out.println("������Ҫ�޸ĵ��ֶα�ţ�1���ͷ��Ƿ���ס��2���ͷ��Ƿ�Ԥ����"
				+ "3��Ԥ�������֤�ţ�4Ԥ�����ֻ��š�");
		int num=scanner.nextInt();
		while(num!=1&&num!=2&&num!=3&&num!=4){
			System.out.println("��������룬����ֻ����1��4�е�����һ��������");
			num=scanner.nextInt();
		}
		
		boolean flag=false;
		switch (num) {
		case 1:
			System.out.println("�������Ƿ���ס��1,����0");
			int isOrdered=scanner.nextInt();
			roomInfo.setIsOrdered(isOrdered);
			flag=true;
			break;
		case 2:
			System.out.println("�������Ƿ�Ԥ����1��0");
			int isPreOrder=scanner.nextInt();
			roomInfo.setIsPreOrder(isPreOrder);
			flag=true;
			break;
		case 3:
			System.out.println("����Ԥ�������֤�ţ�");
			String preOrderGuestNo=scanner.next();
			roomInfo.setPreOderGuestNo(preOrderGuestNo);;
			flag=true;
			break;
		case 4:
			System.out.println("������Ԥ�����ֻ��ţ�");
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
		System.out.println("������ͷ���ţ�");
		String roomInfoNo=scanner.next();
		System.out.println("������ͷ����ͱ�ţ�");
		String roomTypeNo=scanner.next();
		System.out.println("�����������Ƶ��ţ�");
		String hotelNo=scanner.next();
		System.out.println("�Ƿ���ס����1,0��");
		int isOrdered=scanner.nextInt();
		System.out.println("�Ƿ�Ԥ������1,0��");
		int isPreOrder=scanner.nextInt();
		System.out.println("����Ԥ�������֤�ţ�");
		String preOrderGuestNo=scanner.next();
		System.out.println("����Ԥ���ߵ绰���롣");
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
		System.out.println("���������еĿͷ���Ϣ��");
		for(RoomInfo roomInfo:roomInfos){
			System.out.println(roomInfo);
		}
		BackUp.roomInfoManagerBackUp();
		
	}
}
