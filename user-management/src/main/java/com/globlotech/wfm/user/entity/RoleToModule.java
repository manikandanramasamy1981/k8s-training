package com.globlotech.wfm.user.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="role_to_module")
@NamedQuery(name="RoleToModule.findAll", query="SELECT rm FROM RoleToModule rm")
public class RoleToModule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8896000396698940425L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_to_module_id",insertable=false,updatable=false)
	private Long roleToModuleId;

	@Column(name="erf_role_id")
	private Long roleId;
	
	@Column(name="erf_module_id")
	private Long moduleId;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_role_id" ,nullable = false, referencedColumnName = "user_role_id",insertable = false, updatable = false)
	private UserRole userRoleToModule;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_module_id" ,nullable = false, referencedColumnName = "module_id",insertable = false, updatable = false)
	private Module module;
	
	
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

	@Override
	public String toString() {
		return "RoleToModule \n [roleToModuleId=" + roleToModuleId + ", \n roleId=" + roleId + ", \n moduleId=" + moduleId + "]";
	}

	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public UserRole getUserRoleToModule() {
		return userRoleToModule;
	}

	public void setUserRoleToModule(UserRole userRoleToModule) {
		this.userRoleToModule = userRoleToModule;
	}

}
