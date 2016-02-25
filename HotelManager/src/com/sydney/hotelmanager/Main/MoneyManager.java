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
	 * 财务状况统计
	 */
	public static void initMoneyManager(){
		System.out.println("--------财务状况统计 ------------");
		System.out.println("------1，营业状况统计--------");
	}
	
	
	@SuppressWarnings("resource")
	public static void doMoneyManager(){
		System.out.println("请选择：1，当天营业额状况统计，2，当月营业额统计，3，当年营业额统计");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("当天营业状况统计，");
			currentDay();
			break;
		case 2:
			System.out.println("当月莹莹状况统计：");
			currentMonth();
			break;
		case 3:
			System.out.println("当年营业状况统计");
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
		
		System.out.println("当年总额为："+money);
		System.out.println("详细情况如下：");
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
		
		System.out.println("当月总额为："+money);
		System.out.println("详细情况如下：");
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
		
		System.out.println("当天总额为："+money);
		System.out.println("详细情况如下：");
		for(BusinessDetails businessDetail:businessDetails){
			System.out.println(businessDetail);
		}
		BackUp.MoneyManagerBackUp();
	}
}
