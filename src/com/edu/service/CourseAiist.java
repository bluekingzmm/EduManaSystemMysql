/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.ICourse;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.db.DataBase;
import com.edu.dto.Course;

/**
 * @author 王浩
 * 功能：录入，删除，修改，查询，显示课程信息
 *
 */
public class CourseAiist extends DataBase {

	Scanner sc = new Scanner(System.in);
	ICourse course = new CourseImplMysql();

	/*
	 * 增加课程信息 并给出录入情况
	 */
	public void AddCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Course c = new Course();
				System.out.println("请输入课程编号");
				c.setCourse_id(sc.next());
				System.out.println("请输入课程名称");
				c.setCourse_name(sc.next());
				System.out.println("请输入上课地点");
				c.setPlace(sc.next());
				System.out.println("请输入时间（课时）");
				c.setTime(sc.next() + "课时");
				System.out.println("请输入学生人数");
				c.setStucount(sc.nextInt());
				if (course.AddCourse(c)) {
					System.out.println("录入成功！！");
//					course.dispListCourse(c);
				} else {
					System.out.println("录入失败！！！");
				}
				System.out.println("输入n或者N则退出录入，任意键继续!");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	/*
	 * 功能：根据课程编号删除课程 并给出删除情况
	 */

	public void DelectCourse() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				String code = sc.next();
				Course c = course.findByCode(code);
				// course.dispListCourse(c);
				System.out.println("课程编号\t课程名\t上课地点\t课时\t学生人数");
				System.out.println(c);
				if (course.DelectCourse(code)) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败！");
				}
				System.out.println("输入n或者N则退出录入，任意键继续!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	/*
	 * 功能：显示所有的课程信息，根据dispListCourse （for）方法，输出查询的内容
	 */
	public List<Course> dispAllCourse() throws Exception {
		System.out.println("课程编号\t课程名\t上课地点\t课时\t学生人数");
		List<Course> sList = course.dispListCourse();
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		return sList;
	}
	/*
	 * 功能：修改课程（课程编号） 提示修改的情况
	 */

	public void ModifyCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				String code = sc.next();
				Course c = course.findByCode(code);
				// course.dispListCourse(c);
				System.out.println("课程编号\t课程名\t上课地点\t课时\t学生人数");
				System.out.println(c);
				if (c != null) {
					System.out.println("1：请修改课程名称");
					System.out.println("2：请修改上课地点");
					System.out.println("3：请输入课时");
					System.out.println("4：请输入学生人数");
					System.out.println("请选择");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1：请修改课程名称");
						c.setCourse_name(sc.next());
						break;
					case 2:
						System.out.println("2：请修改上课地点");
						c.setPlace(sc.next());
						break;
					case 3:
						System.out.println("3：请输入课时");
						c.setTime(sc.next()+ "课时");
						break;
					case 4:
						System.out.println("4：请输入学生人数");
						c.setStucount(sc.nextInt());
						break;

					default:
						break;
					}

				} else {
					System.out.println("没有课程编号为" + code + "的课程");
				}
				if (course.ModifyCourse(c)) {
					System.out.println("修改成功！");
					// course.dispListCourse(c);
				} else {
					System.out.println("修改失败！");
				}
				System.out.println("输入n或者N退出修改，任意键继续！");
				yes = sc.next();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	/*
	 * 功能：根据课程编号进行查询
	 */

	public void findByCode() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c != null) {
					System.out.println("课程编号\t课程名\t上课地点\t课时\t学生人数");
					System.out.println(c);
				} else {
					System.out.println("没有编号为" + code + "的课程！！");
				}
				System.out.println("输入n或者N则退出查找，任意键继续!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明;");
			e.printStackTrace();
		}

	}

}
