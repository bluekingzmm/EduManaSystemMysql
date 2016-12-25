/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.ICourse;
import com.edu.dao.IScourse;
import com.edu.dao.IStudent;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.dao.impl.ScourseImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dto.Course;
import com.edu.dto.Scoursse;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

/**
 * @author 张明明
 * 功能：显示所有选课的学生，根据学生学号查询个人选课情况
 * 录入，修改选课信息，通过教师编号查询课程信息
 *
 */
public class ScourseAiist {

	static Scanner sc = new Scanner(System.in);
	static IScourse is = new ScourseImplMysql();
	static IStudent ss = new StudentImplMysql();
	static ICourse ic = new CourseImplMysql();
	
	/*
	 * 功能：学生选课
	 * 参数：num 学生学号
	 */

	public void addScourse(String num) throws Exception {
		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Student stu = ss.findStudent(num);
				if (stu != null) {
					System.out.println("请你输入你要选课的课程编号");
					String code=sc.next();
					Course course=ic.findByCode(code);
					if(course==null){
						System.out.println("课程号不存在");
					}
					stu.setCourse_id(code);	
					stu.setTea_id(stu.getTea_id());
				} else {
					System.out.println("学号不存在！");
				}
				if (is.modifyScourse(stu)) {
					System.out.println("选课成功");
				} else {
					System.out.println("选课失败");
			

				

			
				}
				System.out.println("输入n或者N则停止修改或则添加");
				yes = sc.next();
				}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：显示所有学生选课信息
	 * 
	 */

	public void dispScourse() throws Exception {
		List<Scoursse> sList = is.dispAllScourse();
		System.out.println("学生学号\t学生姓名\t课程编号\t课程名\t地点\t时间\t人数");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}

		
	}
	/*
	 * 功能：查询学生个人选课情况
	 * 参数：num 学生学号
	 */

	public void dispOneScourse(String num)throws Exception{
		Scoursse sc=is.dispAllScourse(num);
		if(sc!=null){
			System.out.println("学生学号\t学生姓名\t课程编号\t课程名\t地点\t时间\t人数");
		System.out.println(sc);
		}else{
			System.out.println("无！");
		}
		
		
		
	}
	/*
	 * 功能：查询该门课程教师
	 * 
	 */

	public void selectBytea() throws Exception {
		try {
			String yes = "y";
			while (!yes.startsWith("n")) {
				System.out.println("请输入课程编号");
				String course_id = sc.next();
				System.out.println("教师姓名\t教师编号");
				Course course = ic.findByCode(course_id);
				if (course != null) {
					Teacher tea = is.findScourseBytea(course_id);
					System.out.println(tea.getName() + "\t" + tea.getNum());

				}
				System.out.println("输入n或者N则停止查询，任意键继续");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
