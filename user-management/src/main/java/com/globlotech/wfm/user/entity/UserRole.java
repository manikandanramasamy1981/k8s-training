package com.globlotech.wfm.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT a FROM UserRole a")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2700603023788283579L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id",insertable=false,updatable=false)
	private Long userRoleId;
	
	@Column(name="user_role_name")
	private String userRoleName;
	
	@Column(name="user_role_description")
	private String userRoleDescription;
	
	@Column(name="erf_product_id")
	private Long erfProductId;
	
	 @OneToMany(mappedBy="userRole", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	 @ElementCollection
	 private List<UserToRole> userToRoles = new ArrayList<UserToRole>();	
	
	 @OneToMany(mappedBy="userRoleToModule", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	 @ElementCollection
	 private List<RoleToModule> roleToModules = new ArrayList<RoleToModule>();
	 
	 @OneToMany(mappedBy="userRoleToScreenAccess", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	 @ElementCollection
	 private List<RoleToScreenAccess> roleToScreenAccesses = new ArrayList<RoleToScreenAccess>();
	 
	 
	 public void addUserToRoles(UserToRole userToRole) { 
		 userToRole.setUserRole(this); 
		 userToRoles.add(userToRole); 
	 }
	 public void removeUserToRoles(UserToRole userToRole) { 
		 userToRole.setUserRole(this); 
		 userToRoles.remove(userToRole); 
	 }
	 
	 public void addRoleToModules(RoleToModule roleToModule) { 
		 roleToModule.setUserRoleToModule(this); 
		 roleToModules.add(roleToModule); 
	 }
	 public void removeRoleToModules(RoleToModule roleToModule) { 
		 roleToModule.setUserRoleToModule(this); 
		 roleToModules.remove(roleToModule); 
	 }


	 public void addUserRoleToScreenAccesses(RoleToScreenAccess roleToScreenAccess) { 
		 roleToScreenAccess.setUserRoleToScreenAccess(this); 
		 roleToScreenAccesses.add(roleToScreenAccess); 
	 }
	 public void removeUserRoleToScreenAccesses(RoleToScreenAccess roleToScreenAccess) { 
		 roleToScreenAccess.setUserRoleToScreenAccess(this); 
		 roleToScreenAccesses.remove(roleToScreenAccess); 
	 }

	 

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

	@Override
	public String toString() {
		return "UserRole \n[userRoleId=" + userRoleId + ", \nuserRoleName=" + userRoleName + ", \n userRoleDescription="
				+ userRoleDescription + ", \n erfProductId=" + erfProductId + "]";
	}
	

}
