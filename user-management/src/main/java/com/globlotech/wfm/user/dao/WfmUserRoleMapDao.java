package com.globlotech.wfm.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globlotech.wfm.user.entity.Module;
import com.globlotech.wfm.user.entity.RoleToModule;
import com.globlotech.wfm.user.entity.RoleToScreenAccess;
import com.globlotech.wfm.user.entity.ScreenAccess;
import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.entity.UserRole;
import com.globlotech.wfm.user.entity.UserToRole;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.repository.RoleToModuleRepository;
import com.globlotech.wfm.user.repository.RoleToScreenAccessRepository;
import com.globlotech.wfm.user.repository.UserToRoleRepository;

/**
 * @author Manikandan
 *
 */
@Component
public class WfmUserRoleMapDao {
	private static final Logger log = LoggerFactory.getLogger(WfmUserRoleMapDao.class);


	@Autowired
	RoleToModuleRepository roleToModuleRepository;
	
	@Autowired
	RoleToScreenAccessRepository roleToScreenAccessRepository;
	
	@Autowired
	UserToRoleRepository userToRoleRepository;
	
	
	
	/**
	 * @param roleToModule
	 * @return
	 */
	public RoleToModule assignUserModuleToRole(RoleToModule roleToModule) {
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole******");
		
		try {
			roleToModule = roleToModuleRepository.save(roleToModule);
			log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole***roleToModule***"+roleToModule.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****assignUserModuleToRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole*******Exit");
		return roleToModule;
	}

	
	/**
	 * @param roleToModule
	 * @return
	 */
	public RoleToModule unAssignUserModuleToRole(RoleToModule roleToModule) {
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole******");
		
		try {
			roleToModuleRepository.delete(roleToModule);
			log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole** un assigned User Module To Role ****");
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****unAssignUserModuleToRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole*******Exit");
		return roleToModule;
	}
	
	
	/**
	 * @param roleToScreenAccess
	 * @return
	 */
	public RoleToScreenAccess assignScreenAccessToRole(RoleToScreenAccess roleToScreenAccess) {
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole******");
		
		try {
			roleToScreenAccess = roleToScreenAccessRepository.save(roleToScreenAccess);
			log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole** assigned Screen Access To Role ****");
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****assignScreenAccessToRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole*******Exit");
		return roleToScreenAccess;
	}
	
	
	/**
	 * @param roleToScreenAccess
	 * @return
	 */
	public RoleToScreenAccess unAssignScreenAccessToRole(RoleToScreenAccess roleToScreenAccess) {
		log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole******");
		
		try {
			roleToScreenAccessRepository.delete(roleToScreenAccess);
			log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole** unassigned Screen Access To Role ****");
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****unAssignScreenAccessToRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole*******Exit");
		return roleToScreenAccess;
	}
  
	/**
	 * @param roleToModule
	 * @return
	 */
	public UserToRole assignUserToUserRole(UserToRole userToRole) {
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole******");
		
		try {
			userToRole = userToRoleRepository.save(userToRole);
			log.info("*************WfmUserRoleMapServie*****assignUserToUserRole***userToRole***"+userToRole.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****assignUserToUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****assignUserToUserRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole*******Exit");
		return userToRole;
	}

	/**
	 * @param roleToModule
	 * @return
	 */
	public UserToRole unAssignUserToUserRole(UserToRole userToRole) {
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole******");
		
		try {
			userToRoleRepository.delete(userToRole);
			log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole***userToRole***"+userToRole.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****unAssignUserToUserRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole*******Exit");
		return userToRole;
	}

	/**
	 * @param userId
	 * @return
	 */
	public List<UserRole> getUserRolesForAUser(Long userId) {
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser******");
		List<UserRole> userRoles = new ArrayList<UserRole>();
		try {
			userRoles = userToRoleRepository.getUserRolesForAUser(userId);
			log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser***userRoles***"+userRoles.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getUserRolesForAUser*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser*******Exit");
		return userRoles;
	}
	
	/**
	 * @param userRoleId
	 * @return
	 */
	public List<User> getUsersForAUserRole(Long userRoleId) {
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole******");
		List<User> users = new ArrayList<User>();
		try {
			users = userToRoleRepository.getUsersForAUserRole(userRoleId);
			log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole***users***"+users.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getUsersForAUserRole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole*******Exit");
		return users;
	}
	
	/**
	 * @param moduleId
	 * @return
	 */
	public List<UserRole> getRolesForAModule(Long moduleId) {
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule******");
		List<UserRole> userRoles = new ArrayList<UserRole>();
		try {
			userRoles = roleToModuleRepository.getRolesForAModule(moduleId);
			log.info("*************WfmUserRoleMapServie*****getRolesForAModule***userRoles***"+userRoles.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getRolesForAModule**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getRolesForAModule*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule*******Exit");
		return userRoles;
	}

	/**
	 * @param userRoleId
	 * @return
	 */
	public List<Module> getModulesForARole(Long userRoleId) {
		log.info("*************WfmUserRoleMapServie*****getModulesForARole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getModulesForARole******");
		List<Module> modules = new ArrayList<Module>();
		try {
			modules = roleToModuleRepository.getModulesForARole(userRoleId);
			log.info("*************WfmUserRoleMapServie*****getModulesForARole***modules***"+modules.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getModulesForARole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getModulesForARole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****getModulesForARole*******Exit");
		return modules;
	}

	/**
	 * @param userRoleId
	 * @return
	 */
	public List<ScreenAccess> getScreenAccessesForARole(Long userRoleId) {
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole******");
		List<ScreenAccess> screenAccesses = new ArrayList<ScreenAccess>();
		try {
			screenAccesses = roleToScreenAccessRepository.getScreenAccessesForARole(userRoleId);
			log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole***screenAccesses***"+screenAccesses.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getScreenAccessesForARole*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole*******Exit");
		return screenAccesses;
	}
	
	public List<UserRole> getUserRolesForScreenAccess(Long screenAccessId) {
		log.info("*************WfmUserRoleMapServie*****getUserRolesForScreenAccess**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getUserRolesForScreenAccess******");
		List<UserRole> userRoles = new ArrayList<UserRole>();
		try {
			userRoles = roleToScreenAccessRepository.getUserRolesForScreenAccess(screenAccessId);
			log.info("*************WfmUserRoleMapServie*****getUserRolesForScreenAccess***userRoles***"+userRoles.toString());	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getUserRolesForScreenAccess**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getUserRolesForScreenAccess*Exception occured");
		}
		log.info("*************WfmUserRoleMapServie*****getUserRolesForScreenAccess*******Exit");
		return userRoles;
	}


}
