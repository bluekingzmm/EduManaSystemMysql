/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public class Scoursse {

	private String stuName;
	private String stuNum;
	private String course_id;
	private String course_name;
	private String time;
	private String place;
	private int stucount;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getStucount() {
		return stucount;
	}
	public void setStucount(int stucount) {
		this.stucount = stucount;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Scoursse() {

	}

	public Scoursse(String course_name, String course_id, String stuNum, String stuName,String place,String time,int stucount) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.stuName = stuName;
		this.stuNum = stuNum;
		this.place=place;
		this.time=time;
		this.stucount=stucount;
	}

	public String toString() {
		return this.stuNum + "\t" + this.stuName + "\t" + this.course_id + "\t" + this.course_name+"\t"+this.place+"\t"+this.time+"\t"+this.stucount;
	}

}
