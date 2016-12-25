/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IStudent;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dto.Student;

/**
 * @author 卢福强 功能：增加，删除，修改，查询，显示学生信息， 学生登录
 *
 */
public class StudentAiist {

	static Scanner sc = new Scanner(System.in);
	IStudent student = new StudentImplMysql();

	/*
	 * 功能：添加学生 显示添加的时间
	 */
	public void addStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Student s = new Student();
				System.out.println("请输入学生学号");
				s.setNum(sc.next());
				System.out.println("请输入学生姓名");
				s.setName(sc.next());
				System.out.println("请输入学生性别");
				s.setSex(sc.next());
				System.out.println("请输入学生年龄");
				s.setAge(sc.nextInt());
				System.out.println("请输入学生的身份证号码");
				s.setStuId(sc.next());
				System.out.println("请输入系部");
				System.out.println("1:汽车系   2：经贸系  3： 机电系  4： 艺术系   5  ： 信息系  6： 土木系");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					s.setDepartment("汽车系");
					break;
				case 2:
					s.setDepartment("经贸系 ");
					break;
				case 3:
					s.setDepartment("机电系");
					break;
				case 4:
					s.setDepartment("艺术系 ");
					break;
				case 5:
					s.setDepartment("信息系");
					break;
				case 6:
					s.setDepartment("土木系");
					break;

				default:
					break;
				}

				if (student.addStudent(s)) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失败!!");
				}

				System.out.println("输入n或N停止添加，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 功能：显示所有学生信息
	 */
	public void dispAllStudent() throws Exception {
		List<Student> sList = student.lispStudent();
		System.out.println("学号\t姓名\t性别\t年龄\t身份证号码\t\t\t毕业日期\t\t系部");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
	}

	/*
	 * 功能:删除学生信息
	 */
	public void deleteStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu != null) {
					System.out.println("是否要删除，是的话输入1再次确认删除，任意键退出删除");
					System.out.println("学号\t姓名\t性别\t年龄\t专业\t\t班级\t身份证号码\t\t\t毕业日期\t选课课程");
					System.out.println(stu);
					int key = sc.nextInt();
					if (key == 1) {
						if (student.deleteStudent(num)) {
							System.out.println("删除成功");
						} else {
							System.out.println("删除失败！");
						}
					}

				} else {
					System.out.println("学生学号不存在！！");
				}
				System.out.println("是否退出删除功能，任意键继续，n或者N退出");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 功能：修改学生信息
	 */
	public void modifyStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要修改的学生学号");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu != null) {
					System.out.println("学号\t姓名\t性别\t年龄\t专业\t\t班级\t身份证号码\t\t\t毕业日期\t选课课程");
					System.out.println(stu);
					System.out.println("\n\n");
					System.out.println("1:  修改姓名");
					System.out.println("2:  修改姓别");
					System.out.println("3：请修改年龄");
					System.out.println("4:  修改身份证号码");

					System.out.println("请进行选择：");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("请输入姓名");
						stu.setName(sc.next());
						break;
					case 2:
						System.out.println("请输入姓别");
						stu.setSex(sc.next());
						break;
					case 3:
						System.out.println("请输入年龄");
						stu.setAge(sc.nextInt());
						break;

					case 4:
						System.out.println("请输入身份证号码");
						stu.setStuId(sc.next());
						break;

					default:
						break;
					}

				} else {
					System.out.println("学生学号不存在！！");
				}
				if (student.modifyStudent(stu)) {
					System.out.println("修改成功！");
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
	 * 功能：查询学生信息
	 */
	public void findStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入编号 1：按照学号查询  2： 按照姓名查询");
				int key = sc.nextInt();
				System.out.println("请输入关键字");
				String keyname = sc.next();
				List<Student> sList = student.findStudent(key, keyname);
				if (sList != null) {
					System.out.println("学号\t姓名\t性别\t年龄\t身份证号码\t\t\t毕业日期\t\t选课课程\t系部");
					for (int i = 0; i < sList.size(); i++) {
						System.out.println(sList.get(i));
					}

				} else {
					System.out.println("学生学号不存在！！");
				}

				System.out.println("输入n或者N停止修改，任意键继续");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：查看个人学生信息 参数：num 学号
	 */

	public void findStudent(String num) throws Exception {
		try {

			Student stu = student.findStudent(num);
			if (stu != null) {
				System.out.println("学号\t姓名\t性别\t年龄\t身份证号码\t\t毕业日期\t系部");

				System.out.println(stu);
			} else {
				System.out.println("学生学号不存在！！");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
}
