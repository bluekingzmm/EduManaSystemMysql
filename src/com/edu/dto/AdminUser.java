/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public class AdminUser {

	private String userName;
	private String userPasswprd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswprd() {
		return userPasswprd;
	}

	public void setUserPasswprd(String userPasswprd) {
		this.userPasswprd = userPasswprd;
	}

	public AdminUser() {

	}

	public AdminUser(String userName, String userPassword) {
		this.userName = userName;
		this.userPasswprd = userPassword;

	}
	
}
