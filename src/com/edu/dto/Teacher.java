/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public class Teacher extends Person {

	
	private String course_id;
	private String tea_tel;
	private String tea_password;
	private String memo;
	private String write;
	
	

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	

	public String getTea_password() {
		return tea_password;
	}

	public void setTea_password(String tea_password) {
		this.tea_password = tea_password;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	

	

	public String getTea_tel() {
		return tea_tel;
	}

	public void setTea_tel(String tea_tel) {
		this.tea_tel = tea_tel;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Teacher() {

	}

	public Teacher(String tea_id, String tea_name, String sex, int age,  String course_id,
			String tea_tel, String tea_password,String memo,String write) {
		super(tea_id,tea_name,sex,age);
		this.course_id = course_id;
		
		
		
		this.tea_tel = tea_tel;
		this.memo = memo;
		this.tea_password=tea_password;
		this.write=write;
	}

	public String toString() {
		return super.toString() +  "\t\t"
				+ this.course_id + "\t" + this.tea_tel + "\t" + this.memo;
	}

}
