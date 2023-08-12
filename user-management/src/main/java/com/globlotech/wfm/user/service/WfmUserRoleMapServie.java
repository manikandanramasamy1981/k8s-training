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

import com.globlotech.wfm.user.dao.WfmUserRoleMapDao;
import com.globlotech.wfm.user.entity.Module;
import com.globlotech.wfm.user.entity.RoleToModule;
import com.globlotech.wfm.user.entity.RoleToScreenAccess;
import com.globlotech.wfm.user.entity.ScreenAccess;
import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.entity.UserRole;
import com.globlotech.wfm.user.entity.UserToRole;
import com.globlotech.wfm.user.exception.WfmUserException;
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
@Service
public class WfmUserRoleMapServie {
	
	private static final Logger log = LoggerFactory.getLogger(WfmUserRoleMapServie.class);
	
	@Autowired
	WfmUserRoleMapDao wfmUserRoleMapDao ;
	
	@Autowired
	WfmUserService wfmUserService; 
	
	@Autowired
	WfmUserModuleService wfmUserModuleService;

	/**
	 * @param roleToModuleVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public RoleToModuleVO assignUserModuleToRole(RoleToModuleVO roleToModuleVO) {
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole******");
		RoleToModule roleToModule = null;
		RoleToModuleVO roleToModuleVo = null;
		roleToModule = populateRoleToModuleEntity(roleToModuleVO);
		try {
			roleToModule = wfmUserRoleMapDao.assignUserModuleToRole(roleToModule);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****assignUserModuleToRole*Exception occured");
		}
		roleToModuleVo = populateRoleToModuleVO(roleToModule);
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole****roleToModuleVo**"+roleToModuleVo.toString());
		log.info("*************WfmUserRoleMapServie*****assignUserModuleToRole*******Exit");
		return roleToModuleVo;
	}

	
	/**
	 * @param roleToModuleVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public RoleToModuleVO unAssignUserModuleToRole(RoleToModuleVO roleToModuleVO) {
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole******");
		RoleToModule roleToModule = null;
		RoleToModuleVO roleToModuleVo = null;
		roleToModule = populateRoleToModuleEntity(roleToModuleVO);
		try {
			roleToModule = wfmUserRoleMapDao.unAssignUserModuleToRole(roleToModule);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****unAssignUserModuleToRole*Exception occured");
		}
		roleToModuleVo = populateRoleToModuleVO(roleToModule);
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole****roleToModuleVo**"+roleToModuleVo.toString());
		log.info("*************WfmUserRoleMapServie*****unAssignUserModuleToRole*******Exit");
		return roleToModuleVO;
	}
	
	
	/**
	 * @param roleToScreenAccessVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public RoleToScreenAccessVO assignScreenAccessToRole(RoleToScreenAccessVO roleToScreenAccessVO) {
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole******");
		RoleToScreenAccessVO roleToScreenAccessVo = new RoleToScreenAccessVO();
		RoleToScreenAccess roleToScreenAccess = new RoleToScreenAccess();
		roleToScreenAccess = populateRoleToScreenAccessEntity(roleToScreenAccessVO);
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole*****roleToScreenAccess****"+roleToScreenAccess.toString());
		try {
			roleToScreenAccess = wfmUserRoleMapDao.assignScreenAccessToRole(roleToScreenAccess);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****assignScreenAccessToRole*Exception occured");
		}
		roleToScreenAccessVo = populateRoleToScreenAccessVO(roleToScreenAccess);
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole*****roleToScreenAccessVo****"+roleToScreenAccessVo.toString());
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole*******Exit");
		return roleToScreenAccessVO;
	}
	
	
	/**
	 * @param roleToScreenAccessVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public RoleToScreenAccessVO unAssignScreenAccessToRole(RoleToScreenAccessVO roleToScreenAccessVO) {
		log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole******");
		RoleToScreenAccessVO roleToScreenAccessVo = new RoleToScreenAccessVO();
		RoleToScreenAccess roleToScreenAccess = new RoleToScreenAccess();
		roleToScreenAccess = populateRoleToScreenAccessEntity(roleToScreenAccessVO);
		try {
			roleToScreenAccess = wfmUserRoleMapDao.unAssignScreenAccessToRole(roleToScreenAccess);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****unAssignScreenAccessToRole*Exception occured");
		}
		roleToScreenAccessVo = populateRoleToScreenAccessVO(roleToScreenAccess);
		log.info("*************WfmUserRoleMapServie*****assignScreenAccessToRole*****roleToScreenAccessVo****"+roleToScreenAccessVo.toString());
		log.info("*************WfmUserRoleMapServie*****unassignScreenAccessToRole*******Exit");
		return roleToScreenAccessVO;
	}
	
	
	/**
	 * @param userToRoleVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserToRoleVO assignUserToUserRole(UserToRoleVO userToRoleVO) {
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole***userToRoleVO***"+userToRoleVO.toString() );
		UserToRole userToRole = new UserToRole();
		UserToRoleVO userToRoleVo = new UserToRoleVO();
		userToRole = populateUserToUserRoleEntity(userToRoleVO);
		try {
			userToRole = wfmUserRoleMapDao.assignUserToUserRole(userToRole);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****assignUserToUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****assignUserToUserRole*Exception occured");
		}
		userToRoleVo = populateUserToUserRoleVO(userToRole);
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole****userToRoleVo**"+userToRoleVo.toString());
		log.info("*************WfmUserRoleMapServie*****assignUserToUserRole*******Exit");
		return userToRoleVo;
	}
	
	/**
	 * @param userToRoleVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public UserToRoleVO unAssignUserToUserRole(UserToRoleVO userToRoleVO) {
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole******");
		UserToRole userToRole = new UserToRole();
		UserToRoleVO userToRoleVo = new UserToRoleVO();
		userToRole = populateUserToUserRoleEntity(userToRoleVO);
		try {
			userToRole = wfmUserRoleMapDao.unAssignUserToUserRole(userToRole);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****unAssignUserToUserRole*Exception occured");
		}
		userToRoleVo = populateUserToUserRoleVO(userToRole);
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole****userToRoleVo**"+userToRoleVo.toString());
		log.info("*************WfmUserRoleMapServie*****unAssignUserToUserRole*******Exit");
		return userToRoleVO;
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<UserRoleVO> getUserRolesForAUser(Long userId) {
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser******");
		UserRoleVO userRoleVo = new UserRoleVO();
		List<UserRoleVO> userRoleVos = new ArrayList<UserRoleVO>();
		List<UserRole> userRoles = new ArrayList<UserRole>();
		try {
			userRoles = wfmUserRoleMapDao.getUserRolesForAUser(userId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getUserRolesForAUser*Exception occured");
		}
		if( userRoles!= null && userRoles.size() > 0) {
			log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser**userRoles.size()***"+userRoles.size());
			for(UserRole userRoleEntity : userRoles) {
				userRoleVo = wfmUserService.populateUserRoleVO(userRoleEntity);	
				userRoleVos.add(userRoleVo);
			}
		}
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser****userRoleEntity**"+userRoleVos.toString());
		log.info("*************WfmUserRoleMapServie*****getUserRolesForAUser*******Exit");
		return userRoleVos;
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<UserVO> getUsersForAUserRole(Long userRoleId) {
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole******");
		UserVO userVo = new UserVO();
		List<UserVO> userVos = new ArrayList<UserVO>();
		List<User> users = new ArrayList<User>();
		try {
			users = wfmUserRoleMapDao.getUsersForAUserRole(userRoleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getUsersForAUserRole*Exception occured");
		}
		if( users!= null && users.size() > 0) {
			log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole**users.size()***"+users.size());
			for(User userEntity : users) {
				userVo = wfmUserService.populateUserVO(userEntity);	
				userVos.add(userVo);
			}
		}
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole****userVos**"+userVos.toString());
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole*******Exit");
		return userVos;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<UserRoleVO> getRolesForAModule(Long moduleId) {
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule******");
		UserRoleVO userRoleVo = new UserRoleVO();
		List<UserRoleVO> userRoleVos = new ArrayList<UserRoleVO>();
		List<UserRole> userRoles = new ArrayList<UserRole>();
		try {
			userRoles = wfmUserRoleMapDao.getRolesForAModule(moduleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getRolesForAModule**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getRolesForAModule*Exception occured");
		}
		if( userRoles!= null && userRoles.size() > 0) {
			log.info("*************WfmUserRoleMapServie*****getRolesForAModule**userRoles.size()***"+userRoles.size());
			for(UserRole userRoleEntity : userRoles) {
				userRoleVo = wfmUserService.populateUserRoleVO(userRoleEntity);	
				userRoleVos.add(userRoleVo);
			}
		}
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole****userRoleVos**"+userRoleVos.toString());
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole*******Exit");
		return userRoleVos;
	}

	/**
	 * @param userRoleId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<ModuleVO> getModulesForARole(Long userRoleId) {
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getRolesForAModule******");
		ModuleVO moduleVo = new ModuleVO();
		List<ModuleVO> moduleVos = new ArrayList<ModuleVO>();
		List<Module> modules = new ArrayList<Module>();
		try {
			modules = wfmUserRoleMapDao.getModulesForARole(userRoleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getRolesForAModule**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getRolesForAModule*Exception occured");
		}
		if( modules!= null && modules.size() > 0) {
			log.info("*************WfmUserRoleMapServie*****getRolesForAModule**modules.size()***"+modules.size());
			for(Module moduleEntity : modules) {
				moduleVo = wfmUserModuleService.populateModuleVO(moduleEntity);	
				moduleVos.add(moduleVo);
			}
		}
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole****modules**"+modules.toString());
		log.info("*************WfmUserRoleMapServie*****getUsersForAUserRole*******Exit");
		return moduleVos;
	}
	
	/**
	 * @param userRoleId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<ScreenAccessVO> getScreenAccessesForARole(Long userRoleId) {
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole******");
		ScreenAccessVO screenAccessVo = new ScreenAccessVO();
		List<ScreenAccessVO> screenAccessVos = new ArrayList<ScreenAccessVO>();
		List<ScreenAccess> screenAccesses = new ArrayList<ScreenAccess>();
		try {
			screenAccesses = wfmUserRoleMapDao.getScreenAccessesForARole(userRoleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getScreenAccessesForARole*Exception occured");
		}
		if( screenAccesses!= null && screenAccesses.size() > 0) {
			log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**screenAccesses.size()***"+screenAccesses.size());
			for(ScreenAccess screenAccessEntity : screenAccesses) {
				screenAccessVo = wfmUserModuleService.populateScreenAccessVO(screenAccessEntity);	
				screenAccessVos.add(screenAccessVo);
			}
		}
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole****screenAccesses**"+screenAccesses.toString());
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole*******Exit");
		return screenAccessVos;
	}

	/**
	 * @param screenAccessId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<UserRoleVO> getUserRolesForScreenAccess(Long screenAccessId) {
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**********Entry****");
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole******");
		UserRoleVO userRoleVo = new UserRoleVO();
		List<UserRoleVO> userRoleVos = new ArrayList<UserRoleVO>();
		List<UserRole> userRoles = new ArrayList<UserRole>();
		try {
			userRoles = wfmUserRoleMapDao.getUserRolesForScreenAccess(screenAccessId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**Exception occured*");
			throw new WfmUserException("WfmUserRoleMapServie*****getScreenAccessesForARole*Exception occured");
		}
		if( userRoles!= null && userRoles.size() > 0) {
			log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole**userRoles.size()***"+userRoles.size());
			for(UserRole userRoleEntity : userRoles) {
				userRoleVo = wfmUserService.populateUserRoleVO(userRoleEntity);	
				userRoleVos.add(userRoleVo);
			}
		}
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole****userRoles**"+userRoles.toString());
		log.info("*************WfmUserRoleMapServie*****getScreenAccessesForARole*******Exit");
		return userRoleVos;
	}

	/**
	 * @param roleToModuleVO
	 * @return
	 */
	private RoleToModule populateRoleToModuleEntity(RoleToModuleVO roleToModuleVO) {
		log.info( "*************WfmUserRoleMapServie*****populateRoleToModuleEntity******Entry****");
		RoleToModule roleToModule = new RoleToModule();
		BeanUtils.copyProperties(roleToModuleVO, roleToModule);
		log.info( "*************WfmUserRoleMapServie*****populateScreenAccessEntity*****Exit*********");
		return roleToModule;
	}


