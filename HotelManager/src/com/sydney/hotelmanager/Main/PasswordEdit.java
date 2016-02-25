package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sydney.hotelmanager.daoImpl.UserDaoImpl;

public class PasswordEdit {
	
	/**
	 * 密码修改
	 */
	public static void initPasswordEdit(){
		System.out.println("----------密码修改----------------");
	}

	
	/**
	 * 用户修改密码模块
	 */
	public static void doPasswordEdit(){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("----请输入旧密码确认,或者输入exit退出到主页面---------------");
		String checkPassword=scanner.next();
		while(true){
			if (checkPassword.equals(Login.user.getPassword())) {
				System.out.println("请输入新密码：");
				String newpassword=scanner.next();
				Login.user.setPassword(newpassword);
				break;
			}if ("exit".equals(checkPassword)) {
				MainPage.initMainInterface(Login.user);
				return;
			}
			System.out.println("请从新输入旧密码确认,或者输入exit退回上一界面");
			checkPassword=scanner.next();
		} 
		try {
			if (Login.user!=null) {
				new UserDaoImpl().update(Login.user);
				System.out.println("sucess");
				MainPage.initMainInterface(Login.user);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		}
	}

}
