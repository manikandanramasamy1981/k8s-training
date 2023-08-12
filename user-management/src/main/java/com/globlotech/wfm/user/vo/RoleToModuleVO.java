package com.globlotech.wfm.user.vo;

import java.io.Serializable;

/**
 * @author Manikandan
 *
 */
public class RoleToModuleVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5644018440489248171L;

	private Long roleToModuleId;

	private Long roleId;

	private Long moduleId;
	
	private UserRoleVO userRoleToModule;
	
	private ModuleVO module;

	public Long getRoleToModuleId() {
		return roleToModuleId;
	}

	public void setRoleToModuleId(Long roleToModuleId) {
		this.roleToModuleId = roleToModuleId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public UserRoleVO getUserRoleToModule() {
		return userRoleToModule;
	}

	public void setUserRoleToModule(UserRoleVO userRoleToModule) {
		this.userRoleToModule = userRoleToModule;
	}

	public ModuleVO getModule() {
		return module;
	}

	public void setModule(ModuleVO module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "RoleToModuleVO [roleToModuleId=" + roleToModuleId + ", roleId=" + roleId + ", moduleId=" + moduleId
				+ ", userRoleToModule=" + userRoleToModule + ", module=" + module + "]";
	}
	
}
