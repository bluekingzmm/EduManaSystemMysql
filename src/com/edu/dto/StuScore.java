/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public class StuScore {
	private Student stu;
	private Course course;
	private String tea_id;
	private Teacher tea;
	private double score;

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public StuScore() {

	}

	public StuScore(Student stu, Course course, double score, String tea_id) {

		this.stu = stu;
		this.course=course;
		this.score = score;
		this.tea_id = tea_id;
	}

//	public StuScore(Student stu, Course course, double score, Teacher tea) {
//
//		this.stu = stu;
//		this.course = course;
//		this.score = score;
//		this.tea = tea;
//	}

	public String toString() {
		return this.course.getCourse_id() + "\t" + this.stu.getNum() + "\t" + this.stu.getName() + "\t" + this.tea.getNum()
				+ "\t" + this.score;
	}

}
