/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IAdmin;
import com.edu.dao.ICourse;
import com.edu.dao.IScore;
import com.edu.dao.IStudent;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AdminMysqlImpl;
import com.edu.dao.impl.CourseImplMysql;
import com.edu.dao.impl.ScoreImplMysql;
import com.edu.dao.impl.StudentImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;

/**
 * @author 张明明
 * 功能： 添加，删除，修改，显示成绩，按照学生编号删除成绩，按照课程编号删除成绩，
 * 按照学生编号查询成绩，按照课程编号查询成绩，get得到学生和课程，
 * 按照课程编号查看本课程成绩的总分和平均分，按照分数排序的课程编号
 *
 */
public class StuScoreAiist {
	static Scanner sc = new Scanner(System.in);
	IStudent student = new StudentImplMysql();
	ITeacher teacher =new TeacherImplMysql();
	ICourse course = new CourseImplMysql();
	IScore score = new ScoreImplMysql();
	IAdmin admin=new AdminMysqlImpl();

	
	/*
	 * 功能：按照课程编号查看本课程成绩的总分和平均分
	 */
	public void findCourseScoreLookExam() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号：");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c == null) {
					System.out.println("没有为：" + code + "的课程！！");
					return;
				}

				List<StuScore> sList = score.findByCourse(c);
				StuScore ss = score.findByCourseLookExam(c);
				double total = 0;
				for (int j = 0; j < sList.size(); j++) {
					if (ss != null) {
						StuScore e = sList.get(j);
						total += e.getScore();
					} else {
						System.out.println("空");
					}
				}

				System.out.println("课程号：\t" + ss.getCourse().getCourse_id() + "\t课程名:\t" + ss.getCourse().getCourse_name() + "\t总分\t" + total
						+ "\t平均分\t" + total / sList.size());

				System.out.println("输入n或者N则退出查询，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	/*
	 * 功能：按照课程编号进行排序
	 */
	public void disp() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要按照分数排序的课程编号");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c != null) {
					score.lisp(code);
				} else {
					System.out.println("你输入的课程编号不存在！！");
				}
				System.out.println("还要继续排序吗，不需要请输入n或者N，任意键继续");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
/*
 * 功能：增加学生成绩
 * 需要找到该同学学号和课程编号
 * 需要添加代课老师，成绩
 */

	public void addStuScore(String tea_id) throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu == null) {
					System.out.println("学号不存在！");
				}
				Course code = admin .findTeacherByCode(tea_id);		
//				Course c = course.findByCode(code);
				if (code == null) {
					System.out.println("课程编号不存在！");
				}
				System.out.println("请输入成绩");
				double exam = sc.nextDouble();
