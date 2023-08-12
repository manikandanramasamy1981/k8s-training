package com.globlotech.wfm.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Manikandan
 *
 */
public class UserVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5263222997814492884L;
	
	private Long userId;
	
	private String companyId;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String status;
	
	private String createdBy;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private Date createdDate;
	
	 private List<UserToRoleVO> userToRoles = new ArrayList<UserToRoleVO>();

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

	public List<UserToRoleVO> getUserToRoles() {
		return userToRoles;
	}

	public void setUserToRoles(List<UserToRoleVO> userToRoles) {
		this.userToRoles = userToRoles;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", companyId=" + companyId + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password=" + password + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", status=" + status + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate + ", userToRoles="
				+ userToRoles + "]";
	}	
		
}
