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
@Table(name="role_to_screen_access")
@NamedQuery(name="RoleToScreenAccess.findAll", query="SELECT rs FROM RoleToScreenAccess rs")
public class RoleToScreenAccess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5859905571677215356L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_to_screen_access_id",insertable=false,updatable=false)
	private Long roleToScreenAccessId;

	@Column(name="erf_role_id")
	private Long erfRoleId;

	@Column(name="erf_screen_access_id")
	private Long erfScreenAccessId;

	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_role_id" ,nullable = false, referencedColumnName = "user_role_id",insertable = false, updatable = false)
	private UserRole userRoleToScreenAccess;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_screen_access_id" ,nullable = false, referencedColumnName = "screen_access_id",insertable = false, updatable = false)
	private ScreenAccess screenAccess;
	
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

	@Override
	public String toString() {
		return "RoleToScreenAccess [roleToScreenAccessId=" + roleToScreenAccessId + ", erfRoleId=" + erfRoleId
				+ ", erfScreenAccessId=" + erfScreenAccessId + "]";
	}
	
	public ScreenAccess getScreenAccess() {
		return screenAccess;
	}

	public void setScreenAccess(ScreenAccess screenAccess) {
		this.screenAccess = screenAccess;
	}

	public UserRole getUserRoleToScreenAccess() {
		return userRoleToScreenAccess;
	}

	public void setUserRoleToScreenAccess(UserRole userRoleToScreenAccess) {
		this.userRoleToScreenAccess = userRoleToScreenAccess;
	}
	
	

}
