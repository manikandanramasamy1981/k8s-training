package com.globlotech.wfm.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globlotech.wfm.user.exception.WfmUserException;
import com.globlotech.wfm.user.service.WfmUserModuleService;
import com.globlotech.wfm.user.vo.MessageVO;
import com.globlotech.wfm.user.vo.ModuleVO;
import com.globlotech.wfm.user.vo.ScreenAccessVO;
import com.globlotech.wfm.user.vo.ScreenVO;

/**
 * @author Manikandan
 *
 */
@Validated
@RestController
@RequestMapping("/usermodule/v1")
public class WfmUserModuleController {
	
	private static final Logger log = LoggerFactory.getLogger(WfmUserModuleController.class);

	@Autowired
	private WfmUserModuleService wfmUserModuleService;
	
	/**
	 * @param moduleVO
	 * @return
	 */
	@PostMapping("/module")
	public ResponseEntity<ModuleVO> addUserModule(@RequestBody ModuleVO moduleVO) {
		log.info("*************WfmUserModuleController*****addUserModule**********Entry****");
		log.info("*************WfmUserModuleController*****addUserModule***moduleVO***"+moduleVO.toString());
		ModuleVO moduleVo = new ModuleVO();
		try {
			moduleVO = wfmUserModuleService.addUserModule(moduleVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****addUserModule**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****addUserModule****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****addUserModule***moduleVO***"+moduleVO.toString());
		log.info("*************WfmUserModuleController*****addUserModule*******Exit");
		return new ResponseEntity<ModuleVO>(moduleVO, HttpStatus.ACCEPTED);
	}

	

	/**
	 * @param moduleVO
	 * @return
	 */
	@PutMapping("/module")
	public ResponseEntity<ModuleVO> updateUserModule(@RequestBody ModuleVO moduleVO) {
		log.info("*************WfmUserModuleController*****updateUserModule**********Entry****");
		log.info("*************WfmUserModuleController*****updateUserModule******moduleVO**"+moduleVO.toString());
		ModuleVO moduleVo = new ModuleVO();
		try {
			moduleVO = wfmUserModuleService.updateUserModule(moduleVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****updateUserModule**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****updateUserModule****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****updateUserModule******moduleVO**"+moduleVO.toString());
		log.info("*************WfmUserModuleController*****updateUserModule*******Exit");
		return new ResponseEntity<ModuleVO>(moduleVO, HttpStatus.ACCEPTED);
	}
	

	/**
	 * @param productId
	 * @return
	 */
	@GetMapping("/module/productId/{productId}")
	public ResponseEntity<List<ModuleVO>> getModulesForAProduct(@PathVariable Long productId) {
		log.info("*************WfmUserModuleController*****getModulesForAProduct**********Entry****");
		log.info("*************WfmUserModuleController*****getModulesForAProduct******");
		List<ModuleVO> moduleVOs = null;
		try {
			//userRequestVOs = wfmUserService.getAlluserRequests(companyCode);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****getModulesForAProduct**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****getModulesForAProduct****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****getModulesForAProduct*******Exit");
		return new ResponseEntity<List<ModuleVO>>(moduleVOs, HttpStatus.ACCEPTED);
	}
	

	/**
	 * @param moduleId
	 * @return
	 */
	@GetMapping("/module/moduleId/{moduleId}")
	public ResponseEntity<ModuleVO> getModuleById(@PathVariable Long moduleId) {
		log.info("*************WfmUserModuleController*****getModuleById**********Entry****");
		log.info("*************WfmUserModuleController*****getModuleById****moduleId**"+moduleId);
		ModuleVO moduleVO = null;
		try {
			moduleVO = wfmUserModuleService.getModuleById(moduleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****getModuleById**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****getModuleById****"+ex.getMessage());
		}
		log.info("*****WfmUserModuleController*****getModuleById****moduleVO**"+moduleVO.toString());
		log.info("*************WfmUserModuleController*****getModuleById*******Exit");
		return new ResponseEntity<ModuleVO>(moduleVO, HttpStatus.ACCEPTED);
	}
	

	/**
	 * @param moduleId
	 * @return
	 */
	@DeleteMapping("/module/moduleId/{moduleId}")
	public ResponseEntity<MessageVO> removeModuleById(@PathVariable Long moduleId) {
		log.info("*************WfmUserModuleController*****removeModuleById**********Entry****");
		log.info("*************WfmUserModuleController*****removeModuleById***moduleId***"+moduleId);
		MessageVO messageVO = null;
		try {
			messageVO = wfmUserModuleService.removeModuleById(moduleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****removeModuleById**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeModuleById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****removeModuleById*******Exit");
		return new ResponseEntity<MessageVO>(messageVO, HttpStatus.ACCEPTED);
	}
	
	
 
	/**
	 * @param screenVO
	 * @return
	 */
	@PostMapping("/screen")
	public ResponseEntity<ScreenVO> addScreen(@RequestBody ScreenVO screenVO) {
		log.info("*************WfmUserModuleController*****addScreen**********Entry****");
		log.info("*************WfmUserModuleController*****addScreen******");
		
		try {
			screenVO =  wfmUserModuleService.addScreen(screenVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****addScreen**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****addScreen****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****addScreen*******Exit");
		return new ResponseEntity<ScreenVO>(screenVO, HttpStatus.ACCEPTED);
	}
	

	/**
	 * @param screenVO
	 * @return
	 */
	@PutMapping("/screen")
	public ResponseEntity<ScreenVO> updateScreen(@RequestBody ScreenVO screenVO) {
		log.info("*************WfmUserModuleController*****updateScreen**********Entry****");
		log.info("*************WfmUserModuleController*****updateScreen******");
		
		try {
			screenVO =  wfmUserModuleService.updateScreen(screenVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****updateScreen**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****updateScreen****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****updateScreen*******Exit");
		return new ResponseEntity<ScreenVO>(screenVO, HttpStatus.ACCEPTED);
	}
	

	/**
	 * @param moduleId
	 * @return
	 */
	@GetMapping("/screen/module/{moduleId}")
	public ResponseEntity<List<ScreenVO>> getScreensForAModule(@PathVariable Long moduleId) {
		log.info("*************WfmUserModuleController*****getScreensForAModule**********Entry****");
		log.info("*************WfmUserModuleController*****getScreensForAModule******");
		List<ScreenVO> screenVOS = null;
		try {
			screenVOS =  wfmUserModuleService.getScreensForAModule(moduleId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****getScreensForAModule**Exception occured*");
		}
		log.info("*************WfmUserModuleController*****getScreensForAModule*******Exit");
		return new ResponseEntity<List<ScreenVO>>(screenVOS, HttpStatus.ACCEPTED);
	}
	
		//GET - GetScreenById
	/**
	 * @param screenId
	 * @return
	 */
	@GetMapping("/screen/screenId/{screenId}")
	public ResponseEntity<ScreenVO> getScreenById(@PathVariable Long screenId) {
		log.info("*************WfmUserModuleController*****getScreenById**********Entry****");
		log.info("*************WfmUserModuleController*****getScreenById******");
		ScreenVO screenVO = null;
		try {
			screenVO =  wfmUserModuleService.getScreenById(screenId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****getScreenById**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeModuleById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****getScreenById*******Exit");
		return new ResponseEntity<ScreenVO>(screenVO, HttpStatus.ACCEPTED);
	}
				
	// DELETE  - removeScreen
	/**
	 * @param screenId
	 * @return
	 */
	@DeleteMapping("/screen/screenId/{screenId}")
	public ResponseEntity<MessageVO> removeScreenById(@PathVariable Long screenId) {
		log.info("*************WfmUserModuleController*****removeScreenById**********Entry****");
		log.info("*************WfmUserModuleController*****removeScreenById******");
		MessageVO messageVO = null;
		try {
			messageVO =  wfmUserModuleService.removeScreenById(screenId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****removeScreenById**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeScreenById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****removeScreenById*******Exit");
		return new ResponseEntity<MessageVO>(messageVO, HttpStatus.ACCEPTED);
	}
	
	// POST - addScreenAccess 
	/**
	 * @param screenAccessVO
	 * @return
	 */
	@PostMapping("/screenaccess")
	public ResponseEntity<ScreenAccessVO> addScreenAccess(@RequestBody ScreenAccessVO screenAccessVO) {
		log.info("*************WfmUserModuleController*****addScreenAccess**********Entry****");
		log.info("*************WfmUserModuleController*****addScreenAccess******");
		ScreenAccessVO screenAccessVo = null;
		try {
			screenAccessVO = wfmUserModuleService.addScreenAccess(screenAccessVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****addScreenAccess**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****addScreenAccess****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****addScreenAccess*******Exit");
		return new ResponseEntity<ScreenAccessVO>(screenAccessVO, HttpStatus.ACCEPTED);
	}
	
	//PUT  - updateScreenAccess
	/**
	 * @param screenAccessVO
	 * @return
	 */
	@PutMapping("/screenaccess")
	public ResponseEntity<ScreenAccessVO> updateScreenAccess(@RequestBody ScreenAccessVO screenAccessVO) {
		log.info("*************WfmUserModuleController*****updateScreenAccess**********Entry****");
		log.info("*************WfmUserModuleController*****updateScreenAccess******");
		ScreenAccessVO screenAccessVo = null;
		try {
			screenAccessVO = wfmUserModuleService.updateScreenAccess(screenAccessVO);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****updateScreenAccess**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeModuleById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****updateScreenAccess*******Exit");
		return new ResponseEntity<ScreenAccessVO>(screenAccessVO, HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * @param screenId
	 * @return
	 */
	@GetMapping("/screenaccess/screenId/{screenId}")
	public ResponseEntity<List<ScreenAccessVO>> getScreenAccessForAScreen(@PathVariable Long screenId) {
		log.info("*************WfmUserModuleController*****getScreenAccessForAScreen**********Entry****");
		log.info("*************WfmUserModuleController*****getScreenAccessForAScreen******");
		List<ScreenAccessVO> screenAccessVOs = null;
		try {
			screenAccessVOs = wfmUserModuleService.getScreenAccessForAScreen(screenId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****getScreenAccessForAScreen**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeModuleById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****getScreenAccessForAScreen*******Exit");
		return new ResponseEntity<List<ScreenAccessVO>>(screenAccessVOs, HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * @param screenAccessId
	 * @return
	 */
	@GetMapping("/screenaccess/screenAccessId/{screenAccessId}")
	public ResponseEntity<ScreenAccessVO> getScreenAccessById(@PathVariable Long screenAccessId) {
		log.info("*************WfmUserModuleController*****getScreenAccessById**********Entry****");
		log.info("*************WfmUserModuleController*****getScreenAccessById******");
		ScreenAccessVO screenAccessVO = null;
		try {
			screenAccessVO = wfmUserModuleService.getScreenAccessById(screenAccessId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****getScreenAccessById**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeModuleById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****getScreenAccessById*******Exit");
		return new ResponseEntity<ScreenAccessVO>(screenAccessVO, HttpStatus.ACCEPTED);
	}
					
	
	/**
	 * @param screenAccessId
	 * @return
	 */
	@DeleteMapping("/screenaccess/screenAccessId/{screenAccessId}")
	public ResponseEntity<MessageVO> removeScreenAccessById(@PathVariable Long screenAccessId) {
		log.info("*************WfmUserModuleController*****removeScreenAccessById**********Entry****");
		log.info("*************WfmUserModuleController*****removeScreenAccessById******");
		MessageVO messageVO = null;
		try {
			messageVO = wfmUserModuleService.removeScreenAccessById(screenAccessId);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmUserModuleController*****removeScreenAccessById**Exception occured*");
			throw new WfmUserException("Exception in WfmUserModuleController****removeScreenAccessById****"+ex.getMessage());
		}
		log.info("*************WfmUserModuleController*****removeScreenAccessById*******Exit");
		return new ResponseEntity<MessageVO>(messageVO, HttpStatus.ACCEPTED);
	}

	
}
