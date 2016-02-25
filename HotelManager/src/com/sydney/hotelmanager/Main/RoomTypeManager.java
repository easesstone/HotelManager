package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.RoomTypeDao;
import com.sydney.hotelmanager.daoImpl.RoomTypeDaoImpl;
import com.sydney.hotelmanager.entity.RoomType;

public class RoomTypeManager {
	/**
	 * �ͷ����͹���
	 */
	public static void initRoomTypeManager(){
		System.out.println("-----------�ͷ����͹���-------------");
		System.out.println("-----1���ͷ�����һ����2�������ͷ�����----");
		System.out.println("-----3���༭�ͷ����ͣ�4��ɾ���ͷ�����----");
		System.out.println("----����������ѡ���ܲ�����1,2,3,4��---------");
	}
	
	/**
	 * doRoomTypeManager
	 */
	@SuppressWarnings("resource")
	public static void doRoomTypeManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			RoomTypeManager.findAll();
			break;
		case 2:
			RoomTypeManager.add();
			break;
		case 3:
			RoomTypeManager.update();
			break;
		case 4:
			RoomTypeManager.delete();
			break;

		default:
			break;
		}
	}
	public static void findAll(){
		List<RoomType>roomTypes=new ArrayList<RoomType>();
		try {
			roomTypes=new RoomTypeDaoImpl().findAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("���ҵĿͷ�������Ϣ���£�");
		for(RoomType roomType:roomTypes){
			System.out.println(roomType);
		}
		BackUp.roomTypeManagerBackUp();
		
	}
	@SuppressWarnings("resource")
	public static void add(){
		System.out.println("��ӿͷ�������Ϣ��");
		System.out.println("������ͷ����ͱ�ţ�");
		Scanner scanner=new Scanner(System.in);
		String roomTypeNo=scanner.next();
		System.out.println("������ͷ��������ƣ�");
		String roomTypeName=scanner.next();
		System.out.println("������ͷ��۸�");
		double roomPrice=scanner.nextDouble();
		
		RoomType roomType=new RoomType(roomTypeNo, roomTypeName, roomPrice);
		
		try {
			new RoomTypeDaoImpl().add(roomType);
			BackUp.roomTypeManagerBackUp();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void delete(){
		System.out.println("������Ҫɾ���Ŀͷ����ͱ�ţ�");
		Scanner scanner=new Scanner(System.in);
		
		String roomTypeNo=scanner.next();
		
		try {
			new RoomTypeDaoImpl().delete(roomTypeNo);
			System.out.println("delete success,please continue....");
			BackUp.roomTypeManagerBackUp();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static void update(){
		System.out.println("������Ҫ�޸ĵĿͷ����ͱ�š�");
		Scanner scanner=new Scanner(System.in);
		
		String roomTypeNo=scanner.next();
		RoomTypeDao dao=new RoomTypeDaoImpl();
		try {
			RoomType roomType=dao.findById(roomTypeNo);
			
			System.out.println("������Ҫ�޸ĵ��ֶεı�ţ�1���ͷ��������ƣ�2���ͷ��۸�");
			
			int num=scanner.nextInt();
			while(num!=1&&num!=2){
				System.out.println("��������룬���������ֻ����1����2");
				num=scanner.nextInt();
			}
			
			boolean flag=false;
			switch (num) {
			case 1:
				System.out.println("---------�޸Ŀͷ���������----------");
				System.out.println("������ͷ��������ƣ�");
				String roomTypeName=scanner.next();
				roomType.setRoomTypeName(roomTypeName);
				flag=true;
				break;
			case 2:
				System.out.println("-------�޸Ŀͷ��۸�-----------");
				System.out.println("������ͷ��۸񣻣�����");
				double roomPrice=scanner.nextDouble();
				roomType.setPrice(roomPrice);
				flag=true;
				break;
			default:
				break;
			}
			if (flag) {
				dao.update(roomType);
				System.out.println("update success,please continue.....");
				BackUp.roomTypeManagerBackUp();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