	/**
	 * @param roleToModule
	 * @return
	 */
	private RoleToModuleVO populateRoleToModuleVO(RoleToModule roleToModule) {
		log.info( "*************WfmUserRoleMapServie*****populateRoleToModuleVO******Entry****");
		RoleToModuleVO roleToModuleVO = new RoleToModuleVO();
		BeanUtils.copyProperties(roleToModule, roleToModuleVO);
		log.info( "*************WfmUserRoleMapServie*****populateRoleToModuleVO*****Exit*********");
		return roleToModuleVO;
	}
	
	
	/**
	 * @param roleToScreenAccessVO
	 * @return
	 */
	private RoleToScreenAccess populateRoleToScreenAccessEntity(RoleToScreenAccessVO roleToScreenAccessVO) {
		log.info( "*************WfmUserRoleMapServie*****populateRoleToScreenAccessEntity******Entry****");
		RoleToScreenAccess roleToScreenAccess = new RoleToScreenAccess();
		BeanUtils.copyProperties(roleToScreenAccessVO, roleToScreenAccess);
		log.info( "*************WfmUserRoleMapServie*****populateRoleToScreenAccessEntity****roleToScreenAccess**********"+roleToScreenAccess.toString());
		log.info( "*************WfmUserRoleMapServie*****populateRoleToScreenAccessEntity*****Exit*********");
		return roleToScreenAccess;
	}


