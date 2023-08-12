package com.globlotech.wfm.user.vo;

import java.io.Serializable;

/**
 * @author Manikandan
 *
 */
public class RoleToScreenAccessVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2499061983433308590L;

	private Long roleToScreenAccessId;

	
	private Long erfRoleId;

	
	private Long erfScreenAccessId;

	
	private UserRoleVO userRoleToScreenAccess;
	
	
	private ScreenAccessVO screenAccess;


	public Long getRoleToScreenAccessId() {
		return roleToScreenAccessId;
	}


	public void setRoleToScreenAccessId(Long roleToScreenAccessId) {
		this.roleToScreenAccessId = roleToScreenAccessId;
	}


	public Long getErfRoleId() {
		return erfRoleId;
	}


	public void setErfRoleId(Long erfRoleId) {
		this.erfRoleId = erfRoleId;
	}


	public Long getErfScreenAccessId() {
		return erfScreenAccessId;
	}


	public void setErfScreenAccessId(Long erfScreenAccessId) {
		this.erfScreenAccessId = erfScreenAccessId;
	}


	public UserRoleVO getUserRoleToScreenAccess() {
		return userRoleToScreenAccess;
	}


	public void setUserRoleToScreenAccess(UserRoleVO userRoleToScreenAccess) {
		this.userRoleToScreenAccess = userRoleToScreenAccess;
	}


	public ScreenAccessVO getScreenAccess() {
		return screenAccess;
	}


	public void setScreenAccess(ScreenAccessVO screenAccess) {
		this.screenAccess = screenAccess;
	}


	@Override
	public String toString() {
		return "RoleToScreenAccessVO [\nroleToScreenAccessId=" + roleToScreenAccessId + ", \nerfRoleId=" + erfRoleId
				+ ", \nerfScreenAccessId=" + erfScreenAccessId + ", \nuserRoleToScreenAccess=" + userRoleToScreenAccess
				+ ", \nscreenAccess=" + screenAccess + "]";
	}

}
