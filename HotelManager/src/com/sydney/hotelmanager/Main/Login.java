package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.sydney.hotelmanager.daoImpl.HotelInfoDaoImpl;
import com.sydney.hotelmanager.daoImpl.UserDaoImpl;
import com.sydney.hotelmanager.entity.HotelInfo;
import com.sydney.hotelmanager.entity.User;

public class Login {
	public static User user=null;
	
	
	/**
	 * ��¼����
	 */
	public static void initLogin() {
		System.out.println("|-------------------���¼---------------------|");
		Login.login();
	}
	
	/**
	 * �û���¼��֤ģ��
	 */
	public static void login() {
		System.out.println("----------�������û���-----------");
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		String username=in.next();
		System.out.println("----------�������û�����--------------");
		String password=in.next();
		int checked=new Random().nextInt(1000)+1000;
		System.out.println("-----------��������֤��:"+checked+"--------------");
		int checking=in.nextInt();
		
		//in.close();
		try {
			user=new UserDaoImpl().findById(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HotelInfo hotelInfo=null;
		try {
			hotelInfo=new HotelInfoDaoImpl().findById(user.getHotelNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (checked==checking) {
			if(user!=null){
				if (password.equals(user.getPassword())) {
					System.out.println("**********��¼�ɹ�����ӭ��:"+user.getRealname()
							+"************************");
					System.out.println("************��ӭ����"+hotelInfo.getHotelName()+"***"
							+ "********************");
					MainPage.initMainInterface(user);
				}else {
					System.out.println("�������,����µ�¼��������");
					Login.initLogin();
					login();
				}
			}else {
				System.out.println("�û��������ڣ�����µ�¼������");
				Login.initLogin();
				login();
			}
		}else {
			System.out.println("��֤����󣡣�����");
			Login.initLogin();
			login();
		}
		
	}

}
