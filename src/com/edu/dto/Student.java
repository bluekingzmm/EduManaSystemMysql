/**
 * 
 */
package com.edu.dto;

import java.sql.Date;

/**
 * @author Administrator
 *
 */
public class Student extends Person {
	private String stuId;
	private Date enterDate;
	private String stuPassword;
	private String department;
	private String course_id;
	private String tea_id;
	private String course_name;
	
	

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Student() {

	}

	public Student(String stuNum, String stuName, String stuSex, int age, String stuId, String stuPassword,
			String course_name,String tea_id, String deparemrnt, String course_id) {
		super(stuNum, stuName, stuSex, age);
		this.stuId = stuId;
		this.stuPassword = stuPassword;
		this.department = deparemrnt;
		this.course_id = course_id;
		this.tea_id=tea_id;
		this.course_name=course_name;

	}

	public String toString() {
		return super.toString() + "\t" + this.stuId + "\t" + this.enterDate + "\t" 
				+ this.department;

	}

}
