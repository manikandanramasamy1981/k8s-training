package com.globlotech.wfm.user.vo;

import java.io.Serializable;

public class AuthenticationResponseVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1177411489687266126L;
	private String jwt;
	private String refreshToken;
	private String userName;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