//				System.out.println("请填入代课老师");
//				String tea_id = sc.next();
				StuScore ss = new StuScore(stu, code, exam, tea_id);
				if (score.addScore(ss)) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失败");
				}
				System.out.println("输入n或者N则停止添加，任意键继续");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：删除分数
	 * 指定删除（学生学号和教师编号）
	 */
	public void deleteScore() throws Exception {
		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				String code = sc.next();
				Course c = course.findByCode(code);
				System.out.println("请输入学生学号");
				String num = sc.next();
				Student s = student.findStudent(num);
				StuScore ss = score.get(s, c);
				if (ss == null) {
					System.out.println("没有课程编号为" + code + "和" + num + "的信息");
					return;
				}
				if (score.delectScore(ss)) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！！");
				}
				System.out.println("输入n或者N则退出删除，任意键继续");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("异常说明：");
			System.out.println(e.toString());
		}
	}

	/*
	 * 功能：按照学生学号删除成绩
	 */
	public void deleteScoreByStu() throws Exception {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号：");
				String num = sc.next();
				Student s = student.findStudent(num);
				if (s == null) {
					System.out.println("输入的学号不存在！！");
				}
				if (score.delectByStudent(s)) {
					System.out.println("删除成功！！");
				} else {
					System.out.println("删除失败！！");
				}

				System.out.println("输`入n或者N继续删除，任意键继续！！");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	/*
	 * 按照课程编号删除课程
	 */
	public void deleteScoreByCourse() throws Exception {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号：");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (course == null) {
					System.out.println("输入的学号不存在！！");
				}
				if (score.delectByCourse(c)) {
					System.out.println("删除成功！！");
				} else {
					System.out.println("删除失败！！");
				}

				System.out.println("输入n或者N继续删除，任意键继续！！");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	/*
	 * 功能：按照学生学号查找成绩
	 * 用到视图VScore1
	 */
	public void findScoreByStu() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号：");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu == null) {
					System.out.println("没有学号为：" + num + "的学生！！");
					return;
				}
				List<StuScore> sList = score.findByStudent(stu);

				for (int i = 0; i < sList.size(); i++) {
					StuScore exam = sList.get(i);
					System.out.println("学号：\t" + exam.getStu().getNum() + "\t姓名:\t" + exam.getStu().getName() + "\t课程名\t"
							+ exam.getCourse().getCourse_name() + "\t分数：\t" + exam.getScore());
				}
				System.out.println("输入n或者N则退出查询，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	
	/*
	 * 功能：显示全部成绩
	 * 输出总分和平均分
	 */
	public void ListAllScore() throws Exception {
		try {
			List<Student> sList = student.lispStudent();
			List<Course> cList = course.dispListCourse();
			System.out.println("课程编号\t学生学号\t学生姓名\t教师编号\t成绩");
			for (int i = 0; i < sList.size(); i++) {
				Student stu = sList.get(i);

				double total = 0;
				for (int j = 0; j < cList.size(); j++) {
					Course course = cList.get(j);
					StuScore ss = score.get(stu, course);
					if (ss != null) {
						total += ss.getScore();
						System.out.println(ss);
					} else {
						System.out.print("\n");
					}
				}
				System.out.println("总分：" + total + "\t" + "平均分" + total / cList.size());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 功能：按照课程编号查询成绩
	 * 视图VScore1
	 * 
	 */
	public void findScoreByCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号：");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c == null) {
					System.out.println("没有为：" + code + "的课程！！");
					return;
				}
				List<StuScore> sList = score.findByCourse(c);

				for (int i = 0; i < sList.size(); i++) {
					StuScore exam = sList.get(i);
					System.out.println("姓名\t" + exam.getStu().getName() + "\t" + "课程号：\t" + exam.getCourse().getCourse_id() + "\t课程名:\t"
							+ exam.getCourse().getCourse_name() + "\t分数：\t" + exam.getScore());
				}
				System.out.println("输入n或者N则退出查询，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	/*
	 * 功能：修改成绩
	 * 需要输入课程编号和学生编号进行匹配成绩是否存在，再进行修改
	 * 修改成绩和代课老师
	 */
	public void modifyStuScore() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("请你输入添加成绩的课程编号");
				String code = sc.next();
				Course c = course.findByCode(code);
				if (c == null) {
					System.out.println("你输入的课程编号不存在！！");
					return;
				}
				System.out.println("请输入要修改的学生学号");
				String num = sc.next();
				Student stu = student.findStudent(num);
				if (stu == null) {
					System.out.println("没有学号为" + num + "的学生");
					return;
				}
				StuScore ss = score.get(stu, c);
				if (ss == null) {
					System.out.println("没有学号为" + num + "的学生和" + code + "的课程编号，请重试！");
					return;
				}
				System.out.println("请进行选择 1：修改成绩 2： 修改代课老师");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("原来的成绩为" + ss.getScore() + "分");
					System.out.println("请输入新的成绩");
					ss.setScore(sc.nextDouble());
					break;
				case 2:
					System.out.println("请输入代课老师编号");
					ss.setTea_id(sc.next());
					break;
				default:
					break;
				}

				if (score.modifyScore(ss)) {
					System.out.println("修改成功！");
				} else {
					System.out.println("修改失败！");
				}
				System.out.println("输入n或者N则退出删除，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
