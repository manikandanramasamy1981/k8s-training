package com.globlotech.wfm.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.service.WfmUserRoleMapServie;
import com.globlotech.wfm.user.vo.ModuleVO;
import com.globlotech.wfm.user.vo.RoleToModuleVO;
import com.globlotech.wfm.user.vo.RoleToScreenAccessVO;
import com.globlotech.wfm.user.vo.ScreenAccessVO;
import com.globlotech.wfm.user.vo.UserRoleVO;
import com.globlotech.wfm.user.vo.UserToRoleVO;
import com.globlotech.wfm.user.vo.UserVO;

/**
 * @author Manikandan
 *
 */
@RestController
@RequestMapping("/userrolemap/v1")
public class WfmUserRoleMapController {
	
	private static final Logger log = LoggerFactory.getLogger(WfmUserRoleMapController.class);
	
	@Autowired
	WfmUserRoleMapServie wfmUserRoleMapService;
	
	/**
	 * @param roleToModuleVO
	 * @return
	 */
	@PostMapping("/assignModule")
	public ResponseEntity<RoleToModuleVO> assignUserModuleToRole(@RequestBody RoleToModuleVO roleToModuleVO) {
		log.info("*************WfmUserRoleMapController*****assignUserModuleToRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****assignUserModuleToRole***roleToModuleVO***"+roleToModuleVO.toString());
		
		try {
			roleToModuleVO = wfmUserRoleMapService.assignUserModuleToRole(roleToModuleVO);
			log.info("*************WfmUserRoleMapController*****assignUserModuleToRole***roleToModuleVO***"+roleToModuleVO.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****assignUserModuleToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***unassignScreenAccessToRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****assignUserModuleToRole*******Exit");
		return new ResponseEntity<RoleToModuleVO>(roleToModuleVO, HttpStatus.ACCEPTED);
	}

	/**
	 * @param roleToModuleVO
	 * @return
	 */
	@PostMapping("/unassignModule")
	public ResponseEntity<RoleToModuleVO> unAssignUserModuleToRole(@RequestBody RoleToModuleVO roleToModuleVO) {
		log.info("*************WfmUserRoleMapController*****unAssignUserModuleToRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****unAssignUserModuleToRole***roleToModuleVO***"+roleToModuleVO.toString());
		
		try {
			roleToModuleVO = wfmUserRoleMapService.unAssignUserModuleToRole(roleToModuleVO);
			log.info("*************WfmUserRoleMapController*****unAssignUserModuleToRole***roleToModuleVO***"+roleToModuleVO.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****unAssignUserModuleToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***unassignScreenAccessToRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****unAssignUserModuleToRole*******Exit");
		return new ResponseEntity<RoleToModuleVO>(roleToModuleVO, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param roleToScreenAccessVO
	 * @return
	 */
	@PostMapping("/assignScreenAccess")
	public ResponseEntity<RoleToScreenAccessVO> assignScreenAccessToRole(@RequestBody RoleToScreenAccessVO roleToScreenAccessVO) {
		log.info("*************WfmUserRoleMapController*****assignScreenAccessToRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****assignScreenAccessToRole***roleToScreenAccessVO***"+roleToScreenAccessVO.toString());
		
		try {
			roleToScreenAccessVO = wfmUserRoleMapService.assignScreenAccessToRole(roleToScreenAccessVO);
			log.info("*************WfmUserRoleMapController*****assignScreenAccessToRole***roleToScreenAccessVO***"+roleToScreenAccessVO.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****assignScreenAccessToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***assignScreenAccessToRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****assignScreenAccessToRole*******Exit");
		return new ResponseEntity<RoleToScreenAccessVO>(roleToScreenAccessVO, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param roleToScreenAccessVO
	 * @return
	 */
	@PostMapping("/unassignScreenAccess")
	public ResponseEntity<RoleToScreenAccessVO> unAssignScreenAccessToRole(@RequestBody RoleToScreenAccessVO roleToScreenAccessVO) {
		log.info("*************WfmUserRoleMapController*****unassignScreenAccessToRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****unassignScreenAccessToRole**roleToScreenAccessVO****"+roleToScreenAccessVO.toString());
		
		try {
			roleToScreenAccessVO = wfmUserRoleMapService.unAssignScreenAccessToRole(roleToScreenAccessVO);
			log.info("*************WfmUserRoleMapController*****unassignScreenAccessToRole**roleToScreenAccessVO****"+roleToScreenAccessVO.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****unassignScreenAccessToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***unassignScreenAccessToRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****unassignScreenAccessToRole*******Exit");
		return new ResponseEntity<RoleToScreenAccessVO>(roleToScreenAccessVO, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param userToRoleVO
	 * @return
	 */
	@PostMapping("/assignUserToUserRole")
	public ResponseEntity<UserToRoleVO> assignUserToUserRole(@RequestBody UserToRoleVO userToRoleVO) {
		log.info("*************WfmUserRoleMapController*****assignUserToUserRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****assignUserToUserRole***userToRoleVO***"+userToRoleVO.toString());
		
		try {
			userToRoleVO = wfmUserRoleMapService.assignUserToUserRole(userToRoleVO);
			log.info("*************WfmUserRoleMapController*****assignUserToUserRole***userToRoleVO***"+userToRoleVO.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****assignUserToUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***assignUserToUserRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****assignScreenAccessToRole*******Exit");
		return new ResponseEntity<UserToRoleVO>(userToRoleVO, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param userToRoleVO
	 * @return
	 */
	@PostMapping("/unassignUserToUserRole")
	public ResponseEntity<UserToRoleVO> unAssignUserToUserRole(@RequestBody UserToRoleVO userToRoleVO) {
		log.info("*************WfmUserRoleMapController*****unAssignUserToUserRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****unAssignUserToUserRole***userToRoleVO***"+userToRoleVO.toString());
		
		try {
			userToRoleVO = wfmUserRoleMapService.unAssignUserToUserRole(userToRoleVO);
			log.info("*************WfmUserRoleMapController*****unAssignUserToUserRole***userToRoleVO***"+userToRoleVO.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****unAssignUserToUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***unAssignUserToUserRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****unAssignUserToUserRole*******Exit");
		return new ResponseEntity<UserToRoleVO>(userToRoleVO, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@GetMapping("/rolesForAUser/{userId}")
	public ResponseEntity<List<UserRoleVO>> getUserRolesForAUser(@PathVariable Long userId) {
		log.info("*************WfmUserRoleMapController*****getUserRolesForAUser**********Entry****");
		log.info("*************WfmUserRoleMapController*****getUserRolesForAUser***userId***"+userId.toString());
		List<UserRoleVO> userRolesVos = new ArrayList<UserRoleVO>();
		try {
			userRolesVos = wfmUserRoleMapService.getUserRolesForAUser(userId);
			log.info("*************WfmUserRoleMapController*****getUserRolesForAUser***userId***"+userId.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****getUserRolesForAUser**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***getUserRolesForAUser*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****getUserRolesForAUser*******Exit");
		return new ResponseEntity<List<UserRoleVO>>(userRolesVos, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param userRoleId
	 * @return
	 */
	@GetMapping("/usersForARole/{userRoleId}")
	public ResponseEntity<List<UserVO>> getUsersForAUserRole(@PathVariable Long userRoleId) {
		log.info("*************WfmUserRoleMapController*****getUsersForAUserRole**********Entry****");
		log.info("*************WfmUserRoleMapController*****getUsersForAUserRole***userRoleId***"+userRoleId);
		List<UserVO> userVos = new ArrayList<UserVO>();
		try {
			userVos = wfmUserRoleMapService.getUsersForAUserRole(userRoleId);
			log.info("*************WfmUserRoleMapController*****getUsersForAUserRole***userRoleId***"+userRoleId.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****getUsersForAUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***getUsersForAUserRole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****getUsersForAUserRole*******Exit");
		return new ResponseEntity<List<UserVO>>(userVos, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/rolesForAModule/{moduleId}")
	public ResponseEntity<List<UserRoleVO>> getRolesForAModule(@PathVariable Long moduleId) {
		log.info("*************WfmUserRoleMapController*****getRolesForAModule**********Entry****");
		log.info("*************WfmUserRoleMapController*****getRolesForAModule***moduleId***"+moduleId.toString());
		List<UserRoleVO> userRolesVos = new ArrayList<UserRoleVO>();
		try {
			userRolesVos = wfmUserRoleMapService.getRolesForAModule(moduleId);
			log.info("*************WfmUserRoleMapController*****getRolesForAModule***moduleId***"+moduleId.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****getRolesForAModule**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***getRolesForAModule*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****getRolesForAModule*******Exit");
		return new ResponseEntity<List<UserRoleVO>>(userRolesVos, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/modulesForARole/{roleId}")
	public ResponseEntity<List<ModuleVO>> getModulesForARole(@PathVariable Long roleId) {
		log.info("*************WfmUserRoleMapController*****getModulesForARole**********Entry****");
		log.info("*************WfmUserRoleMapController*****getModulesForARole***roleId***"+roleId.toString());
		List<ModuleVO> modules = new ArrayList<ModuleVO>();
		try {
			modules = wfmUserRoleMapService.getModulesForARole(roleId);
			log.info("*************WfmUserRoleMapController*****getModulesForARole***roleId***"+roleId.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****getModulesForARole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***getModulesForARole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****getModulesForARole*******Exit");
		return new ResponseEntity<List<ModuleVO>>(modules, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/rolesForAScreenAccess/{screenAccessId}")
	public ResponseEntity<List<UserRoleVO>> getUserRolesForScreenAccess(@PathVariable Long screenAccessId) {
		log.info("*************WfmUserRoleMapController*****getUserRolesForScreenAccess**********Entry****");
		log.info("*************WfmUserRoleMapController*****getUserRolesForScreenAccess***screenAccessId***"+screenAccessId.toString());
		List<UserRoleVO> userRolesVos = new ArrayList<UserRoleVO>();
		try {
			userRolesVos = wfmUserRoleMapService.getUserRolesForScreenAccess(screenAccessId);
			log.info("*************WfmUserRoleMapController*****getUserRolesForScreenAccess***screenAccessId***"+screenAccessId.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****getUserRolesForScreenAccess**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***getUserRolesForScreenAccess*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****getUserRolesForScreenAccess*******Exit");
		return new ResponseEntity<List<UserRoleVO>>(userRolesVos, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/screenAccessForARole/{userRoleId}")
	public ResponseEntity<List<ScreenAccessVO>> getScreenAccessesForARole(@PathVariable Long userRoleId) {
		log.info("*************WfmUserRoleMapController*****getScreenAccessesForARole**********Entry****");
		log.info("*************WfmUserRoleMapController*****getScreenAccessesForARole***userRoleId***"+userRoleId.toString());
		List<ScreenAccessVO> screenAccessVos = new ArrayList<ScreenAccessVO>();
		try {
			screenAccessVos = wfmUserRoleMapService.getScreenAccessesForARole(userRoleId);
			log.info("*************WfmUserRoleMapController*****getScreenAccessesForARole***userRoleId***"+userRoleId.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapController*****getScreenAccessesForARole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapController***getScreenAccessesForARole*****Exception occured");
		}
		log.info("*************WfmUserRoleMapController*****getScreenAccessesForARole*******Exit");
		return new ResponseEntity<List<ScreenAccessVO>>(screenAccessVos, HttpStatus.ACCEPTED);
	}
}