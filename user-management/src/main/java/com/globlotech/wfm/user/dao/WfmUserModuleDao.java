package com.globlotech.wfm.user.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globlotech.wfm.user.constants.WfmUserConstants;
import com.globlotech.wfm.user.entity.Module;
import com.globlotech.wfm.user.entity.Screen;
import com.globlotech.wfm.user.entity.ScreenAccess;
import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.repository.ModuleRepository;
import com.globlotech.wfm.user.repository.ScreenAccessRepository;
import com.globlotech.wfm.user.repository.ScreenRepository;
import com.globlotech.wfm.user.vo.MessageVO;

/**
 * @author Manikandan
 *
 */
@Component
public class WfmUserModuleDao {

	private static final Logger log = LoggerFactory.getLogger(WfmUserModuleDao.class);

	@Autowired
	ModuleRepository moduleRespository;

	@Autowired
	ScreenRepository screenRepository; 

	@Autowired
	ScreenAccessRepository screenAccessRepository;
	
	
	/**
	 * @param module
	 * @return
	 */
	public Module addUserModule(Module  module) {
		log.info( "*************WfmUserModuleDao*****addUserModule*****Entry*******");
		
		try {
			module=moduleRespository.save(module);
			log.info("*************WfmUserModuleDao*****addUserModule****module***"+module.toString());
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****addUserModule****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**addUserModule***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****addUserModule*****Exit*******");
		return module;
	}

	/**
	 * @param module
	 * @return
	 */
	public Module updateUserModule(Module  module) {
		log.info( "*************WfmUserModuleDao*****updateUserModule*****Entry*******");
		try {
			module=moduleRespository.save(module);
			log.info("*************WfmUserModuleDao*****updateUserModule****module***"+module.toString());
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****updateUserModule****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**updateUserModule***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****updateUserModule*****Exit*******");
		return module;
	}

	/**
	 * @param moduleId
	 * @return
	 */
	public Module getModuleById(Long moduleId) {
		log.info( "*************WfmUserModuleDao*****getModuleById*****Entry*******");
		Module module = new Module();
		Optional<Module> moduleEntity = Optional.of(module);
		boolean isPresent = false;
		try {
			moduleEntity=moduleRespository.findById(moduleId);
			isPresent = moduleEntity.isPresent();
			if(isPresent) {
				log.info("*************WfmUserModuleDao*****getModuleById*****moduleEntity**"+moduleEntity.toString());
				module = moduleEntity.get();
			}else {
				log.info("*************WfmUserModuleDao*****getModuleById***NoModule Found for the id ****"+moduleEntity.toString());
				throw new WfmUserException("No module found with id "+moduleId);
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****getModuleById****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**getModuleById***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****getModuleById*****Exit*******");
		return module;
	}

	/**
	 * @param moduleId
	 * @return
	 */
	public MessageVO removeModuleById(Long moduleId) {
		log.info( "*************WfmUserModuleDao*****removeModuleById*****Entry*******");
		MessageVO messageVO = new MessageVO();
		Module module = new Module();
		Optional<Module> moduleEntity = Optional.of(module);
		//find the entity
		try {
			moduleEntity=moduleRespository.findById(moduleId);
			log.info("*************WfmUserModuleDao*****removeModuleById*****moduleEntity**"+moduleEntity.toString());
		
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****removeModuleById****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**removeModuleById***Exception***"+ex.getMessage());
		}
		
		boolean isPresent = moduleEntity.isPresent();
		// remove 
		try {
			if(isPresent) {
				moduleRespository.delete(moduleEntity.get());
				log.info("*************WfmUserModuleDao*****removeModuleById*****moduleEntity**"+moduleEntity.toString());	
			}else {
				log.info("*************WfmUserModuleDao*****removeModuleById***No Module found*********");
			}
		
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****removeModuleById****DatabaseException*****"+ ex.getMessage());
			messageVO.setMessage("Removed module with Id " + moduleId);
			messageVO.setStatus("FAILED");
			messageVO.setOperation("REMOVE");
			throw new WfmUserException("WfmUserModuleDao**removeModuleById***Exception***"+ex.getMessage());
		} 
		 if(isPresent) {
			 messageVO.setMessage("Removed module with Id " + moduleId);
			 messageVO.setStatus("SUCCESS");
			 messageVO.setOperation("REMOVE");	 
		 }
		
		log.info("*************WfmUserModuleDao*****removeModuleById*****Exit*******");
		return messageVO;
	}
	/**
	 * @param screen
	 * @return
	 */
	public Screen addScreen(Screen  screen) {
		log.info( "*************WfmUserModuleDao*****addScreen*****Entry*******");
		try {
			screen=screenRepository.save(screen);			
			log.info("*************WfmUserModuleDao*****addScreen****screen***"+screen.toString());
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****addScreen****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**addScreen***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****addScreen*****Exit*******");
		return screen;
	}

	/**
	 * @param screen
	 * @return
	 */
	public Screen updateScreen(Screen  screen) {
		log.info( "*************WfmUserModuleDao*****updateScreen*****Entry*******");
		try {
			screen=screenRepository.save(screen);
			log.info("*************WfmUserModuleDao*****updateScreen****screen***"+screen.toString());
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****updateScreen****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**updateScreen***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****updateScreen*****Exit*******");
		return screen;
	}

	/**
	 * @param screenId
	 * @return
	 */
	public Screen getScreenById(Long  screenId) {
		log.info( "*************WfmUserModuleDao*****getScreenById*****Entry*******");
		Screen screen = new Screen();
		Optional<Screen> screenEntity = Optional.of(screen);
		boolean isPresent= false;
		try {
			screenEntity=screenRepository.findById(screenId);
			isPresent = screenEntity.isPresent();
			if(isPresent) {
				screen = screenEntity.get();
				log.info("*************WfmUserModuleDao*****getScreenById****screen***"+screen.toString());
			}else {
				log.info("*************WfmUserModuleDao*****getScreenById****No Screen Entity available for the given id***");
				throw new WfmUserException("No Screen found for the id "+screenId);
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****getScreenById****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**getScreenById***Exception***"+ex.getMessage());
		} 
		
		log.info("*************WfmUserModuleDao*****getScreenById*****Exit*******");
		return screen;
	}

	/**
	 * @param moduleId
	 * @return
	 */
	public List<Screen> getScreensForAModule(Long moduleId) {
		log.info( "*************WfmUserModuleDao*****getScreensForAModule*****Entry*******");
		Screen screen = null;
		List<Screen> screens = null;
		try {
             screens = screenRepository.findScreensForAModule(moduleId);
             if(screens.size() >0 ) {
            	 for(Screen screenEntity:screens) {
            		 log.info("*************WfmUserModuleDao*****getScreensForAModule****screenEntity***"+screenEntity.toString());	 
            	 }
             } else {
            	 log.info("*************WfmUserModuleDao*****getScreensForAModule***No data found ****");
            	 throw new WfmUserException("No data available");
             }
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****getScreensForAModule****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**getScreensForAModule***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****getScreensForAModule*****Exit*******");
		return screens;
	}

	/**
	 * @param screenId
	 * @return
	 */
	public MessageVO removeScreenById(Long screenId) {
		log.info( "*************WfmUserModuleDao*****removeScreenById*****Entry*******");
		MessageVO messageVO = new MessageVO();
		Screen screen = null;
		try {
		    screen = findScreenById(screenId);
			log.info("*************WfmUserModuleDao*****removeScreenById*******"+screen.toString());
		    if(screen.getScreenId() > 0) {
		    	screenRepository.delete(screen);
		    	messageVO.setMessage(WfmUserConstants.MESSAGE_REMOVE + screen);
		    	messageVO.setOperation(WfmUserConstants.MESSAGE_REMOVE);
		    	messageVO.setStatus(WfmUserConstants.STATUS_SUCCESS);
		    }else {
		    	log.info("*************WfmUserModuleDao*****removeScreenById****No Screen found with id***");
		    	messageVO.setMessage(WfmUserConstants.MESSAGE_NO_SCREEN_ACCESS_DATA + screen);
		    	messageVO.setOperation(WfmUserConstants.MESSAGE_REMOVE);
		    	messageVO.setStatus(WfmUserConstants.STATUS_SUCCESS);
		    	throw new WfmUserException("No Screen found with id "+screenId);
		    }
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****removeScreenById****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**removeScreenById***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****removeScreenById*****Exit*******");
		return messageVO;
	}

	/**
	 * @param screen
	 * @return
	 */
	public ScreenAccess addScreenAccess(ScreenAccess  screenAccess) {
		log.info( "*************WfmUserModuleDao*****addScreenAccess*****Entry*******");
		try {
			screenAccess = screenAccessRepository.save(screenAccess);
			log.info("*************WfmUserModuleDao*****addScreenAccess****screenAccess***"+screenAccess.toString());
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****addScreenAccess****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**addScreenAccess***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****addScreenAccess*****Exit*******");
		return screenAccess;
	}

	/**
	 * @param screen
	 * @return
	 */
	public ScreenAccess updateScreenAccess(ScreenAccess  screenAccess) {
		log.info( "*************WfmUserModuleDao*****updateScreenAccess*****Entry*******");
		try {
			screenAccess=screenAccessRepository.save(screenAccess);
			log.info("*************WfmUserModuleDao*****updateScreenAccess****screenAccess***"+screenAccess.toString());
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****updateScreenAccess****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**updateScreenAccess***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****updateScreenAccess*****Exit*******");
		return screenAccess;
	}

	/**
	 * @param screen
	 * @return
	 */
	public ScreenAccess getScreenAccessById(Long  screenAccessId) {
		log.info( "*************WfmUserModuleDao*****getScreenAccessById*****Entry*******");
		ScreenAccess screenAccess = new ScreenAccess();		
		try {
			screenAccess = findScreenAccessById(screenAccessId);			
		}catch(Exception ex) {
			ex.printStackTrace();
			log.error("*************WfmUserModuleDao*****getScreenAccessById****DatabaseException*****"+ ex.getMessage());
		}
		if(screenAccess.getScreenAccessId() > 0) {
			log.info("*************WfmUserModuleDao*****getScreenAccessById****screenAccess***"+screenAccess.toString());
		} else {
			log.info("*************WfmUserModuleDao*****getScreenAccessById**No data found for the case***");
		}
		log.info("*************WfmUserModuleDao*****getScreenAccessById*****Exit*******");
		return screenAccess;
	}
	
	/**
	 * @param screenAccessId
	 * @return
	 */
	public MessageVO removeScreenAccessById(Long screenAccessId) {
		log.info("*************WfmUserModuleDao*****removeScreenAccessById*****Exit*******");
		MessageVO messageVO = new MessageVO();
		ScreenAccess screenAccess = null;
		try {
		    screenAccess = findScreenAccessById(screenAccessId);
			log.info("*************WfmUserModuleDao*****removeScreenById*******"+screenAccess.toString());
		    if(screenAccess.getScreenId() > 0) {
		    	screenAccessRepository.delete(screenAccess);
		    	messageVO.setMessage(WfmUserConstants.MESSAGE_REMOVE + screenAccess);
		    	messageVO.setOperation(WfmUserConstants.MESSAGE_REMOVE);
		    	messageVO.setStatus(WfmUserConstants.STATUS_SUCCESS);
		    }else {
		    	log.info("*************WfmUserModuleDao*****removeScreenById****No Screen Access found with id***");
		    	messageVO.setMessage(WfmUserConstants.MESSAGE_NO_SCREEN_ACCESS_DATA+screenAccess);
		    	messageVO.setOperation(WfmUserConstants.MESSAGE_REMOVE);
		    	messageVO.setStatus(WfmUserConstants.STATUS_SUCCESS);
		    	throw new WfmUserException(WfmUserConstants.MESSAGE_NO_SCREEN_ACCESS_DATA +screenAccess);
		    }
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****removeScreenById****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**removeScreenById***Exception***"+ex.getMessage());
		}
		log.info("*************WfmUserModuleDao*****removeScreenAccessById*****Exit*******");
	   return messageVO;
	}

	/**
	 * @param screenId
	 * @return
	 */
	public List<ScreenAccess> getScreenAccessForAScreen(Long  screenId) {
		log.info( "*************WfmUserModuleDao*****getScreenAccessForAScreen*****Entry*******");
		List<ScreenAccess> screenAccessEntities = null;
		try {
			screenAccessEntities = screenAccessRepository.findScreenAccessForAScreen(screenId);
			if(screenAccessEntities.size() > 0) {
				log.info("*************WfmUserModuleDao*****getScreenAccessForAScreen****screenAccessEntities***"+screenAccessEntities);
				for(ScreenAccess screenAccess : screenAccessEntities) {
					log.info("*************WfmUserModuleDao*****getScreenAccessForAScreen****screenAccess***"+screenAccess.toString());		
				}
			}else {
				log.info("*************WfmUserModuleDao*****getScreenAccessForAScreen***No data found****");
			}
			
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****getScreenAccessForAScreen****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**getScreenAccessForAScreen***Exception***"+ex.getMessage());
		} 
		log.info("*************WfmUserModuleDao*****getScreenAccessForAScreen*****Exit*******");
		return screenAccessEntities;
	}
	
	/**
	 * @param screenId
	 * @return
	 */
	private Screen findScreenById(Long screenId) {
		log.info( "*************WfmUserModuleDao*****findScreenById*****Entry*******");
		Screen screen = new Screen();
		Optional<Screen> screenEntity = Optional.of(screen);
		boolean isPresent= false;
		try {
			screenEntity=screenRepository.findById(screenId);
			isPresent = screenEntity.isPresent();
			if(isPresent) {
				screen = screenEntity.get();
				log.info("*************WfmUserModuleDao*****findScreenById****screen***"+screen.toString());
			}else {
				log.info("*************WfmUserModuleDao*****findScreenById****No Screen Entity available for the given id***");
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****findScreenById****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**findScreenById***Exception***"+ex.getMessage());
		}
		return screen;
	}
	
	/**
	 * @param screenAccessId
	 * @return
	 */
	private ScreenAccess findScreenAccessById(Long screenAccessId) {
		ScreenAccess screenAccess = new ScreenAccess();
		Optional<ScreenAccess> screenAccessOpt = Optional.of(screenAccess);
		boolean isPresent = false;
		
		try {
			screenAccessOpt = screenAccessRepository.findById(screenAccessId);
			isPresent = screenAccessOpt.isPresent();
			if(isPresent) {
				screenAccess = screenAccessOpt.get();
				log.info("*************WfmUserModuleDao*****getScreenAccessById****ScreenAccess***"+screenAccessOpt.get().toString());	
			}else {
				log.info("*************WfmUserModuleDao*****getScreenAccessById**No Screen Access Data found for the id****"+screenAccessId);
				throw new WfmUserException("No Screen Access data found for the id "+ screenAccessId);
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			log.error("*************WfmUserModuleDao*****getScreenAccess****DatabaseException*****"+ ex.getMessage());
			throw new WfmUserException("WfmUserModuleDao**getScreenAccess***Exception***"+ex.getMessage());
		}
		return screenAccess;
	}
}