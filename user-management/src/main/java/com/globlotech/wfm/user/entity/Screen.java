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
@Table(name="screen")
@NamedQuery(name="Screen.findAll", query="SELECT m FROM Screen m")
public class Screen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6658729053549149793L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="screen_id",insertable=false,updatable=false)
	private Long screenId;

	@Column(name="screen_name")
	private String screenName;
	
	@Column(name="screen_description")
	private String screenDescription;
	
	@Column(name="erf_module_id")
	private Long erfModuleId;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false ,cascade={CascadeType.ALL})
	@JoinColumn(name="erf_module_id" ,nullable = false, referencedColumnName = "module_id",insertable = false, updatable = false)
	private Module module;
	
	@OneToMany(mappedBy="screen", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@ElementCollection
	private List<ScreenAccess> screenAccesses = new ArrayList<ScreenAccess>();
	
	public void addScreenAccesses(ScreenAccess screenAccess) {
		screenAccess.setScreen(this);
		screenAccesses.add(screenAccess);
	}
	public void removeScreenAccesses(ScreenAccess screenAccess) {
		screenAccess.setScreen(this);
		screenAccesses.remove(screenAccess);
	}

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenDescription() {
		return screenDescription;
	}

	public void setScreenDescription(String screenDescription) {
		this.screenDescription = screenDescription;
	}

	public Long getErfModuleId() {
		return erfModuleId;
	}

	public void setErfModuleId(Long erfModuleId) {
		this.erfModuleId = erfModuleId;
	}

	@Override
	public String toString() {
		return "Screen \n[screenId=" + screenId + ",\n screenName=" + screenName + ",\n screenDescription="
				+ screenDescription + ",\n erfModuleId=" + erfModuleId + "]";
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}


}
