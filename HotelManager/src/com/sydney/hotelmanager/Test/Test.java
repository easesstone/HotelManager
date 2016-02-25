package com.sydney.hotelmanager.Test;

import java.sql.SQLException;

import com.sydney.hotelmanager.daoImpl.MoneyDaoImpl;

public class Test {

	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		int num=scanner.nextInt();
//		System.out.println(num);
		
		try {
			System.out.println(new MoneyDaoImpl().currentDaysMoney());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//java.util.Date date2=new Date
	}
}
