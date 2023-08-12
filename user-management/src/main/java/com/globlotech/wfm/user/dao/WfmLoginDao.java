package com.globlotech.wfm.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globlotech.wfm.user.controller.WfmLoginController;
import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.repository.UserRepository;
import com.globlotech.wfm.user.repository.UserRoleRepository;
import com.globlotech.wfm.user.vo.LoginCredentialsVO;

/**
 * @author Manikandan
 *
 */
@Component
public class WfmLoginDao {
	
	private static final Logger log = LoggerFactory.getLogger(WfmLoginDao.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;

	/**
	 * @param attributeKey
	 * @return
	 */
	public User authenticateUser(LoginCredentialsVO loginCredentialsVO) 
	{
		//User user = new User();
		User validUser = new User();
		log.info( "*************WfmLoginDao*****authenticateUser*****Entry*******");
		try {
			validUser=userRepository.authenticateUser(loginCredentialsVO.getUserName() , loginCredentialsVO.getPassword());
			if(validUser != null ) {
				log.info("*************WfmLoginDao*****authenticateUser****users***"+validUser.toString());				
			}else {
				throw new WfmUserException("WfmLoginDao**authenticateUser***No Data found");
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmuserDao*****authenticateUser****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmuserDao**authenticateUser***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmuserDao*****authenticateUser*****Exit*******");
		return validUser;
	}

}
