package com.globlotech.wfm.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.entity.UserRole;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.repository.UserRepository;
import com.globlotech.wfm.user.repository.UserRoleRepository;
import com.globlotech.wfm.user.vo.MessageVO;

/**
 * @author Manikandan
 *
 */
@Component
public class WfmUserDao {

	private static final Logger log = LoggerFactory.getLogger(WfmUserDao.class);

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;

	/**
	 * @param attributeKey
	 * @return
	 */
	public List<User> getAllUsersForACompany(String companyCode) 
	{
		List<User> users = new ArrayList<User>();
		log.info( "*************WfmuserDao*****getAllUsersForACompany*****Entry*******");
		try {
			users=userRepository.getAllUserDetailsForACompany(companyCode);
			if(users != null && users.size() > 0) {
				log.info("*************WfmuserDao*****getAllUsersForACompany****users***"+users.toString());
				log.info("*************WfmuserDao*****getAllUsersForACompany****userRequests**Size*"+users.size());
			}else if(users.size() ==0) {
				throw new WfmUserException("WfmuserDao**getAllUsersForACompany***No Data found");
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmuserDao*****getAllUsersForACompany****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmuserDao**getAllUsersForACompany***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmuserDao*****getAllUsersForACompany*****Exit*******");

		return users;
	}
	

	/**
	 * @param companyCode
	 * @param userId
	 * @return
	 */
	public User getUserForACompany(String companyCode , Long userId) {
		log.info( "*************WfmuserDao*****getUserForACompany*************Entry******");
		//populate Entities
		User user = new User();
		
		try {
			user = userRepository.getUserDetailsByCompanyCodeAndUserId(companyCode,userId);
			log.info("*************WfmuserDao*****getUserForACompany********user****"+user.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****getUserForACompany*********Error*******************Exit");
			throw new WfmUserException("Exception in getUserforACompany " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****getUserForACompany********************************************Exit");
		return user;
	}

	/**
	 * @param userId
	 * @return
	 */
	public User getUserByIdForACompany(Long userId) {
		log.info( "*************WfmuserDao*****getUserByIdForACompany*************Entry******");
		User user = new User();
		Optional<User> userEntity = Optional.of(user); 
		//populate Entities
		try {
			userEntity = userRepository.findById(userId);
			log.info("*************WfmuserDao*****getUserByIdForACompany********userEntity****"+userEntity.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****getUserByIdForACompany*********Error****Exit*******");
			throw new WfmUserException("Exception in getUserforACompany " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****getUserByIdForACompany******************Exit***********");
		return userEntity.get();
	}

	/**
	 * @param user
	 * @return
	 */
	public User addUserForACompany(User user) {
		log.info( "*************WfmuserDao*****addUserForACompany*************Entry******");
		log.info( "*************WfmuserDao*****addUserForACompany**user**"+user.toString());
		//User userEntity = null;
		//populate Entities
		try {
			user = userRepository.save(user);
			log.info( "*************WfmuserDao*****addUserForACompany*AfterDB update***user**"+user.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****addUserForACompany*********Error****Exit*******");
			throw new WfmUserException("Exception in addUserForACompany " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****addUserForACompany******************Exit***********");
		return user;
	}
	
	/**
	 * @param user
	 * @return
	 */
	public User updateUserForACompany(User user) {
		log.info( "*************WfmuserDao*****updateUserForACompany*************Entry******");
		log.info( "*************WfmuserDao*****updateUserForACompany**user**"+user.toString());
		User userEntity = null;
		//populate Entities
		try {
			user = userRepository.save(user);
			log.info( "*************WfmuserDao*****updateUserForACompany*After update*user**"+user.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****updateUserForACompany*********Error****Exit*******");
			throw new WfmUserException("Exception in updateUserForACompany " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****updateUserForACompany******************Exit***********");
		return user;
	}
	
	/**
	 * @param user
	 * @return
	 */
	public User getUserByUserName(String userName) {
		log.info( "*************WfmuserDao*****getUserByUserName*************Entry******");
		log.info( "*************WfmuserDao*****getUserByUserName**user**"+userName.toString());
		User userEntity = null;
		//populate Entities
		try {
			userEntity = userRepository.findByUserName(userName);
			log.info( "*************WfmuserDao*****getUserByUserName*After update*user**"+userEntity.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****getUserByUserName*********Error****Exit*******");
			throw new WfmUserException("Exception in getUserByUserName " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****getUserByUserName******************Exit***********");
		return userEntity;
	}
	/**
	 * @param userId
	 * @return
	 */
	public MessageVO removeUserForACompany(Long userId) {
		log.info( "*************WfmuserDao*****removeUserForACompany*************Entry******");
		MessageVO messageVO = new MessageVO();
		try {
			userRepository.deleteById(userId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****removeUserForACompany*********Error****Exit*******");
			messageVO.setMessage("Removed User With Id  " + userId);
			messageVO.setOperation("REMOVE");
			messageVO.setStatus("SUCCESS");
			throw new WfmUserException("Exception in removeUserForACompany " + ex.getMessage());			
		}
		messageVO.setMessage("Removed User With Id " + userId);
		messageVO.setOperation("REMOVE");
		messageVO.setStatus("SUCCESS");
		log.info("*************WfmuserDao*****removeUserForACompany******************Exit***********");
		return messageVO;
	}
	
	/**
	 * @param userRole
	 * @return
	 */
	public UserRole addUserRole(UserRole userRole) {
		log.info( "*************WfmuserDao*****addUserRole*************Entry******");
		log.info( "*************WfmuserDao*****addUserRole***userRole*****"+userRole.toString());
		//populate Entities
		try {
			userRole = userRoleRepository.save(userRole);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****addUserRole*********Error****Exit*******");
			throw new WfmUserException("Exception in addUserRole " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****addUserRole******************Exit***********");
		return userRole;
	}
	
	/**
	 * @param userRole
	 * @return
	 */
	public UserRole updateUserRole(UserRole userRole) {
		log.info( "*************WfmuserDao*****updateUserRole*************Entry******");
		log.info( "*************WfmuserDao*****updateUserRole***userRole*****"+userRole.toString());
		//populate Entities
		try {
			userRole = userRoleRepository.save(userRole);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****updateUserRole*********Error****Exit*******");
			throw new WfmUserException("Exception in updateUserRole " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****updateUserRole******************Exit***********");
		return userRole;
	}

	/**
	 * @param userRole
	 * @return
	 */
	public UserRole getUserRole(Long userRoleId) {
		log.info( "*************WfmuserDao*****getUserRole*************Entry******");
		UserRole userRole = new UserRole();
		Optional<UserRole> userRoleEntity = Optional.of(userRole);
		try {
			userRoleEntity = userRoleRepository.findById(userRoleId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****getUserRole*********Error****Exit*******");
			throw new WfmUserException("Exception in getUserRole " + ex.getMessage());
		}
		log.info("*************WfmuserDao*****getUserRole******************Exit***********");
		return userRoleEntity.get();
	}
	
	/**
	 * @param userRole
	 * @return
	 */
	public MessageVO removeUserRole(Long userRoleId) {
		log.info( "*************WfmuserDao*****removeUserRole*************Entry******");
		MessageVO messageVO = new MessageVO();
		UserRole userRole = new UserRole();
		Optional<UserRole> userRoleEntity = Optional.of(userRole);
		//populate Entities
		try {
			userRoleEntity = userRoleRepository.findById(userRoleId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****removeUserRole*********Error****Exit*******");
			throw new WfmUserException("Exception in removeUserRole " + ex.getMessage());
		}
		try {
			
		     userRoleRepository.delete(userRoleEntity.get());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmuserDao*****removeUserRole*********Error****Exit*******");
			messageVO.setMessage("Removed User Role with Id " + userRoleId);
			messageVO.setOperation("REMOVE");
			messageVO.setStatus("FAILED");
			throw new WfmUserException("Exception in removeUserRole " + ex.getMessage());
		}
		messageVO.setMessage("Removed User Role with Id " + userRoleId);
		messageVO.setOperation("REMOVE");
		messageVO.setStatus("SUCCESS");		
		log.info("*************WfmuserDao*****removeUserRole******************Exit***********");
		return messageVO;
	}
}