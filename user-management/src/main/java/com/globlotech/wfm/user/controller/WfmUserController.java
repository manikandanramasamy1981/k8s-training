package com.globlotech.wfm.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.service.WfmUserService;
import com.globlotech.wfm.user.vo.MessageVO;
import com.globlotech.wfm.user.vo.UserRoleVO;
import com.globlotech.wfm.user.vo.UserVO;

/**
 * @author Manikandan
 *
 */
@Validated
@RestController
@RequestMapping("/user/v1")
public class WfmUserController {

	private static final Logger log = LoggerFactory.getLogger(WfmUserController.class);

	@Autowired
	private WfmUserService wfmUserService;

	/**
	 * @param companyCode
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/user/companyCode/{companyCode}")
	public ResponseEntity<List<UserVO>> getAllUsersForACompany(@PathVariable String companyCode) {
		log.info(
				"*************WfmuserController*****getAllUsersForACompany********************************************Entry");
		log.info("*************WfmuserController*****getAllUsersForACompany**companyCode**" + companyCode);
		List<UserVO> userVOs = null;

		try {
			userVOs = wfmUserService.getAllUsersForACompany(companyCode);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****getAllUsersForACompany**Exception occured*");
		}
		log.info("*************WfmuserController*****getAlluserRequest*******Exit");
		return new ResponseEntity<List<UserVO>>(userVOs, HttpStatus.ACCEPTED);
	}
	
	// POST - add User

	@PostMapping("/user")
	public ResponseEntity<UserVO> addUserForACompany(@RequestBody UserVO userVO) {
		log.info("*************WfmuserController*****addUserForACompany**********Entry****");
		log.info("*************WfmuserController*****addUserForACompany**userVO****"+userVO.toString());
		
		try {
			userVO = wfmUserService.addUserForACompany(userVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****addUserForACompany**Exception occured*");
			throw new WfmUserException("WfmuserController*addUserForACompany*Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****addUserForACompany*******Exit");
		return new ResponseEntity<UserVO>(userVO, HttpStatus.ACCEPTED);
	}

	
	//PUT  - updateuser
	@PutMapping("/user")
	public ResponseEntity<UserVO> updateUserForACompany(@RequestBody UserVO userVO) {
		log.info("*************WfmuserController*****updateUserForACompany**********Entry****");
		log.info("*************WfmuserController*****updateUserForACompany**userVO****"+userVO.toString());
		
		try {
			userVO = wfmUserService.updateUserForACompany(userVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****updateUserForACompany**Exception occured*");
			throw new WfmUserException("WfmuserController*updateUserForACompany*Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****updateUserForACompany*******Exit");
		return new ResponseEntity<UserVO>(userVO, HttpStatus.ACCEPTED);
	}
	
	
	//GET - getUserFromCompany
	@GetMapping("/user/companyCode/{companyCode}/userId/{userId}")
	public ResponseEntity<UserVO> getUserForACompany(@PathVariable String companyCode , @PathVariable Long userId) {
		log.info(
				"*************WfmuserController*****getUserForACompany********************************************Entry");
		log.info("*************WfmuserController*****getUserForACompany**companyCode**" + companyCode);
		UserVO userVO = null;

		try {
			userVO = wfmUserService.getUserForACompany(companyCode,userId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****getUserForACompany**Exception occured*");
		}
		log.info("*************WfmuserController*****getUserForACompany*******Exit");
		return new ResponseEntity<UserVO>(userVO, HttpStatus.ACCEPTED);
	}

	//GET - getUserById
	@GetMapping("/user/userId/{userId}")
	public ResponseEntity<UserVO> getUserByIdForACompany(@PathVariable Long userId) {
		log.info("*************WfmuserController*****getUserByIdForACompany********************************************Entry");
		log.info("*************WfmuserController*****getUserByIdForACompany****");
		UserVO userVO = null;

		try {
			userVO = wfmUserService.getUserByIdForACompany(userId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****getUserByIdForACompany**Exception occured*");
		}
		log.info("*************WfmuserController*****getUserByIdForACompany*******Exit");
		return new ResponseEntity<UserVO>(userVO, HttpStatus.ACCEPTED);
	}
	
	
	// DELETE  - removeUserForACompany
	@DeleteMapping("/user/userId/{userId}")
	public ResponseEntity<MessageVO> removeUserForACompany(@PathVariable Long userId) {
		log.info("*************WfmuserController*****removeUserForACompany**********Entry****");
		log.info("*************WfmuserController*****removeUserForACompany******");
		MessageVO messageVO = null;
		
		try {
			messageVO = wfmUserService.removeUserForACompany(userId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****removeUserForACompany**Exception occured*");
			throw new WfmUserException("WfmuserController*removeUserForACompany*Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****removeUserForACompany*******Exit");
		return new ResponseEntity<MessageVO>(messageVO, HttpStatus.ACCEPTED);
	}
	
	// POST - add UserRole 
	@PostMapping("/userRole")
	public ResponseEntity<UserRoleVO> addUserRole(@RequestBody UserRoleVO userRoleVO) {
		log.info("*************WfmuserController*****addUserRole**********Entry****");
		log.info("*************WfmuserController*****addUserRole**userRoleVO****"+userRoleVO.toString());
		UserRoleVO userRoleVo = null;
		try {
			userRoleVo = wfmUserService.addUserRole(userRoleVO);
			log.info("*************WfmuserController*****addUserRole**userRoleVo****"+userRoleVo.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****addUserRole**Exception occured*");
			throw new WfmUserException("WfmuserController****addUserRole****Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****addUserRole*******Exit");
		return new ResponseEntity<UserRoleVO>(userRoleVo, HttpStatus.ACCEPTED);
	}
	
	//PUT  - updateuserRole
	@PutMapping("/userRole")
	public ResponseEntity<UserRoleVO> updateUserRole(@RequestBody UserRoleVO userRoleVO) {
		log.info("*************WfmuserController*****updateUserRole**********Entry****");
		log.info("*************WfmuserController*****updateUserRole***userRoleVO***"+userRoleVO.toString());
		UserRoleVO userRoleVo = null;
		try {
			userRoleVo = wfmUserService.updateUserRole(userRoleVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****updateUserRole**Exception occured*");
			throw new WfmUserException("WfmuserController*updateUserRole*Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****updateUserRole*******Exit");
		return new ResponseEntity<UserRoleVO>(userRoleVo, HttpStatus.ACCEPTED);
	}	
		
	//GET - getUserRoleForProduct
	@GetMapping("/userRole/userRoleId/{userRoleId}")
	public ResponseEntity<UserRoleVO> getUserRole(@PathVariable Long userRoleId) {
		log.info(
				"*************WfmuserController*****getUserRole********************************************Entry");
		log.info("*************WfmuserController*****getUserRole**userRoleId**"+userRoleId);
		UserRoleVO userRoleVO = null;

		try {
			userRoleVO = wfmUserService.getUserRole(userRoleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****getUserRole**Exception occured*");
			throw new WfmUserException("WfmuserController*getUserRole*Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****getUserRole*******Exit");
		return new ResponseEntity<UserRoleVO>(userRoleVO, HttpStatus.ACCEPTED);
	}
	
		
	// DELETE  - removeUserRoleForAProduct
	@DeleteMapping("/userRole/userRoleId/{userRoleId}")
	public ResponseEntity<MessageVO> removeUserRole(@PathVariable Long userRoleId) {
		log.info("*************WfmuserController*****removeUserRole**********Entry****");
		log.info("*************WfmuserController*****removeUserRole******");
		MessageVO messageVO = null;
		try {
			messageVO = wfmUserService.removeUserRole(userRoleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****removeUserRole**Exception occured*");
			throw new WfmUserException("WfmuserController*removeUserRole*Exception*"+ex.getMessage());
		}
		log.info("*************WfmuserController*****removeUserRole*******Exit");
		return new ResponseEntity<MessageVO>(messageVO, HttpStatus.ACCEPTED);
	}
	// To be in Module Controller 
	
		    
	      // To be in RoleMapController 
	
	   // POST - assignRoleToModule 
	
		//POST  - unassignRoleToModule
	
	 //POST - assignRoleToScreenAccess
	
	 //POST unassignRoleToScreenAccess
				
		  
}
