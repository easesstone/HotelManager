package com.sydney.hotelmanager.Main;

import java.util.Scanner;

public class InitMain {
	/**
	 * 初始化界面
	 */
	@SuppressWarnings("resource")
	public static void initMain() {
		System.out.println("|--------------欢迎登录酒店管理系统----------------|");
		System.out.println("|-------------------主要功能-----------------------|");
		System.out.println("|-----1，密码管理；2，用户管理； 3，酒店管理；-----------|");
		System.out.println("|-----4，客房类型管理；5，宾客信息管理；6，客房管理；------|");
		System.out.println("|-----7，入住管理；8，财务管理，9，退出-----------------|");
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入0先登录！！！或者-2返回");
		int num=-1;
		while(true){
			num=scanner.nextInt();
			if(num==0){
				break;
			}else if (num==-1) {
				initMain();
			}
			System.out.println("请输入0先登录！！！或者-2返回");
		}
		Login.initLogin();
	}
}
