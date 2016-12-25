/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.service.AdminAssit;

/**
 * @author Administrator
 *
 */
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static AdminAssit aa = new AdminAssit();

	public static void login() {
		try {
			disp();
			boolean flag = true;
			while (flag) {
				System.out.println("1：管理员登录");
				System.out.println("2：教师登陆");
				System.out.println("3:学生登陆");
				System.out.println("0:退出系统");
				System.out.println("请进行选择");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					if (aa.loginAdmin()) {
						AdminRun.MainMenu();
					} else {
						System.out.println("请你重新输入！");
					}

					break;
				case 2:
					TeacherRun.TeacherMain();
					break;
				case 3:
					StudentRun.StuMenu();
					break;
				case 0:
					System.out.println("正在退出，请稍候");
					for (int i = 0; i < 20; i++) {
						Thread.sleep(200);
						System.out.print("*");
					}

					System.exit(0);
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void disp() throws Exception {
		System.out.println(
				"┌────────────────────────────────────────────────────────────────────────┐\n");
		System.out.println(
				"│                                                                        │\n");
		System.out.println(
				"│                                            **  欢迎你来到                                        │\n");
		System.out.println(
				"│                                                教务管理系统                                    │\n");
		System.out.println(
				"│                                                                       │\n");
		System.out.println( 
				"│                                                                       │\n");
		System.out.println(
				"│                          ******    第六组组员：张明明，王浩，汪潭，卢富强                   │\n");
		System.out.println(
				"│                                                            2016.6.17  │\n");
		System.out.println(
				"└───────────────────────────────────────────────────────────────────────┘\n");
		for (int a = 0;  a < 40; a++) {
			Thread.sleep(40);
			System.out.print("<*");

		}
		System.out.println();
	}

}
