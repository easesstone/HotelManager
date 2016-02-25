package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.HotelInfoDao;
import com.sydney.hotelmanager.daoImpl.HotelInfoDaoImpl;
import com.sydney.hotelmanager.entity.HotelInfo;

public class HotelManager {
	/**
	 * �Ƶ����
	 */
	public static void initHotelManager(){
		System.out.println("----------�Ƶ����---------------");
		System.out.println("------1���Ƶ�һ����2�������Ƶ�-------");
		System.out.println("------3���༭�Ƶ꣬4��ɾ���Ƶ�-------");
		System.out.println("----����������ѡ���ܲ�����1,2,3,4��---------");
	}
	
	@SuppressWarnings("resource")
	public static void doHotelManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			HotelManager.findAll();
			break;
		case 2:
			HotelManager.add();
			break;
		case 3:
			HotelManager.update();
			break;
		case 4:
			HotelManager.delete();
			break;

		default:
			break;
		}
	}
	//�鿴���оƵ���Ϣ
	public static void findAll(){
		List<HotelInfo> hotelInfos=new ArrayList<HotelInfo>();
		try {
			hotelInfos=new HotelInfoDaoImpl().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("���ҳ���������ϢΪ��");
		for(HotelInfo hotelInfo:hotelInfos){
			System.out.println(hotelInfo);
		}
		
		BackUp.hotelManagerBackUp();
		return;
	}
	@SuppressWarnings("resource")
	public static void delete(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫ����ľƵ�ı�ţ�");
		String hotelNo=scanner.next();
		try {
			new HotelInfoDaoImpl().delete(hotelNo);
			System.out.println("delete success ,please continue.....");
			BackUp.hotelManagerBackUp();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void add(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ƶ���:");
		String hotelNo=scanner.next();
		System.out.println("������Ƶ����֣�");
		String hotelName=scanner.next();
		System.out.println("������Ƶ꾭�����֣�");
		String hotelManager=scanner.next();
		System.out.println("������Ƶ�绰���룺");
		String hotelTel=scanner.next();
		System.out.println("������Ƶ�ĵ�ַ��");
		String hotelAdress=scanner.next();
		System.out.println("�������Ƿ������꣨1�����꣬0����������");
		int isMainHotel=scanner.nextInt();
		
		HotelInfo hotelInfo=new HotelInfo(hotelNo, hotelName, hotelManager,
				hotelTel, hotelAdress, isMainHotel);
		
		try {
			new HotelInfoDaoImpl().add(hotelInfo);
			System.out.println("insert success,please continue");
			BackUp.hotelManagerBackUp();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void update(){
		System.out.println("������Ҫ�޸ĵľƵ��ţ�");
		Scanner scanner=new Scanner(System.in);
		String hotelNo=scanner.next();
		
		HotelInfoDao dao=new HotelInfoDaoImpl();
		try {
			HotelInfo hotelInfo=dao.findById(hotelNo);
			System.out.println("������Ҫ�޸ĵ��ֶκã�1,�ù�����,2���ùݾ���3���ùݵ绰��"
					+ "4���ùݵ�ַ��5���Ƿ����꣬");
			int num=scanner.nextInt();
			while(num!=1&&num!=2&&num!=3&&num!=4&&num!=5){
				System.out.println("���������ֻ����1��5֮�䡣����");
				num=scanner.nextInt();
			}
			boolean flag=false;
			switch (num) {
			case 1:
				System.out.println("�������ù����ƣ���");
				String hotelName=scanner.next();
				hotelInfo.setHotelName(hotelName);
				flag=true;
				break;
			case 2:
				System.out.println("�������ùݾ���������");
				String hotelManager=scanner.next();
				hotelInfo.setHotelManager(hotelManager);
				flag=true;
				break;
			case 3:
				System.out.println("�������ùݵ绰��");
				String hotelTel=scanner.next();
				hotelInfo.setHotelTel(hotelTel);
				flag=true;
				break;
			case 4:
				System.out.println("�������ùݵ�ַ��");
				String hotelAdress=scanner.next();
				hotelInfo.setHotelAdress(hotelAdress);
				flag=true;
				break;
			case 5:
				System.out.println("�������Ƿ������꣺");
				int isMainHotel=scanner.nextInt();
				hotelInfo.setisMainHotel(isMainHotel);
				flag=true;
				break;
			default:
				break;
			}
			if (flag) {
				dao.update(hotelInfo);
				System.out.println("update success,please continue....");
				BackUp.hotelManagerBackUp();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
