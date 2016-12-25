/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IAdmin;
import com.edu.dao.IStudent;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AdminMysqlImpl;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.AdminUser;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author 张明明
 * 功能：管理员登陆，修改学生个人信息，得到学生密码，
 * 查询学生个人成绩，通过教师编号查询教师编号，
 * 显示本班学生成绩，显示本班学生信息
 * 得到教师编号，修改教师个人信息
 * 
 */
public class AdminAssit {

	static Scanner sc = new Scanner(System.in);
	static IAdmin a = new AdminMysqlImpl();
	static IStudent student = new StudentImplMysql();
	static ITeacher teacher =new TeacherImplMysql();

	
	/*
	 * 功能：管理员登录信息
	 */

	public boolean loginAdmin() throws Exception {
		try {

			System.out.println("请输入管理员用户名");
			String username = sc.next();
			System.out.println("请输入密码");
			String userpassword = sc.next();
			AdminUser adm = a.loginAdmin(username, userpassword);
			if (adm != null) {
				System.out.println("登录成功！");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
	
	/*
	 * 功能：修改学生个人信息 参数：num 学号
	 */

	public void modifyStudent(String num) throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				Student stu = student.findStudent(num);
				if (stu != null) {
					System.out.println("学号\t姓名\t性别\t年龄\t专业\t\t班级\t身份证号码\t\t\t毕业日期\t选课课程");
					System.out.println(stu);
					System.out.println("\n\n");
					System.out.println("1:  修改姓名");
					System.out.println("2：请修改年龄");
					System.out.println("3:  修改身份证号码");
					System.out.println("请进行选择：");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("请输入姓名");
						stu.setName(sc.next());
						break;

					case 2:
						System.out.println("请输入年龄");
						stu.setAge(sc.nextInt());
						break;

					case 3:
						System.out.println("请输入身份证号码");
						stu.setStuId(sc.next());
						break;

					default:
						break;
					}

				} else {
					System.out.println("学生学号不存在！！");
				}
				if (a.modifyOwnStudent(stu)) {
					System.out.println("修改成功！");
					System.out.println("学号\t姓名\t性别\t年龄\t专业\t\t班级\t身份证号码\t\t\t毕业日期");
					System.out.println(stu);
				} else {
					System.out.println("修改失败！");
				}

				System.out.println("输入n或者N停止修改，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*
	 * 功能：修改个人密码 初始密码000
	 */
	public void changePassword() throws Exception {
		try {
			System.out.println("请输入你的原来密码");
			String password = sc.next();
			Student stu = a.getPassword(password);
			if (stu != null) {
				System.out.println("原密码：" + password);
				System.out.println("请输入新密码");
				String newpassword = sc.next();
				if (password.equals(newpassword)) {
					System.out.println("不能和原来的密码相同");
					return;
				}
				System.out.println("请再一次输入密码，进行确认");

				String arginpassword = sc.next();
				if (newpassword.equals(arginpassword)) {
					stu.setStuPassword(arginpassword);
					if (student.modifyStudent(stu)) {
						System.out.println("密码修改成功！");
					} else {
						System.out.println("修改失败！！");
					}
				} else {
					System.out.println("两次输入的不同！！");
				}
			} else {
				System.out.println("密码不存在");
				System.out.println(stu);
			}
		} catch (Exception sql) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：查看个人成绩 参数：num 学号 视图：VScore1
	 */
	public void findOneScore(String num) throws Exception {
		try {
			List<StuScore> v = a.findByStudent(num);
			if (v != null) {
				System.out.println("课程编号\t学生学号\t学生姓名\t教师编号\t成绩\t课程名\t教师名");
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i) + "\t" + v.get(i).getCourse().getCourse_name() + "\t"
							+ v.get(i).getTea().getName());
				}
			} else {
				System.out.println("不存在学生编号");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*
	 * 功能：修改教师密码 需要寻找教师密码，看是否存在才能修改，默认密码000
	 */
	public void changeTeaPassword() throws Exception {
		try {
			System.out.println("请输入你的原来密码");
			String password = sc.next();
			Teacher tea = a.getTeaPassword(password);
			if (tea != null) {
				System.out.println("原密码：" + password);
				System.out.println("请输入新密码");
				String newpassword = sc.next();
				if (password.equals(newpassword)) {
					System.out.println("不能和原来的密码相同");
					return;
				}
				System.out.println("请再一次输入密码，进行确认");

				String arginpassword = sc.next();
				if (newpassword.equals(arginpassword)) {
					tea.setTea_password(arginpassword);
					if (teacher.modifyTeacher(tea)) {
						System.out.println("密码修改成功！");
					} else {
						System.out.println("修改失败！！");
					}
				} else {
					System.out.println("两次输入的不同！！");
				}
			} else {
				System.out.println("密码不存在");

			}
		} catch (Exception sql) {
			// TODO: handle exception
		}

	}
	/*
	 * 功能：修改教师个人信息 参数：code 教师编号
	 */
	public void modifyTeacher(String code) throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码\t工资\t等级");
					System.out.println(tea);
					System.out.println("1：请输入教师姓名");
					System.out.println("2：请输入教师性别");
					System.out.println("3：请输入教师年龄");
					System.out.println("4：请输入电话号码 ");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1：请输入教师姓名");
						tea.setName(sc.next());
						break;
					case 2:
						System.out.println("2：请输入教师性别");
						tea.setSex(sc.next());
						break;
					case 3:
						System.out.println("3：请输入教师年龄");
						tea.setAge(sc.nextInt());
						break;

					case 4:
						System.out.println("5：请输入电话号码");
						tea.setTea_tel(sc.next());
						break;

					default:
						break;
					}
					if (a.modifyOneTeacher(tea)) {
						System.out.println("修改成功！");

					} else {
						System.out.println("修改失败！");
					}
				} else {
					System.out.println("教师编号不存在！");
				}
				System.out.println("输入n或者N停止修改，任意键继续");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*
	 * 功能：显示本班学生信息 参数 code 教师编号 视图：VScore
	 */

	public void dispStudentInfo(String code) throws Exception {
		try {
			a.LispStudentInfo(code);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：查看本班学生成绩 参数：code 视图：VScore1
	 */
	public void dispStudentScore(String code) throws Exception {
		try {
			a.LispStudentScore(code);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*
	 * 功能：显示教师个人信息 参数：code 教师编号
	 */
	public void findOneTeacher(String code) throws Exception {
		try {

			Teacher tea = teacher.findTeacher(code);
			if (tea != null) {
				System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码\t工资\t等级");
				System.out.println(tea);
			} else {
				System.out.println("教师编号不存在！");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
