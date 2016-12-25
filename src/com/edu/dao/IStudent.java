/**
 * 
 */
package com.edu.dao;

import java.util.List;

import com.edu.dto.Student;

/**
 * @author Administrator
 *
 */
public interface IStudent {

	/*
	 * 管理员添加学生信息（boolean）判断是否添加
	 */
	public boolean addStudent(Student s) throws Exception;

	/*
	 * 管理员删除学生信息（boolean）判断是否删除
	 */
	public boolean deleteStudent(String num) throws Exception;

	/*
	 * 管理员 修改学生信息（boolean）判断是否修改学生信息
	 */
	public boolean modifyStudent(Student s) throws Exception;

	/*
	 * 显示学生列表 <list集合>
	 * 
	 */

	public List<Student> lispStudent() throws Exception;

	/*
	 * 查找学生 Student
	 */

	public Student findStudent(String num) throws Exception;

	/*
	 * 登录功能：需要输入学号和密码
	 */
	public Student loginStudent(String stuNum, String stuPassword) throws Exception;

	



	/*
	 * 根据关键字查询
	 * 模糊查询
	 */
	public List<Student> findStudent(int key,String keyname) throws Exception;


}
