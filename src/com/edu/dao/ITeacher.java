package com.edu.dao;

import java.util.List;

import com.edu.dto.Teacher;

public interface ITeacher {

	/*
	 * 添加教师信息
	 */
	public boolean addTeacher(Teacher tea) throws Exception;

	/*
	 * 删除教师信息 根据教师编号进行删除
	 */

	public boolean deleteTeacher(String code) throws Exception;

	/*
	 * 修改教师信息
	 */

	public boolean modifyTeacher(Teacher tea) throws Exception;

	/*
	 * 查找教师信息
	 */

	public Teacher findTeacher(String code) throws Exception;

	/*
	 * 显示教师所有信息
	 */

	public List<Teacher> dispAllTeacher() throws Exception;

	/*
	 * 通过工资进行排序
	 */
	public List<Teacher> sortTeacher() throws Exception;

	/*
	 * 教师登录（需要教师编号和密码）
	 */
	public Teacher loginTeacher(String code, String teaPassword) throws Exception;

	
	
	
}
