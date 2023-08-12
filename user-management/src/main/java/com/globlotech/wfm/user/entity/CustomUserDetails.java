package com.globlotech.wfm.user.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1177329084336294591L;
	
	private Long id;
	
	private String userName;
	
	private String password;	
	
	private String status;
	
	private List<GrantedAuthority> authorities;
	
	
	public CustomUserDetails(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.status = user.getStatus();
		this.id=user.getUserId();
		/*
		 * this.authorities = Arrays.stream(user.getRoles().split(",")
		 * .map(SimpleGrantedAuthority::new) .collect(Collectors.toList());
		 */ 
	}
	
	public CustomUserDetails() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
