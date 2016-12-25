/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.dao.IScore;
import com.edu.dao.IStudent;
import com.edu.dao.impl.ScoreImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dto.Student;
import com.edu.service.AdminAssit;
import com.edu.service.CourseAiist;
import com.edu.service.ScourseAiist;
import com.edu.service.StudentAiist;

/**
 * @author Administrator
 *
 */
public class StudentRun {

	static Scanner sc = new Scanner(System.in);
	static IStudent si = new StudentImplMysql();
	static IScore is = new ScoreImplMysql();
	static CourseAiist ic = new CourseAiist();
	static StudentAiist sa = new StudentAiist();
	static ScourseAiist s = new ScourseAiist();
	static AdminAssit aa=new AdminAssit();

	/*
	 * 方法：学生主菜单信息
	 */

	public static void dispStudentMenu() {
		System.out.println("1:*******************************显示个人信息");
		System.out.println("2:*******************************查看成绩单信息");
		System.out.println("3:********************************改密码****");
		System.out.println("4:******************************修改个人信息****");
		System.out.println("5:*****************进行选课(选过后也可修改)***********");
		System.out.println("6:**************************查看自己选课***********");
		System.out.println("7:**************************选课信息***********");
		System.out.println("0:********************************返回系统****");
		System.out.println("**************请输入你的选择*******************");

	}


	/*
	 * 功能：选课主菜单信息
	 */
	public static void selectCourse() throws Exception {
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1:  了解课程信息");
				System.out.println("2：查询课程的代课老师");
				System.out.println("0: 返回主菜单");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:  了解课程信息");
					// knowCourse();
					ic.dispAllCourse();

					break;
				case 2:
					System.out.println("2：查询课程的代课老师\n");

					s.selectBytea();
					break;
				case 0:
					flag = false;
					break;

				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 学生功能主菜单 需要输入学号和密码，方可进入系统
	 */
	public static void StuMenu() {
		try {
			boolean flag = true;
			System.out.println("请输入你的学生学号");
			String stu_id = sc.next();
			System.out.println("请输入你的密码");
			String stu_password = sc.next();
			Student stu = si.loginStudent(stu_id, stu_password);
			if (stu != null) {
				System.out.println("欢迎你:" + stu.getName());
				while (flag) {
					dispStudentMenu();
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1:*******************************显示个人信息");
						sa.findStudent(stu_id);
						break;
					case 2:
						System.out.println("2:*******************************查看本人成绩信息");
						aa.findOneScore(stu_id);

						break;
					case 3:
						System.out.println("********************************返回系统****");
						aa.changePassword();
						break;
					case 4:
						System.out.println("4:******************************修改个人信息****");
						aa.modifyStudent(stu_id);
						break;
					case 5:
						System.out.println("5:*****************进行选课(选过后也可修改)***********");

						s.addScourse(stu_id);

						break;
					case 6:
						System.out.println("6:**************************查看自己选课***********");
						s.dispOneScourse(stu_id);
						break;
					case 7:
						System.out.println("***********************选课信息****");
						selectCourse();
						break;
					case 0:
						System.out.println("********************************返回系统****");
						flag = false;
						break;
					default:
						break;

					}
				}

			} else {
				System.out.println("学生不存在！！");
			}
		} catch (Exception e) {

		}

	}

}
