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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="screen_access")
@NamedQuery(name="ScreenAccess.findAll", query="SELECT m FROM ScreenAccess m")
public class ScreenAccess implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2791850381451191292L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="screen_access_id",insertable=false,updatable=false)
	private Long screenAccessId;

	@Column(name="erf_screen_id")
	private Long screenId;
	
	@Column(name="access")
	private String screenAccess;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_screen_id" ,nullable = false, referencedColumnName = "screen_id",insertable = false, updatable = false)
	private Screen screen;
	
	@OneToMany(mappedBy="screenAccess", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	 @ElementCollection
	 private List<RoleToScreenAccess> roleToScreenAccesses = new ArrayList<RoleToScreenAccess>();	
	
	 public void addUserRoleToScreenAccesses(RoleToScreenAccess userRoleToScreenAccess) { 
		 userRoleToScreenAccess.setScreenAccess(this); 
		 roleToScreenAccesses.add(userRoleToScreenAccess); 
	 }
	 public void removeUserRoleToScreenAccesses(RoleToScreenAccess userRoleToScreenAccess) { 
		 userRoleToScreenAccess.setScreenAccess(this); 
		 roleToScreenAccesses.remove(userRoleToScreenAccess);  
	 }


	public Long getScreenAccessId() {
		return screenAccessId;
	}

	public void setScreenAccessId(Long screenAccessId) {
		this.screenAccessId = screenAccessId;
	}

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public String getScreenAccess() {
		return screenAccess;
	}

	public void setScreenAccess(String screenAccess) {
		this.screenAccess = screenAccess;
	}

	@Override
	public String toString() {
		return "ScreenAccess \n[screenAccessId=" + screenAccessId + ", \nscreenId=" + screenId + ", \nscreenAccess="
				+ screenAccess + "]";
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}


}
