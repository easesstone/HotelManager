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
	 * 登录界面
	 */
	public static void initLogin() {
		System.out.println("|-------------------请登录---------------------|");
		Login.login();
	}
	
	/**
	 * 用户登录验证模块
	 */
	public static void login() {
		System.out.println("----------请输入用户名-----------");
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		String username=in.next();
		System.out.println("----------请输入用户密码--------------");
		String password=in.next();
		int checked=new Random().nextInt(1000)+1000;
		System.out.println("-----------请输入验证码:"+checked+"--------------");
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
					System.out.println("**********登录成功，欢迎您:"+user.getRealname()
							+"************************");
					System.out.println("************欢迎来到"+hotelInfo.getHotelName()+"***"
							+ "********************");
					MainPage.initMainInterface(user);
				}else {
					System.out.println("密码错误,请从新登录！！！！");
					Login.initLogin();
					login();
				}
			}else {
				System.out.println("用户名不存在，请从新登录！！！");
				Login.initLogin();
				login();
			}
		}else {
			System.out.println("验证码错误！！！！");
			Login.initLogin();
			login();
		}
		
	}

}
