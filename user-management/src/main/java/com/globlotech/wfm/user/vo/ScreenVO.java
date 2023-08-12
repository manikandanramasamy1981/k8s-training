package com.globlotech.wfm.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manikandan
 *
 */
public class ScreenVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6287535917169348321L;

	private Long screenId;

	
	private String screenName;
	
	
	private String screenDescription;
	
	
	private Long erfModuleId;
	
	
	private ModuleVO module;
	
	
	private List<ScreenAccessVO> screenAccesses = new ArrayList<ScreenAccessVO>();


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


	public ModuleVO getModule() {
		return module;
	}


	public void setModule(ModuleVO module) {
		this.module = module;
	}


	public List<ScreenAccessVO> getScreenAccesses() {
		return screenAccesses;
	}


	public void setScreenAccesses(List<ScreenAccessVO> screenAccesses) {
		this.screenAccesses = screenAccesses;
	}


	@Override
	public String toString() {
		return "ScreenVO [\nscreenId=" + screenId + ", \nscreenName=" + screenName + ",\n screenDescription="
				+ screenDescription + ", \nerfModuleId=" + erfModuleId + ",\n module=" + module + ", \nscreenAccesses="
				+ screenAccesses + "]";
	}

}
