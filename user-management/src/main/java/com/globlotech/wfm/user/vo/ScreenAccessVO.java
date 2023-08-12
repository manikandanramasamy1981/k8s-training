package com.globlotech.wfm.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScreenAccessVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3559137716049883125L;
	
	private Long screenAccessId;

	private Long screenId;
	
	private String screenAccess;
	
	private ScreenVO screen;
	
    private List<RoleToScreenAccessVO> roleToScreenAccesses = new ArrayList<RoleToScreenAccessVO>();

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

	public ScreenVO getScreen() {
		return screen;
	}

	public void setScreen(ScreenVO screen) {
		this.screen = screen;
	}

	public List<RoleToScreenAccessVO> getRoleToScreenAccesses() {
		return roleToScreenAccesses;
	}

	public void setRoleToScreenAccesses(List<RoleToScreenAccessVO> roleToScreenAccesses) {
		this.roleToScreenAccesses = roleToScreenAccesses;
	}

	@Override
	public String toString() {
		return "ScreenAccessVO [\nscreenAccessId=" + screenAccessId + ", \nscreenId=" + screenId + ", \nscreenAccess="
				+ screenAccess + ", \nscreen=" + screen + ", \nroleToScreenAccesses=" + roleToScreenAccesses + "]";
	}	

}
