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
@Table(name="user_to_role")
@NamedQuery(name="UserToRole.findAll", query="SELECT a FROM UserToRole a")
public class UserToRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8391448847806148329L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_to_role_id",insertable=false,updatable=false)
	private Long userToRoleId;
	
	@Column(name="erf_user_id")
	private Long userId;
	
	@Column(name="erf_user_role_id")
	private Long userRoleId;

	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_user_id" ,nullable = false, referencedColumnName = "user_id",insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_user_role_id" ,nullable = false, referencedColumnName = "user_role_id",insertable = false, updatable = false)
	private UserRole userRole;	
	
	@Override
	public String toString() {
		return "UserToRole [userToRoleId=" + userToRoleId + ", userId=" + userId + ", userRoleId=" + userRoleId + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

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
	
}
