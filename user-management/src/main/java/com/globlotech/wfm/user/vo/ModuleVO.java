package com.globlotech.wfm.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manikandan
 *
 */
public class ModuleVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -422236455792511691L;
	
	private Long moduleId;

	
	private String moduleName;
	
	
	private String moduleDescription;
	
	
	private Long erfProductId;
	
	
	private List<ScreenVO> screens = new ArrayList<ScreenVO>();
	
	
    private List<RoleToModuleVO> roleToModules = new ArrayList<RoleToModuleVO>();


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


	public List<ScreenVO> getScreens() {
		return screens;
	}


	public void setScreens(List<ScreenVO> screens) {
		this.screens = screens;
	}


	public List<RoleToModuleVO> getRoleToModules() {
		return roleToModules;
	}


	public void setRoleToModules(List<RoleToModuleVO> roleToModules) {
		this.roleToModules = roleToModules;
	}


	@Override
	public String toString() {
		return "ModuleVO [\nmoduleId=" + moduleId + ", \nmoduleName=" + moduleName + ",\n moduleDescription="
				+ moduleDescription + ",\n erfProductId=" + erfProductId + ", \nscreens=" + screens + ",\n roleToModules="
				+ roleToModules + "]";
	}
	 
	/*
	 * public void addScreens(Screen screen) { screen.setModule(this);
	 * screens.add(screen); } public void removeScreens(Screen screen) {
	 * screen.setModule(this); screens.remove(screen); }
	 * 
	 * public void addRoleToModules(RoleToModule roleToModule) {
	 * roleToModule.setModule(this); roleToModules.add(roleToModule); } public void
	 * removeRoleToModules(RoleToModule roleToModule) {
	 * roleToModule.setModule(this); roleToModules.remove(roleToModule); }
	 */

}
