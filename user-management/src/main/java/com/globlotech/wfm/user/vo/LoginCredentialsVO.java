package com.globlotech.wfm.user.vo;

import java.io.Serializable;

public class LoginCredentialsVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6273727857479152704L;

	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
