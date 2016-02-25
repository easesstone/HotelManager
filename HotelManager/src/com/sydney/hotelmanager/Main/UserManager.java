package com.sydney.hotelmanager.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sydney.hotelmanager.dao.UserDao;
import com.sydney.hotelmanager.daoImpl.UserDaoImpl;
import com.sydney.hotelmanager.entity.User;

public class UserManager {
	
	/**
	 * 用户管理初始化
	 */
	public static void initUserManager(){
		System.out.println("------------用户管理---------------");
		System.out.println("|-----1，用户一览；2，新增用户--------|");
		System.out.println("|-----3，编辑用户；4，删除用户--------|");
		System.out.println("----请输入数字选择功能操作（1,2,3,4）---------");
		UserManager.doUserManager();
	}
	
	/**
	 * 用户管理模块
	 */
	@SuppressWarnings("resource")
	public static void doUserManager(){
		Scanner scanner=new Scanner(System.in);
		int num=0;
		while(true){
			num=scanner.nextInt();
			if (num==1) {
				doFindAllUserManager();
			}else if (num==2) {
				doAddUserManager();
			}else if (num==3) {
				doUpdateUserManager();
			}else if (num==4) {
				doDeleteUserManager();
			}else if (num==-1) {
				
			}else {
				System.out.println("数字只能是1到4之间，或者输入-1返回主界面。。");
			}
		}
	}
	@SuppressWarnings("resource")
	public static void doAddUserManager(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入用户账号：");
		String username=scanner.next();
		System.out.println("请输入用户密码：");
		String password=scanner.next();
		System.out.println("请输入用户姓名：");
		String realname=scanner.next();
		System.out.println("请输入所属酒店号码");
		String hotelNo=scanner.next();
		System.out.println("请输入是否是经理");
		int isManager=scanner.nextInt();
		
		User user=new User(username, password, realname, hotelNo, isManager);
		UserDao dao=new UserDaoImpl();
		try {
			dao.add(user);
			System.out.println("insert success....");
			System.out.println("请输入0返回上一页，或者1，返回主界面");
			int num=scanner.nextInt();
			while (num!=0&&num!=1) {
				System.out.println("输入值只能是0或1,请从新输入");
				num=scanner.nextInt();
			}
			switch (num) {
			case 0:
				UserManager.initUserManager();
				UserManager.doUserManager();
				break;
			case 1:
				MainPage.initMainInterface(Login.user);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("resource")
	public static void doFindAllUserManager(){
		UserDao dao=new UserDaoImpl();
		List<User>users=new ArrayList<User>();
		try {
			users=dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("查找成功，所有用户如下：");
		for(User user:users){
			System.out.println(user);
		}
		System.out.println("请输入0返回上一页，或者1，返回主界面");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		while (num!=0&&num!=1) {
			System.out.println("输入值只能是0或1,请从新输入");
			num=scanner.nextInt();
		}
		switch (num) {
		case 0:
			UserManager.initUserManager();
			UserManager.doUserManager();
			break;
		case 1:
			MainPage.initMainInterface(Login.user);
			break;
		default:
			break;
		}
	}
	@SuppressWarnings("resource")
	public static void doDeleteUserManager(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要删除的账户的账户号码：");
		String username=scanner.next();
		if (username.equals(Login.user.getUsername())) {
			System.out.println("不能删除当前用户。。请从新输入用户名，，，，");
			username=scanner.next();
		}
		UserDao dao=new UserDaoImpl();
		try {
			dao.delete(username);
			System.out.println("delete success......");
			System.out.println("请输入0返回上一页，或者1，返回主界面");
			int num=scanner.nextInt();
			while (num!=0&&num!=1) {
				System.out.println("输入值只能是0或1,请从新输入");
				num=scanner.nextInt();
			}
			switch (num) {
			case 0:
				UserManager.initUserManager();
				UserManager.doUserManager();
				break;
			case 1:
				MainPage.initMainInterface(Login.user);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("resource")
	public static void doUpdateUserManager(){
		System.out.println("请输入要修改的用户的用户名：");
		Scanner scanner=new Scanner(System.in);
		String username=scanner.next();
		User user=null;
		UserDao dao=new UserDaoImpl();
		try {
			user=dao.findById(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("请输入要修改的字段：1，用户密码，2，用户姓名，3，用户所属酒店编号，"
				+"4,是否是Manager(输入1或2或3或4)");
		int num=0;
		while(true){
			num=scanner.nextInt();
			if(num==1||num==2||num==3||num==4){
				break;
			}
			System.out.println("请从新输入，数字只能是1到4之间的整数");
		}
		
		boolean lable=false;
		switch (num) {
		case 1:
			System.out.println("----------修改用户密码--------");
			System.out.println("请输入用户密码：");
			String password=scanner.next();
			user.setPassword(password);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("----------修改用户姓名----------");
			System.out.println("输入用户姓名：");
			String realname=scanner.next();
			user.setRealname(realname);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("-------修改用户所属酒店编号------------");
			System.out.println("请输入所属酒店编号：");
			String hotelNo=scanner.next();
			user.setPassword(hotelNo);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("-------修改用户是否是Manager------");
			System.out.println("请输入用户是否是Manager0或者1");
			int isManager=scanner.nextInt();
			user. setIsManager(isManager);
			try {
				dao.update(user);
				System.out.println("success.......");
				lable=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("something error.....");
			break;
		}
		if (lable) {
			System.out.println("请输入0返回上一页，或者1，返回主界面");
			int num1=scanner.nextInt();
			while (num1!=0&&num1!=1) {
				System.out.println("输入值只能是0或1,请从新输入");
				num1=scanner.nextInt();
			}
			switch (num1) {
			case 0:
				UserManager.initUserManager();
				UserManager.doUserManager();
				break;
			case 1:
				MainPage.initMainInterface(Login.user);
				break;
			default:
				break;
			}
		}
	}
}
