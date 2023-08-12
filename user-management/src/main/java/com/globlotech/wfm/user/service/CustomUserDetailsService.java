package com.globlotech.wfm.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.globlotech.wfm.user.entity.CustomUserDetails;
import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub		
		User user = userRepository.findByUserName(username);
		
		return new CustomUserDetails(user);
	}

}
