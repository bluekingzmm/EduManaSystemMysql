/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.dao.ITeacher;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Teacher;
import com.edu.service.AdminAssit;
import com.edu.service.AssessAiist;
import com.edu.service.StuScoreAiist;
import com.edu.service.StudentAiist;
import com.edu.service.TeacherAiist;

/**
 * @author Administrator
 *
 */
public class TeacherRun {

	static Scanner sc = new Scanner(System.in);
	static ITeacher teacher = new TeacherImplMysql();
	static TeacherAiist ta = new TeacherAiist();
	static StudentAiist sa = new StudentAiist();
	static StuScoreAiist ssa = new StuScoreAiist();
	static AssessAiist Aa = new AssessAiist();
	static AdminAssit aa = new AdminAssit();

	public static void dispTeacherMenu() {
		System.out.println("1:*******************************显示个人信息");
		System.out.println("2:*****************************查看本班学生信息");
		System.out.println("3:**********************查看本班学生成绩信息****");
		System.out.println("4:**********************修改密码*************");
		System.out.println("5:*******************修改个人信息*************");
		System.out.println("6:*****************添加本班学生成绩*************");
		System.out.println("7:*******************显示自己评价**************");
		System.out.println("0:********************************返回系统****");
		System.out.println("**************请输入你的选择*******************");

	}

	/*
	 * 方法:教师主菜单
	 */
	public static void TeacherMain() {
		try {

			boolean flag = true;
			System.out.println("请输入你的教师编号");
			String code = sc.next();

			System.out.println("请输入你的密码");
			String tea_password = sc.next();

			Teacher tea = teacher.loginTeacher(code, tea_password);
			if (tea != null) {
				System.out.println("欢迎你:" + tea.getName());
				while (flag) {
					dispTeacherMenu();
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1:*******************************显示个人信息");
						aa.findOneTeacher(code);

						break;
					case 2:
						System.out.println("2:*******************************查看本班学生信息");
						aa.dispStudentInfo(code);
						break;
					case 3:
						System.out.println("3:********************************查看本班学生成绩信息****");
						aa.dispStudentScore(code);
						break;
					case 4:
						System.out.println("4:**********************修改密码****");
						aa.changePassword();
						break;
					case 5:
						System.out.println("5:*******************修改个人信息****");
						aa.modifyTeacher(code);
						break;
					case 6:
						System.out.println("6:*****************添加本班学生成绩*************");
						ssa.addStuScore(code);
						break;
					case 7:
						System.out.println("7:*******************显示自己评价**************");
						Aa.findMemoByTeacher(code);

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
				System.out.println("教师不存在！！");
			}
		} catch (Exception e) {

		}

	}

}
