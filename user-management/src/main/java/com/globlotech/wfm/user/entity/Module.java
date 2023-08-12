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
 * @author Manikandan
 *
 */
@Entity
@Table(name="module")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6677645714368503724L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="module_id",insertable=false,updatable=false)
	private Long moduleId;

	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="module_description")
	private String moduleDescription;
	
	@Column(name="erf_product_id")
	private Long erfProductId;
	
	@OneToMany(mappedBy="module", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@ElementCollection
	private List<Screen> screens = new ArrayList<Screen>();
	
	@OneToMany(mappedBy="userRoleToModule", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	 @ElementCollection
	 private List<RoleToModule> roleToModules = new ArrayList<RoleToModule>();
	 
	public void addScreens(Screen screen) {
		screen.setModule(this);
		screens.add(screen);
	}
	public void removeScreens(Screen screen) {
		screen.setModule(this);
		screens.remove(screen);
	}
	
	 public void addRoleToModules(RoleToModule roleToModule) { 
		 roleToModule.setModule(this); 
		 roleToModules.add(roleToModule); 
	 }
	 public void removeRoleToModules(RoleToModule roleToModule) { 
		 roleToModule.setModule(this); 
		 roleToModules.remove(roleToModule); 
	 }

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public Long getErfProductId() {
		return erfProductId;
	}

	public void setErfProductId(Long erfProductId) {
		this.erfProductId = erfProductId;
	}

	@Override
	public String toString() {
		return "Module \n[moduleId=" + moduleId + ", \nmoduleName=" + moduleName + ", \n moduleDescription="
				+ moduleDescription + ", \n erfProductId=" + erfProductId + "]";
	}
	
}
