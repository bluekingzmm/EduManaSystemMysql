/**
 * 
 */
package com.edu.service;

import java.util.List;

import java.util.Scanner;

import com.edu.dao.IAdmin;
import com.edu.dao.ICourse;
import com.edu.dao.IStudent;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AdminMysqlImpl;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Teacher;
/**
 * @author 汪潭
 *  功能：增加，删除，修改，查询，显示，排序，教师登录
 *
 */
public class TeacherAiist {

	static ITeacher teacher = new TeacherImplMysql();
	static Scanner sc = new Scanner(System.in);
	static IStudent student = new StudentImplMysql();
	static ICourse course = new CourseImplMysql();
	static IAdmin admin=new AdminMysqlImpl();

	/*
	 * 功能：添加教师 
	 */
	public void addTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Teacher tea = new Teacher();
				System.out.println("请输入教师编号");
				tea.setNum(sc.next());
				System.out.println("请输入教师姓名");
				tea.setName(sc.next());
				System.out.println("请输入教师性别");
				tea.setSex(sc.next());
				System.out.println("请输入教师年龄");
				tea.setAge(sc.nextInt());
				System.out.println("请输入教师所授课的编号");
				tea.setCourse_id(sc.next());
				System.out.println("请输入教师的电话号码");
				tea.setTea_tel(sc.next());
				if (teacher.addTeacher(tea)) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失败");
				}
				System.out.println("输入n或者N停止添加，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：显示所有教师信息
	 */
	public void dispAllTeacher() throws Exception {
		List<Teacher> sList = teacher.dispAllTeacher();
		System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码\t等级");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
	}

	

	/*
	 * 功能：删除教师信息
	 */
	public void deleteTeacher() throws Exception {

		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("请输入教师编号");
				String code = sc.next();
				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("是否要删除，是的话输入1再次确认删除，任意键退出删除");
					System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码");
					System.out.println(tea);
					int key = sc.nextInt();
					if (key == 1) {
						if (teacher.deleteTeacher(code)) {
							System.out.println("删除成功");
						} else {
							System.out.println("删除失败！");
						}
					}
				} else {
					System.out.println("教师编号不存在！");
				}

				System.out.println("输入n或者N停止删除，任意键继续");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：查询教师信息
	 * 
	 */

	public void findTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入教师的编号");
				String code = sc.next();
				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码\t工资\t等级");
					System.out.println(tea);
				} else {
					System.out.println("教师编号不存在！");
				}
				System.out.println("输入n或者N停止查找，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/*
	 * 功能：修改教师信息
	 */
	public void modifyTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入要修改的教师编号");
				String code = sc.next();
				Teacher tea = teacher.findTeacher(code);
				if (tea != null) {
					System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码");
					System.out.println(tea);
					System.out.println("1：请输入教师姓名");
					System.out.println("2：请输入教师性别");
					System.out.println("3：请输入教师年龄");
					System.out.println("4：请输入所授课课程编号");
					System.out.println("5：请输入电话号码 ");
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
						System.out.println("4：请输入所授课课程编号");
						tea.setCourse_id(sc.next());
						break;
					case 5:
						System.out.println("5：请输入电话号码");
						tea.setTea_tel(sc.next());
						break;
				

					default:
						break;
					}
					if (teacher.modifyTeacher(tea)) {
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
	 * 功能：教师排序
	 */
	public void sortTeacher() throws Exception {

		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("按照教师等级排序");
				List<Teacher> sList = teacher.sortTeacher();
				System.out.println("教师编号\t教师姓名\t性别\t年龄\t所授课课程编号\t电话号码\t等级");
				for (int i = 0; i < sList.size(); i++) {
					System.out.println(sList.get(i));
				}
				System.out.println("输入n或者N停止排序，任意键继续！");
				yes=sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}



	
}
