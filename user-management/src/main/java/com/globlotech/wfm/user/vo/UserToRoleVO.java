package com.globlotech.wfm.user.vo;

import java.io.Serializable;

/**
 * @author Manikandan
 *
 */
public class UserToRoleVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967555641097172853L;
	
    private Long userToRoleId;

    private Long userId;
	
	private Long userRoleId;

	private UserVO user;
	
	private UserRoleVO userRole;

	public Long getUserToRoleId() {
		return userToRoleId;
	}

	public void setUserToRoleId(Long userToRoleId) {
		this.userToRoleId = userToRoleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public UserRoleVO getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleVO userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserToRoleVO [\n userToRoleId=" + userToRoleId + ", \n userId=" + userId + ", \n userRoleId=" + userRoleId
				+ ", \n user=" + user + ", \n userRole=" + userRole + "]";
	}

	}
