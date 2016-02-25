package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.MoneyDao;
import com.sydney.hotelmanager.daoImpl.MoneyDaoImpl;
import com.sydney.hotelmanager.entity.BusinessDetails;

public class MoneyManager {

	/**
	 * ����״��ͳ��
	 */
	public static void initMoneyManager(){
		System.out.println("--------����״��ͳ�� ------------");
		System.out.println("------1��Ӫҵ״��ͳ��--------");
	}
	
	
	@SuppressWarnings("resource")
	public static void doMoneyManager(){
		System.out.println("��ѡ��1������Ӫҵ��״��ͳ�ƣ�2������Ӫҵ��ͳ�ƣ�3������Ӫҵ��ͳ��");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("����Ӫҵ״��ͳ�ƣ�");
			currentDay();
			break;
		case 2:
			System.out.println("����ӨӨ״��ͳ�ƣ�");
			currentMonth();
			break;
		case 3:
			System.out.println("����Ӫҵ״��ͳ��");
			currentYear();
			break;

		default:
			break;
		}
	}


	private static void currentYear() {
		MoneyDao dao=new MoneyDaoImpl();
		int money=0;
		List<BusinessDetails>businessDetails=new ArrayList<BusinessDetails>();
		 
		try {
			businessDetails=dao.currentYearsDetails();
			money=dao.currentYearsMoney();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�����ܶ�Ϊ��"+money);
		System.out.println("��ϸ������£�");
		for(BusinessDetails businessDetail:businessDetails){
			System.out.println(businessDetail);
		}
		BackUp.MoneyManagerBackUp();
		
	}


	private static void currentMonth() {
		MoneyDao dao=new MoneyDaoImpl();
		int money=0;
		List<BusinessDetails>businessDetails=new ArrayList<BusinessDetails>();
		 
		try {
			businessDetails=dao.currentMonthsDetails();
			money=dao.currentMonthsMoney();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�����ܶ�Ϊ��"+money);
		System.out.println("��ϸ������£�");
		for(BusinessDetails businessDetail:businessDetails){
			System.out.println(businessDetail);
		}
		BackUp.MoneyManagerBackUp();
	}


	private static void currentDay() {
		MoneyDao dao=new MoneyDaoImpl();
		int money=0;
		List<BusinessDetails>businessDetails=new ArrayList<BusinessDetails>();
		 
		try {
			businessDetails=dao.currentDaysDetails();
			money=dao.currentDaysMoney();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�����ܶ�Ϊ��"+money);
		System.out.println("��ϸ������£�");
		for(BusinessDetails businessDetail:businessDetails){
			System.out.println(businessDetail);
		}
		BackUp.MoneyManagerBackUp();
	}
}
