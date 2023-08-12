package com.globlotech.wfm.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;




/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT a FROM User a")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id",insertable=false,updatable=false)
	private Long userId;
	
	@Column(name="erf_company_id")
	private String companyId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	 	
	@UpdateTimestamp
	@Column(name="updated_date") 
	private Date updatedDate;
	
	@CreationTimestamp
	@Column(name="created_date") 
	private Date createdDate;
	
	 @OneToMany(mappedBy="user", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	 @ElementCollection
	 private List<UserToRole> userToRoles = new ArrayList<UserToRole>();	
	
	 public void addUserToRoles(UserToRole userToRole) { 
		 userToRole.setUser(this); 
		 userToRoles.add(userToRole); 
	 }
	 public void removeUserToRoles(UserToRole userToRole) { 
		 userToRole.setUser(this); 
		 userToRoles.remove(userToRole); 
	 }

	/**
	 * @return
	 */
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "User \n[userId=" + userId + ", \ncompanyId=" + companyId + ", \nuserName=" + userName + ", \n firstName="
				+ firstName + ", \n lastName=" + lastName + ", \n password=" + password + ", \n emailId=" + emailId
				+ ", \n phoneNumber=" + phoneNumber + ", \n status=" + status + ", \n createdBy=" + createdBy + ", \n updatedBy="
				+ updatedBy + ", \n updatedDate=" + updatedDate + ", \n createdDate=" + createdDate + "]";
	}
	 
	}