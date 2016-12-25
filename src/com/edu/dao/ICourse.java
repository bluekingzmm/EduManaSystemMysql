/**
 * 
 */
package com.edu.dao;

import java.util.List;

import com.edu.dto.Course;

/**
 * @author Administrator
 *
 */
public interface ICourse {


	/*
	 * 增加课程
	 */
	public boolean AddCourse(Course c) throws Exception;
	
	/*
	 * 删除课程
	 */
	
	public boolean DelectCourse(String code) throws Exception;
	
	/*
	 * 修改课程
	 */
	
	
	public boolean ModifyCourse(Course c) throws Exception;
	

	
	/*
	 *按照课程编号来查看课程 
	 */

	public Course findByCode(String code) throws Exception;
	

	
	
	
//	public List<Course> dispListCourse(Course s) throws Exception ;
	
	/*
	 * 显示所有课程信息
	 */
	public List<Course> dispListCourse() throws Exception;
	


}
