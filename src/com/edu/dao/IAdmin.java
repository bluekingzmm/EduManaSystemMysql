package com.edu.dao;

import java.util.List;

import com.edu.dto.AdminUser;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

public interface IAdmin {


	/*
	 * 管理员登录
	 */
	public AdminUser loginAdmin(String username,String userpassword ) throws Exception;

	/*
	 * 获取密码
	 */
	public Student getPassword(String stu_password) throws Exception;

	/*
	 * 修改个人信息
	 */

	public boolean modifyOwnStudent(Student s) throws Exception;

	/*
	 * 根据学生编号查询
	 */
	public List<StuScore> findByStudent(String num) throws Exception;
	
	
	
	public Course findTeacherByCode(String tea_id) throws Exception ;

	/*
	 * 查看本班学生信息
	 * 视图
	 */
	public List<StuScore> LispStudentInfo(String code) throws Exception;
	
	/*
	 *查看本班学生成绩
	 *视图 
	 */

	public List<StuScore> LispStudentScore(String code) throws Exception;
	
	/*
	 * 得到教师密码
	 */

	public Teacher getTeaPassword(String password) throws Exception;
	
	/*
	 * 修改个人信息
	 */

	public boolean modifyOneTeacher(Teacher tea) throws Exception;
	

}
