package com.globlotech.wfm.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manikandan
 *
 */
public class UserRoleVO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6853574491886031284L;

    private Long userRoleId;
	
	private String userRoleName;
	
	private String userRoleDescription;
	
	private Long erfProductId;
	
    private List<UserToRoleVO> userToRoles = new ArrayList<UserToRoleVO>();	
	
	private List<RoleToModuleVO> roleToModules = new ArrayList<RoleToModuleVO>();
	 
	private List<RoleToScreenAccessVO> roleToScreenAccesses = new ArrayList<RoleToScreenAccessVO>();

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getUserRoleDescription() {
		return userRoleDescription;
	}

	public void setUserRoleDescription(String userRoleDescription) {
		this.userRoleDescription = userRoleDescription;
	}

	public Long getErfProductId() {
		return erfProductId;
	}

	public void setErfProductId(Long erfProductId) {
		this.erfProductId = erfProductId;
	}

	public List<UserToRoleVO> getUserToRoles() {
		return userToRoles;
	}

	public void setUserToRoles(List<UserToRoleVO> userToRoles) {
		this.userToRoles = userToRoles;
	}

	public List<RoleToModuleVO> getRoleToModules() {
		return roleToModules;
	}

	public void setRoleToModules(List<RoleToModuleVO> roleToModules) {
		this.roleToModules = roleToModules;
	}

	public List<RoleToScreenAccessVO> getRoleToScreenAccesses() {
		return roleToScreenAccesses;
	}

	public void setRoleToScreenAccesses(List<RoleToScreenAccessVO> roleToScreenAccesses) {
		this.roleToScreenAccesses = roleToScreenAccesses;
	}

	@Override
	public String toString() {
		return "UserRoleVO [\nuserRoleId=" + userRoleId + ", \nuserRoleName=" + userRoleName + ",\n userRoleDescription="
				+ userRoleDescription + ",\n erfProductId=" + erfProductId + ", \nuserToRoles=" + userToRoles
				+ ", \nroleToModules=" + roleToModules + ", \nroleToScreenAccesses=" + roleToScreenAccesses + "]";
	}
	 
	
}
