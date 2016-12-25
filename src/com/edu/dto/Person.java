/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public abstract class Person {

	private String num;
	private String name;
	private String sex;
	private int age;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Person(){
		
	}

	public Person(String num,String name,String sex,int age){
		this.num=num;
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	public String toString(){
		return this.num+"\t"+this.name+"\t"+this.sex+"\t"+this.age;
	}
}
