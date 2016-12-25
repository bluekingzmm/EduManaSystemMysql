/**
 * 
 */
package com.edu.run;

import java.util.Scanner;

import com.edu.service.AssessAiist;
import com.edu.service.CourseAiist;
import com.edu.service.ScourseAiist;
import com.edu.service.StuScoreAiist;
import com.edu.service.StudentAiist;
import com.edu.service.TeacherAiist;

/**
 * @author Administrator
 *
 */
public class AdminRun {

	/**
	 * @param args
	 */

	static Scanner sc = new Scanner(System.in);
	static TeacherAiist ta = new TeacherAiist();
	static StudentAiist si = new StudentAiist();
	static AssessAiist aa = new AssessAiist();
	static CourseAiist ca = new CourseAiist();
	static StuScoreAiist Sa = new StuScoreAiist();
	static ScourseAiist sa = new ScourseAiist();

	/*
	 * 方法：学生主菜单 switch进行选择
	 */

	public static void StudentMain() {
		try {
			boolean flag = true;
			while (flag) {
				dispMenu();
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:***********    添加学生信息       ***********");
					si.addStudent();
					break;
				case 2:
					System.out.println("2:***********    显示学生信息       ***********");
					si.dispAllStudent();
					break;
				case 3:
					System.out.println("3:***********    删除学生信息       ***********");
					si.deleteStudent();
					break;
				case 4:
					System.out.println("4:***********    修改学生信息       ***********");
					si.modifyStudent();
					break;

				case 5:
					System.out.println("5:***********    查询学生信息       ***********");
					si.findStudent();
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
	 * 方法：课程主菜单
	 */
	public static void courseInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1:*******************************增加课程信息");
				System.out.println("2:*******************************删除课程信息");
				System.out.println("3:*******************************修改课程信息");
				System.out.println("4:*************************按照课程编号查询课程信息");
				System.out.println("5:*******************************查询课程所有信息");
				System.out.println("0:**********************************返回主菜单");

				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************增加课程信息");
					ca.AddCourse();
					break;
				case 2:
					System.out.println("2:*******************************删除课程信息");
					ca.DelectCourse();
					break;
				case 3:
					System.out.println("3:*******************************修改课程信息");
					ca.ModifyCourse();
					break;
				case 4:
					System.out.println("4:**************************按照课程编号查询课程信息");
					ca.findByCode();
					break;
				case 5:
					System.out.println("5:*******************************查询课程所有信息");
					ca.dispAllCourse();
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
	 * 方法:学生主菜单信息
	 */
	public static void dispMenu() {
		System.out.println("1:***********    添加学生信息       ***********");
		System.out.println("2:***********    显示学生信息       ***********");
		System.out.println("3:***********    删除学生信息       ***********");
		System.out.println("4:***********    修改学生信息       ***********");
		System.out.println("5:***********    查询学生信息   *****");
		// System.out.println("6:*********** 按照姓名查询学生信息 *****");
		// System.out.println("7:*********** 排序学生信息 ***********");
		System.out.println("0:***********    返回学生菜单       ***********");
		System.out.println("                请输入你的选择");
	}

	/*
	 * 方法：教师主菜单
	 */
	public static void TeacherMain() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				dispTeacherMenu();
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:***********    添加教师信息       ***********");
					ta.addTeacher();

					break;

				case 2:
					System.out.println("2:***********    显示教师信息       ***********");
					ta.dispAllTeacher();

					break;
				case 3:
					System.out.println("3:***********    删除教师信息       ***********");
					ta.deleteTeacher();

					break;
				case 4:
					System.out.println("4:***********    修改教师信息       ***********");
					ta.modifyTeacher();

					break;
				case 5:
					System.out.println("5:***********    查询教师信息       ***********");
					ta.findTeacher();

					break;
				case 6:
					System.out.println("6:***********    排序教师信息       ***********");
					ta.sortTeacher();
				case 0:
					flag = false;
				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 方法：教师评价主菜单
	 */
	public static void AssessMain() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				dispAssessMenu();
				int key = sc.nextInt();
				switch (key) {

				case 1:
					System.out.println("1:***********    显示评价信息       ***********");
					aa.dispAllAssess();
					break;
				case 2:
					System.out.println("3:***********    删除评价信息       ***********");
					aa.deleteAssess();
					break;
				case 3:
					System.out.println("4:***********    修改评价信息       ***********");
					aa.modeifyAssess();
					break;
				case 4:
					System.out.println("5:***********    查询评价信息       ***********");
					aa.findAssess();
					break;
				case 0:
					flag = false;
				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 方法：教师主菜单信息
	 */
	public static void dispTeacherMenu() {
		System.out.println("1:***********    增加教师信息       ***********");
		System.out.println("2:***********    显示教师信息       ***********");
		System.out.println("3:***********    删除教师信息       ***********");
		System.out.println("4:***********    修改教师信息       ***********");
		System.out.println("5:***********    查询教师信息       ***********");
		System.out.println("6:***********    排序教师信息       ***********");
		System.out.println("0:***********    返回教师菜单       ***********");
		System.out.println("                请输入你的选择");
	}

	/*
	 * 方法：教师评价主菜单信息
	 */
	public static void dispAssessMenu() {
		System.out.println("1:***********    显示评价信息       ***********");
		System.out.println("2:***********    删除评价信息       ***********");
		System.out.println("3:***********    修改评价信息       ***********");
		System.out.println("4:***********    查询评价信息       ***********");
		System.out.println("0:***********    返回菜单       ***********");
		System.out.println("                请输入你的选择");
	}

	/*
	 * 方法：成绩主菜单信息
	 */
	public static void scoreInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				// System.out.println("1:*******************************添加成绩信息");
				System.out.println("1:********************************删除成绩信息****");
				System.out.println("2:********************************修改成绩信息****");
				System.out.println("3:********************按照学生学号删除所有成绩信息****");
				System.out.println("4:*******************按照课程编号删除所有成绩信息成绩****");
				System.out.println("5:*******************按照课程编号查询所有成绩信息成绩****");
				System.out.println("6:*******************按照学生学号查询所有成绩信息成绩****");
				System.out.println("7:*******************查看所有成绩*******************");
				System.out.println("8:***************按照课程编号进行分数排序（由高到低）显示**");
				System.out.println("9:***************按照课程编号查看本课程成绩的总分和平均分**");
				System.out.println("0:*******************************返回主菜单*********");

				int key = sc.nextInt();
				switch (key) {

				// case 1:
				// System.out.println("1:*******************************添加成绩信息");
				// Sa.addStuScore();
				// break;
				case 1:
					System.out.println("1:********************************删除成绩信息****");
					Sa.deleteScore();
					break;
				case 2:
					System.out.println("2:********************************修改成绩信息****");
					Sa.modifyStuScore();
					break;
				case 3:
					System.out.println("3:********************按照学生学号删除所有成绩信息****");
					Sa.deleteScoreByStu();
					break;
				case 4:
					System.out.println("4:*******************按照课程编号删除所有成绩信息成绩****");
					Sa.deleteScoreByCourse();
					break;
				case 5:
					System.out.println("5:*******************按照课程编号查询所有成绩信息成绩****");
					Sa.findScoreByCourse();
					break;
				case 6:
					System.out.println("6:*******************按照学生学号查询所有成绩信息成绩****");
					Sa.findScoreByStu();
					break;
				case 7:
					System.out.println("7:*******************查看所有成绩()***************");
					Sa.ListAllScore();
					break;
				case 8:
					System.out.println("8:***************按照课程编号进行分数排序（由高到低）显示**");
					Sa.disp();
					break;
				case 9:
					System.out.println("9:***************按照课程编号查看本课程成绩的总分和平均分**");
					Sa.findCourseScoreLookExam();
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
	 * 方法：主菜单信息
	 */
	public static void MainMenu() {
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1：学生管理 ");
				System.out.println("2:教师管理");
				System.out.println("3:课程管理");
				System.out.println("4:成绩管理");
				System.out.println("5:评价管理");
				System.out.println("6:选课管理");
				System.out.println("0:返回主菜单");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					StudentMain();
					break;
				case 2:
					TeacherMain();
					break;
				case 3:
					courseInfo();
					break;
				case 4:
					scoreInfo();
					break;
				case 5:
					AssessMain();
					break;
				case 6:
					selectCourse();

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
	 * 方法：选课主菜单信息
	 */
	public static void selectCourse() throws Exception {
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1：查询课程的代课老师");
				System.out.println("2:查看选课情况");
				System.out.println("3:排课");
				System.out.println("0: 返回主菜单");
				int key = sc.nextInt();
				switch (key) {

				case 1:
					System.out.println("1：查询课程的代课老师\n");
					sa.selectBytea();
					break;
				case 2:
					System.out.println("2:查看选课情况");
					sa.dispScourse();
					break;
				case 3:
					System.out.println("3:排课");
					ca.dispAllCourse();
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

}
