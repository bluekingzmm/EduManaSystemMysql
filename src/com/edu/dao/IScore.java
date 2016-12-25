package com.edu.dao;

import java.util.List;

import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;

public interface IScore {

	/*
	 * 添加成绩
	 */

	public boolean addScore(StuScore s) throws Exception;

	/*
	 * 删除成绩
	 */

	public boolean delectScore(StuScore s) throws Exception;

	/*
	 * 删除学生所有成绩
	 */

	public boolean delectByStudent(Student s) throws Exception;

	/*
	 * 删除某课程所有成绩
	 */

	public boolean delectByCourse(Course c) throws Exception;

	/*
	 * 通过学生查找成绩
	 * 视图
	 */

	public List<StuScore> findByStudent(Student s) throws Exception;

	/*
	 * 通过课程查找成绩
	 * 视图
	 */

	public List<StuScore> findByCourse(Course c) throws Exception;

	/*
	 * 修改成绩
	 */

	public boolean modifyScore(StuScore s) throws Exception;
	
	/*
	 * 得到学生学号和课程编号
	 */

	public StuScore get(Student s, Course c) throws Exception;
	
	/*
	 * 显示所有学生成绩
	 * 视图
	 */

	public List<StuScore> LispStudentScore() throws Exception;

	/*
	 * 根据教师编号查看成绩和学生课程信息
	 */
	
	public List<StuScore> lisp(String code) throws Exception;

	/*
	 * 根据课程编号进行查看成绩
	 */
	public StuScore findByCourseLookExam(Course c) throws Exception;

}
