package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.GuestDao;
import com.sydney.hotelmanager.daoImpl.GuestDaoImpl;
import com.sydney.hotelmanager.entity.Guest;

public class GuestManager {
	/**
	 * ������Ϣ����
	 */
	public static void initGuestManager(){
		System.out.println("-------������Ϣ����------------");
		System.out.println("-------1���ڵ���Ͳ�ѯ-----------");
		System.out.println("-------2��������ס��¼��ѯ------------");
		System.out.println("----����������ѡ���ܲ�����1,2��---------");
	}
	/**
	 * ���͹�����ز���
	 */
	@SuppressWarnings("resource")
	public static void doGuestManager(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while(num!=1&&num!=2){
			System.out.println("���������ֻ����1����2,��������룺");
			num=scanner.nextInt();
		}
		switch (num) {
		case 1:
			finInNow();
			break;

		case 2:
			GuestRecord();
			break;
		default:
			break;
		}
	}
	@SuppressWarnings("resource")
	private static void GuestRecord() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫ����ʲô���ҿ��˼�¼��1���������֤�ţ�2����������");
		int num=scanner.nextInt();
		while(num!=1&&num!=2){
			System.out.println("���������ֻ����1����2");
			num=scanner.nextInt();
		}
		switch (num) {
		case 1:
			findByShenFenNo();
			break;
			
		case 2:
			findByDate();
			break;
		default:
			break;
		}
	}
	@SuppressWarnings("resource")
	private static void findByDate() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫ��ѯ�����ڣ���ʽΪxxxx-xx-xx");
		String bookDate=scanner.next();
		
		//���Ӽ��Ĳ��裬������ڸ�ʽ�Ƿ���ȷ��
		List<Guest>guests=new ArrayList<Guest>();
		
		GuestDao dao=new GuestDaoImpl();
		try {
			guests=dao.findByDate(bookDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("�������ڲ��ҵĿ��˼�¼���£�");
		for(Guest guest:guests){
			System.out.println(guest);
		}
		BackUp.guestManagerBackUp();
	}
	@SuppressWarnings("resource")
	private static void findByShenFenNo() {
		System.out.println("�����������ݺ��룺");
		Scanner scanner=new Scanner(System.in);
		
		String guestShenFenNo=scanner.next();
		GuestDao dao=new GuestDaoImpl();
		List<Guest>guests=new ArrayList<Guest>();
		
		try {
			guests=dao.findById(guestShenFenNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("���ҵĹ˿���ϢΪ��");
		for(Guest guest:guests){
			System.out.println(guest);
		}
		System.out.println();
		BackUp.guestManagerBackUp();
	}
	private static void finInNow() {
		GuestDao dao=new GuestDaoImpl();
		List<Guest>guests=new ArrayList<Guest>();
		try {
			guests=dao.findByInNow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("�ڵ�������£�");
		for(Guest guest:guests){
			System.out.println(guest);
		}
		System.out.println();
		BackUp.guestManagerBackUp();
	}
}