	/**
	 * @param roleToScreenAccess
	 * @return
	 */
	private RoleToScreenAccessVO populateRoleToScreenAccessVO(RoleToScreenAccess roleToScreenAccess) {
		log.info( "*************WfmUserRoleMapServie*****populateRoleToScreenAccessVO******Entry****");
		RoleToScreenAccessVO roleToScreenAccessVO = new RoleToScreenAccessVO();
		BeanUtils.copyProperties(roleToScreenAccess, roleToScreenAccessVO);
		log.info( "*************WfmUserRoleMapServie*****populateRoleToScreenAccessVO*****Exit*********");
		return roleToScreenAccessVO;
	}

	/**
	 * @param userToRoleVO
	 * @return
	 */
	private UserToRole populateUserToUserRoleEntity(UserToRoleVO userToRoleVO) {
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleEntity******Entry****");
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleEntity******userToRoleVO**"+userToRoleVO.toString());
		UserToRole userToRole = new UserToRole();
		BeanUtils.copyProperties(userToRoleVO, userToRole);
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleEntity****userToRole**********"+userToRole.toString());
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleEntity*****Exit*********");
		return userToRole;
	}


	/**
	 * @param userToRoleVO
	 * @return
	 */
	private UserToRoleVO populateUserToUserRoleVO(UserToRole userToRole) {
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleVO******Entry****");
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleVO******userToRole****"+userToRole.toString());
		UserToRoleVO userToRoleVO = new UserToRoleVO();
		BeanUtils.copyProperties(userToRole, userToRoleVO);
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleVO******userToRoleVO****"+userToRoleVO.toString());
		log.info( "*************WfmUserRoleMapServie*****populateUserToUserRoleVO*****Exit*********");
		return userToRoleVO;
	}

}
