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

import com.globlotech.wfm.user.dao.WfmUserModuleDao;
import com.globlotech.wfm.user.entity.Module;
import com.globlotech.wfm.user.entity.Screen;
import com.globlotech.wfm.user.entity.ScreenAccess;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.vo.MessageVO;
import com.globlotech.wfm.user.vo.ModuleVO;
import com.globlotech.wfm.user.vo.ScreenAccessVO;
import com.globlotech.wfm.user.vo.ScreenVO;

/**
 * @author Manikandan
 *
 */
@Service
public class WfmUserModuleService {

	private static final Logger log = LoggerFactory.getLogger(WfmUserModuleService.class);

	@Autowired
	WfmUserModuleDao  wfmUserModuleDao;

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ModuleVO addUserModule(ModuleVO moduleVO) {
		log.info( "*************WfmUserModuleService*****addUserModule*************Entry******");
		log.info( "*************WfmUserModuleService*****addUserModule********moduleVO******"+moduleVO.toString());
		ModuleVO moduleVo = null;
		//populate Entities
		Module module = populateModuleEntity(moduleVO);

		try {
			module = wfmUserModuleDao.addUserModule(module);

		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****addUserModule*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate userRequestVO 
		moduleVo = populateModuleVO(module);
		log.info( "*************WfmUserModuleService*****addUserModule********moduleVo******"+moduleVo.toString());
		log.info( "*************WfmUserModuleService*****addUserModule*******Exit");
		return moduleVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ModuleVO updateUserModule(ModuleVO  moduleVO) {
		log.info( "*************WfmUserModuleService*****updateUserModule*************Entry******");
		log.info( "*************WfmUserModuleService*****updateUserModule********moduleVO******"+moduleVO.toString());
		ModuleVO moduleVo = null;
		//populate Entities
		Module module = populateModuleEntity(moduleVO);

		try {
			module = wfmUserModuleDao.updateUserModule(module);

		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****updateUserModule*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate userRequestVO 
		moduleVo = populateModuleVO(module);
		log.info( "*************WfmUserModuleService*****updateUserModule********moduleVo******"+moduleVo.toString());
		log.info( "*************WfmUserModuleService*****updateUserModule*******Exit");
		return moduleVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public MessageVO removeModuleById(Long moduleId) {
		log.info( "*************WfmUserModuleService*****removeUserModule*************Entry******");
		MessageVO messageVo = null;
		//populate Entities
		try {
			messageVo = wfmUserModuleDao.removeModuleById(moduleId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****removeUserModule*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate userRequestVO 
		log.info( "*************WfmUserModuleService*****removeUserModule*******Exit");
		return messageVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ModuleVO getModuleById(Long moduleId) {
		log.info( "*************WfmUserModuleService*****getModuleById*************Entry******");
		ModuleVO moduleVo = new ModuleVO();
		Module module = new Module();
		//populate Entities
		try {
			module = wfmUserModuleDao.getModuleById(moduleId);
			log.info( "*************WfmUserModuleService*****getModuleById******module********"+module.toString());	
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****getModuleById*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate userRequestVO 
		moduleVo = populateModuleVO(module);
		log.info( "*************WfmUserModuleService*****getModuleById******moduleVo********"+moduleVo.toString());	
		log.info( "*************WfmUserModuleService*****getModuleById*******Exit");
		return moduleVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ScreenVO addScreen(ScreenVO screenVO) {
		log.info( "*************WfmUserModuleService*****addScreen*************Entry******");
		ScreenVO screenVo = null;
		//populate Entities
		Screen screen = populateScreenEntity(screenVO);
		try {
			screen = wfmUserModuleDao.addScreen(screen);
			log.info( "*************WfmUserModuleService*****addScreen******screen*****"+screen.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****addScreen*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate userRequestVO 
		screenVo = populateScreenVO(screen);
		log.info( "*************WfmUserModuleService*****addScreen******screenVo*****"+screenVo.toString());
		log.info( "*************WfmUserModuleService*****addScreen*******Exit");
		return screenVo;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ScreenVO updateScreen(ScreenVO screenVO) {
		log.info( "*************WfmUserModuleService*****updateScreen*************Entry******");
		ScreenVO screenVo = null;
		//populate Entities
		Screen screen = populateScreenEntity(screenVO);
		try {
			screen = wfmUserModuleDao.updateScreen(screen);
			log.info( "*************WfmUserModuleService*****updateScreen******screen*****"+screen.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****updateScreen*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate userScreenVO 
		screenVo = populateScreenVO(screen);
		log.info( "*************WfmUserModuleService*****updateScreen******screenVo*****"+screenVo.toString());
		log.info( "*************WfmUserModuleService*****updateScreen*******Exit");
		return screenVo;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public MessageVO removeScreenById(Long screenId) {
		log.info( "*************WfmUserModuleService*****removeScreenById*************Entry******");
		MessageVO messageVo = null;
		//populate Entities
		try {
			messageVo = wfmUserModuleDao.removeScreenById(screenId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****removeScreenById*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		log.info( "*************WfmUserModuleService*****removeScreenById*******Exit");
		return messageVo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<ScreenVO> getScreensForAModule(Long moduleId) {
		log.info( "*************WfmUserModuleService*****getScreensForAModule*************Entry******");
		List<ScreenVO> screenVos = new ArrayList<ScreenVO>();;
		List<Screen> screens = null;
		ScreenVO screenVO = null;

		try {
			screens = wfmUserModuleDao.getScreensForAModule(moduleId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****getScreensForAModule*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}

		// populate  
		if(screens !=null && screens.size() >0) {
			log.info( "*************WfmUserModuleService*****getScreensForAModule**size*"+screens.size());
			for(Screen screen : screens) {
				screenVO = new ScreenVO();
				screenVO = populateScreenVO(screen);
				log.info( "*************WfmUserModuleService*****getScreensForAModule**screenVO*"+screenVO.toString());
				screenVos.add(screenVO);
			}
		}else {
			log.info( "*************WfmUserModuleService*****getScreensForAModule**No data retrieved from DB*");
			throw new WfmUserException("No data retrieved from DB");
		}
		log.info( "*************WfmUserModuleService*****getScreensForAModule*******Exit");
		return screenVos;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ScreenVO getScreenById(Long screenId) {
		log.info( "*************WfmUserModuleService*****getScreenById*************Entry******");
		ScreenVO screenVo = null;
		Screen screen = null;		
		try {
			screen = wfmUserModuleDao.getScreenById(screenId);
			log.info( "*************WfmUserModuleService*****getScreenById**screen*"+screen.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****getScreenById*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		screenVo = populateScreenVO(screen);
		log.info( "*************WfmUserModuleService*****getScreenById**screenVo*"+screenVo.toString());
		log.info( "*************WfmUserModuleService*****getScreenById*******Exit");
		return screenVo;
	}

	/**
	 * @param screenAccessVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ScreenAccessVO addScreenAccess(ScreenAccessVO screenAccessVO) {
		log.info( "*************WfmUserModuleService*****addScreenAccess*************Entry******");
		ScreenAccessVO screenAccessVo = null;
		ScreenAccess screenAccess = null;
		screenAccess = populateScreenAccessEntity(screenAccessVO);
		try {
			screenAccess= wfmUserModuleDao.addScreenAccess(screenAccess);
			log.info( "*************WfmUserModuleService*****addScreenAccess****screenAccess*****"+screenAccess);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****addScreenAccess*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		screenAccessVo = populateScreenAccessVO(screenAccess);
		log.info( "*************WfmUserModuleService*****addScreenAccess****screenAccessVo*****"+screenAccessVo.toString());
		log.info( "*************WfmUserModuleService*****addScreenAccess*******Exit");
		return screenAccessVo;
	}

	/**
	 * @param screenAccessVO
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ScreenAccessVO updateScreenAccess(ScreenAccessVO screenAccessVO) {
		log.info( "*************WfmUserModuleService*****updateScreenAccess*************Entry******");
		ScreenAccessVO screenAccessVo = null;
		ScreenAccess screenAccess = null;
		//populate Entities
		screenAccess = populateScreenAccessEntity(screenAccessVO);
		try {
			screenAccess= wfmUserModuleDao.updateScreenAccess(screenAccess);
			log.info( "*************WfmUserModuleService*****updateScreenAccess****screenAccess*****"+screenAccess);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****updateScreenAccess*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		// populate  
		screenAccessVo = populateScreenAccessVO(screenAccess);
		log.info( "*************WfmUserModuleService*****updateScreenAccess****screenAccessVo*****"+screenAccessVo.toString());
		log.info( "*************WfmUserModuleService*****updateScreenAccess*******Exit");
		return screenAccessVo;
	}

	/**
	 * @param screenId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public List<ScreenAccessVO> getScreenAccessForAScreen(Long screenId) {
		log.info( "*************WfmUserModuleService*****getScreenAccessForAScreen*************Entry******");
		ScreenAccessVO screenAccessVo = null;
		List<ScreenAccessVO> screenAccessVos = new ArrayList<ScreenAccessVO>();;
		List<ScreenAccess> screenAccesses = null;
		try {
			screenAccesses = wfmUserModuleDao.getScreenAccessForAScreen(screenId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****getScreenAccessForAScreen*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		if(screenAccesses !=null && screenAccesses.size() >0) {
			log.info( "*************WfmUserModuleService*****getScreenAccessForAScreen********size********"+screenAccesses.size());
			for(ScreenAccess screenAccess:screenAccesses) {
				screenAccessVo = new ScreenAccessVO();
				screenAccessVo = populateScreenAccessVO(screenAccess);
				log.info( "*************WfmUserModuleService*****getScreenAccessForAScreen********screenAccessVo********"+screenAccessVo.toString());
				screenAccessVos.add(screenAccessVo);
			}
		}else {
			log.info( "*************WfmUserModuleService*****getScreenAccessForAScreen***No data found*****");
		}
		log.info( "*************WfmUserModuleService*****getScreenAccessForAScreen*******Exit");
		return screenAccessVos;
	}

	/**
	 * @param screenAccessId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public ScreenAccessVO getScreenAccessById(Long screenAccessId) {
		log.info( "*************WfmUserModuleService*****getScreenAccessById*************Entry******");
		ScreenAccessVO screenAccessVo = null;
		ScreenAccess screenAccess = null;

		//populate Entities
		try {
			screenAccess = wfmUserModuleDao.getScreenAccessById(screenAccessId);
			log.info( "*************WfmUserModuleService*****getScreenAccessById*****screenAccess**"+screenAccess.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****getScreenAccessById*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		screenAccessVo = populateScreenAccessVO(screenAccess);
		log.info( "*************WfmUserModuleService*****getScreenAccessById*****screenAccessVo**"+screenAccessVo.toString());
		log.info( "*************WfmUserModuleService*****getScreenAccessById*******Exit");
		return screenAccessVo;
	}

	/**
	 * @param screenAccessId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW , rollbackFor = { WfmUserException.class })
	public MessageVO removeScreenAccessById(Long screenAccessId) {
		log.info( "*************WfmUserModuleService*****removeScreenAccessById*************Entry******");
		MessageVO messageVO = null;
		
		try {
			messageVO = wfmUserModuleDao.removeScreenAccessById(screenAccessId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleService*****removeScreenAccessById*********Error*******************Exit") ;
			throw new WfmUserException("Exception in WfmUserModuleService " + ex.getMessage());
		}
		log.info( "*************WfmUserModuleService*****removeScreenAccessById*******Exit");
		return messageVO;
	}

	/**
	 * @param moduleVO
	 * @return
	 */
	
	public Module populateModuleEntity(ModuleVO moduleVO) {
		log.info( "*************WfmUserService*****populateModuleEntity******Entry****");
		Module module = new Module();
		BeanUtils.copyProperties(moduleVO, module);
		log.info( "*************WfmUserService*****populateModuleEntity*****Exit*********");
		return module;
	}

	/**
	 * @param module
	 * @return
	 */
	public ModuleVO populateModuleVO(Module module) {
		log.info( "*************WfmUserModuleService*****populateModuleVO******Entry****");
		ModuleVO moduleVO = new ModuleVO();
		BeanUtils.copyProperties(module,moduleVO);
		log.info( "*************WfmUserModuleService*****populateModuleVO******Exit****");
		return moduleVO;
	}

	/**
	 * @param screenVO
	 * @return
	 */
	public Screen populateScreenEntity(ScreenVO screenVO) {
		log.info( "*************WfmUserModuleService*****populateScreenEntity******Entry****");
		Screen screen = new Screen();
		BeanUtils.copyProperties(screenVO, screen);
		log.info( "*************WfmUserModuleService*****populateScreenEntity*****Exit*********");
		return screen;
	}

	/**
	 * @param screen
	 * @return
	 */
	public ScreenVO populateScreenVO(Screen screen) {
		log.info( "*************WfmUserModuleService*****populateScreenVO******Entry****");
		ScreenVO screenVO = new ScreenVO();
		BeanUtils.copyProperties(screen,screenVO);
		log.info( "*************WfmUserModuleService*****populateScreenVO******Exit****");
		return screenVO;
	}

	/**
	 * @param screenAccessVO
	 * @return
	 */
	public ScreenAccess populateScreenAccessEntity(ScreenAccessVO screenAccessVO) {
		log.info( "*************WfmUserModuleService*****populateScreenAccessEntity******Entry****");
		ScreenAccess screenAccess = new ScreenAccess();
		BeanUtils.copyProperties(screenAccessVO, screenAccess);
		log.info( "*************WfmUserModuleService*****populateScreenAccessEntity*****Exit*********");
		return screenAccess;
	}


	/**
	 * @param screenAccess
	 * @return
	 */
	public ScreenAccessVO populateScreenAccessVO(ScreenAccess screenAccess) {
		log.info( "*************WfmUserModuleService*****populateScreenAccessVO******Entry****");
		ScreenAccessVO screenAccessVO = new ScreenAccessVO();
		BeanUtils.copyProperties(screenAccess,screenAccessVO);
		log.info( "*************WfmUserModuleService*****populateScreenAccessVO******Exit****");
		return screenAccessVO;
	}

}
