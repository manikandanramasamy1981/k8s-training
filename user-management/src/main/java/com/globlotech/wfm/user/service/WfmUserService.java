package com.globlotech.wfm.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.globlotech.wfm.user.dao.WfmUserDao;
import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.entity.UserRole;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.security.PasswordEncDecryptManager;
import com.globlotech.wfm.user.vo.MessageVO;
import com.globlotech.wfm.user.vo.UserRoleVO;
import com.globlotech.wfm.user.vo.UserVO;

/**
 * @author Manikandan
 *
 */
@Service
public class WfmUserService {

	private static final Logger log = LoggerFactory.getLogger(WfmUserService.class);

	@Autowired
	WfmUserDao  wfmUserDao;
	
	@Autowired
	PasswordEncDecryptManager passwordEncDecryptManager;

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<UserVO> getAllUsersForACompany(String companyCode) {

		log.info( "*************WfmUserService*****getAllUsersForACompany*************Entry******");
		List<UserVO> userVos = new ArrayList<UserVO>();
		List<User> userEntities = new ArrayList<User>();
		UserVO userVO = null;
		//populate Entities
		try {
			userEntities = wfmUserDao.getAllUsersForACompany(companyCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****getAllUsersForACompany*********Error*******************Exit") ;
			throw new WfmUserException("WfmUserService**Exception in getAllUsersForACompany " + ex.getMessage());
		}

		// populate userVO 
		if( userEntities != null && userEntities.size() > 0) {
			for(User user:userEntities) {
				userVO = new UserVO();
				userVO = populateUserVO(user);
				userVos.add(userVO); 
			}
		}
		log.info( "*************WfmUserService*****getAllUsersForACompany********************************************Exit");
		return userVos;
	}

	
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserVO getUserForACompany(String companyCode , Long userId) {

		log.info( "*************WfmUserService*****getUserForACompany*************Entry******");

		UserVO userVO = null;
		User user = new User();

		try {
			user = wfmUserDao.getUserForACompany(companyCode,userId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****getUserForACompany*********Error*******************Exit");
			throw new WfmUserException("WfmUserService**Exception in getUserForACompany " + ex.getMessage());
		}
		// populate userRequestVO 
		userVO = populateUserVO(user);

		log.info("*************WfmUserService*****getUserForACompany********************************************Exit");
		return userVO;
	}



	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserVO getUserByIdForACompany(Long userId) {

		log.info( "*************WfmUserService*****getUserByIdForACompany*************Entry******");
		log.info( "*************WfmUserService*****getUserByIdForACompany*userId***"+userId);
		UserVO userVO = null;
		User user = null;
		//populate Entities
		try {
			user = wfmUserDao.getUserByIdForACompany(userId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****getUserByIdForACompany*********Error*******************Exit");
			throw new WfmUserException("WfmUserService**Exception in getUserByIdForACompany " + ex.getMessage());
		}
		userVO=populateUserVO(user);
		log.info("*************WfmUserService*****getUserByIdForACompany********************************************Exit");
		return userVO;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserVO addUserForACompany(UserVO  userVO) {
		log.info( "*************WfmUserService*****addUserForACompany*************Entry******");
		log.info( "*************WfmUserService*****addUserForACompany****userVO*****"+userVO.toString());
		UserVO userVo = null;
		//populate Entities
		User user = populateUserEntity(userVO);
		
		try {
			user = wfmUserDao.addUserForACompany(user);
			log.info( "*************WfmUserService*****addUserForACompany**user**"+user.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****addUserForACompany*********Error*******************");
			throw new WfmUserException("WfmUserService**Exception in addUserForACompany " + ex.getMessage());
		}
		// populate user 
		userVo=populateUserVO(user);
		log.info( "*************WfmUserService*****addUserForACompany**userVo**"+userVo.toString());
		log.info( "*************WfmUserService*****addUserForACompany*******Exit");
		return userVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserVO updateUserForACompany(UserVO  userVO) {
		log.info( "*************WfmUserService*****updateUserForACompany*************Entry******");
		log.info( "*************WfmUserService*****updateUserForACompany****userVO*****"+userVO.toString());
		UserVO userVo = null;
		//populate Entities
		User user = populateUserEntity(userVO);
		try {
			user = wfmUserDao.updateUserForACompany(user);
			log.info( "*************WfmUserService*****updateUserForACompany**user**"+user.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****updateUserForACompany*********Error*******************Exit");
			throw new WfmUserException("WfmUserService**Exception in updateUserForACompany " + ex.getMessage());
		}
		// populate userRequestVO 
		userVo=populateUserVO(user);
		log.info( "*************WfmUserService*****updateUserForACompany**userVo**"+userVo.toString());
		log.info( "*************WfmUserService*****updateUserForACompany*******Exit");
		return userVO;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserVO getUserByUserName(String  userName) {
		log.info( "*************WfmUserService*****getUserByUserName*************Entry******");
		log.info( "*************WfmUserService*****getUserByUserName****userName*****"+userName.toString());
		UserVO userVo = null;
		//populate Entities
		User user = null;
		//User user = populateUserEntity(userVO);
		try {
			user = wfmUserDao.getUserByUserName(userName);
			log.info( "*************WfmUserService*****getUserByUserName**user**"+userName.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****getUserByUserName*********Error*******************Exit");
			throw new WfmUserException("WfmUserService**Exception in getUserByUserName " + ex.getMessage());
		}
		// populate userRequestVO 
		userVo=populateUserVO(user);
		log.info( "*************WfmUserService*****getUserByUserName**userVo**"+userVo.toString());
		log.info( "*************WfmUserService*****getUserByUserName*******Exit");
		return userVo;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public MessageVO removeUserForACompany(Long userId) {
		log.info( "*************WfmUserService*****removeUserForACompany*************Entry******");
		MessageVO messageVo = null;
		//populate Entities
		try {
			messageVo = wfmUserDao.removeUserForACompany(userId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****removeUserForACompany*********Error*******************Exit");
			throw new WfmUserException("WfmUserService***Exception in removeUserForACompany"+ex.getMessage());
		}
		log.info( "*************WfmUserService*****removeUserForACompany*******Exit");
		return messageVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserRoleVO addUserRole(UserRoleVO  userRoleVO) {
		log.info( "*************WfmUserService*****addUserRole*************Entry******");
		UserRoleVO userRoleVo = null;
		UserRole userRole = new UserRole();
		//populate Entities
		userRole = populateUserRoleEntity(userRoleVO);
		
		try {
			userRole = wfmUserDao.addUserRole(userRole);
			log.info( "*************WfmUserService*****addUserRole*************userRole******"+userRole.toString());	
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****addUserRole*********Error*******************Exit");
			throw new WfmUserException("Exception in addUserRole " + ex.getMessage());
		}
		// populate userroleVO 
        userRoleVo = populateUserRoleVO(userRole);
        log.info( "*************WfmUserService*****addUserRole****userRoleVo***"+userRoleVo.toString());
		log.info( "*************WfmUserService*****addUserRole*******Exit");
		return userRoleVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserRoleVO updateUserRole(UserRoleVO  userRoleVO) {
		log.info( "*************WfmUserService*****updateUserRole*************Entry******");
		UserRoleVO userRoleVo = null;
		UserRole userRole = new UserRole();
		//populate Entities
		userRole = populateUserRoleEntity(userRoleVO);
		
		try {
			userRole = wfmUserDao.updateUserRole(userRole);
			log.info( "*************WfmUserService*****updateUserRole*************userRole******"+userRole.toString());	
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****updateUserRole*********Error*******************Exit") ;
			throw new WfmUserException("Exception in updateUserRole " + ex.getMessage());
		}
		// populate userroleVO 
        userRoleVo = populateUserRoleVO(userRole);
        log.info( "*************WfmUserService*****updateUserRole****userRoleVo***"+userRoleVo.toString());
				log.info( "*************WfmUserService*****updateUserRole*******Exit");
		return userRoleVO;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserRoleVO getUserRole(Long userRoleId) {
		log.info( "*************WfmUserService*****getUserRole*************Entry******");
		UserRoleVO userRoleVo = null;
		UserRole userRole = new UserRole();
		
		try {
			userRole = wfmUserDao.getUserRole(userRoleId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****getUserRole*********Error*******************Exit") ;
			throw new WfmUserException("Exception in getUserRole " + ex.getMessage());
		}
		userRoleVo = populateUserRoleVO(userRole);
		log.info( "*************WfmUserService*****getUserRole*******Exit");
		return userRoleVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public MessageVO removeUserRole(Long userRoleId) {
		log.info( "*************WfmUserService*****removeUserRole*************Entry******");
		MessageVO messageVo = null;
		//populate Entities
		try {
			messageVo = wfmUserDao.removeUserRole(userRoleId);
			log.info( "*************WfmUserService*****removeUserRole*******messageVo*******"+messageVo.toString());	
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserService*****removeUserRole*********Error*******************Exit");
			throw new WfmUserException("Exception in removeUserRole " + ex.getMessage());
		}
		log.info( "*************WfmUserService*****removeUserRole*******Exit");
		return messageVo;
	}

	/**
	 * @param oneTimeVO
	 * @return
	 */
	public User populateUserEntity(UserVO userVO) {
		log.info( "*************WfmUserService*****populateUserEntity******Entry****");
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		user.setPassword(passwordEncDecryptManager.encrypt(userVO.getPassword()));
		log.info( "*************WfmUserService*****populateUserEntity*****Exit*********");
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

	/**
	 * @param oneTimeVO
	 * @return
	 */
	public UserRole populateUserRoleEntity(UserRoleVO userRoleVO) {
		log.info( "*************WfmUserService*****populateUserRoleEntity******Entry****");
		UserRole userRole = new UserRole();
		BeanUtils.copyProperties(userRoleVO, userRole);
		log.info( "*************WfmUserService*****populateUserRoleEntity*****Exit*********");
		return userRole;
	}

	/**
	 * @param populateuserRequestVO
	 * @return
	 */
	public UserRoleVO populateUserRoleVO(UserRole userRole) {

		log.info( "*************WfmUserService*****populateUserRoleVO******Entry****");
		UserRoleVO userRoleVO = new UserRoleVO();
		BeanUtils.copyProperties(userRole,userRoleVO);
		log.info( "*************WfmUserService*****populateUserRoleVO******Exit****");
		return userRoleVO;
	}

}
