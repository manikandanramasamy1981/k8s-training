package com.globlotech.wfm.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.globlotech.wfm.user.dao.WfmLoginDao;
import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.security.PasswordEncDecryptManager;
import com.globlotech.wfm.user.vo.LoginCredentialsVO;
import com.globlotech.wfm.user.vo.UserVO;

/**
 * @author Manikandan
 *
 */
@Service
public class WfmLoginService {
	
	private static final Logger log = LoggerFactory.getLogger(WfmLoginService.class);
	
	@Autowired
	WfmLoginDao wfmLoginDao;
	
	@Autowired
	PasswordEncDecryptManager passwordEncDecryptManager;
	
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public User authenticateUser(LoginCredentialsVO loginCredentialsVO) {
		log.info( "*************WfmLoginService*****authenticateUser*************Entry******");
		log.info( "*************WfmLoginService*****authenticateUser********userName******"+loginCredentialsVO.getUserName()
		                                  +"**password****"+loginCredentialsVO.getPassword());
		//populate Entities
		User user = new User();
		boolean isCredentialsValid = false;

		try {
			user = wfmLoginDao.authenticateUser(loginCredentialsVO);
			//userVO = populateUserVO(user);
			if(user !=null) {
				isCredentialsValid = true;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmLoginService*****authenticateUser*********Error*******************Exit") ;
			throw new WfmUserException("Exception in authenticateUser " + ex.getMessage());
		}
		log.info( "*************WfmLoginService*****authenticateUser*****isCredentialsValid***"+isCredentialsValid);
		log.info( "*************WfmLoginService*****authenticateUser*******Exit");
		return user;
	}
	
	/**
	 * @param populateuserRequestVO
	 * @return
	 */
	public UserVO populateUserVO(User user) {
		log.info( "*************WfmUserService*****populateUserVO******Entry****");
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(user,userVO);
		userVO.setPassword(passwordEncDecryptManager.decrypt(user.getPassword()));
		log.info( "*************WfmUserService*****populateUserVO******Exit****");
		return userVO;
	}


}
