package com.globlotech.wfm.user.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.globlotech.wfm.user.entity.RefreshToken;
import com.globlotech.wfm.user.exception.TokenRefreshException;
import com.globlotech.wfm.user.service.CustomUserDetailsService;
import com.globlotech.wfm.user.service.WfmLoginService;
import com.globlotech.wfm.user.service.WfmRefreshTokenService;
import com.globlotech.wfm.user.service.WfmUserService;
import com.globlotech.wfm.user.util.JwtUtil;
import com.globlotech.wfm.user.vo.AuthenticationResponseVO;
import com.globlotech.wfm.user.vo.LoginCredentialsVO;
import com.globlotech.wfm.user.vo.RefreshTokenRequestVO;
import com.globlotech.wfm.user.vo.TokenRefreshResponseVO;
import com.globlotech.wfm.user.vo.UserVO;

/**
 * @author Manikandan
 *
 */
@Validated
@RestController
@RequestMapping("/login/v1")
public class WfmLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(WfmLoginController.class);
	
	@Autowired
	WfmLoginService wfmLoginService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	WfmRefreshTokenService refreshTokenService;
	
	@Autowired
	WfmUserService wfmUserService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/authenticateUser")
	public ResponseEntity<AuthenticationResponseVO> authenticateUser(@RequestBody LoginCredentialsVO loginCredentialsVO) throws Exception {
		log.info(
				"*************WfmLoginController*****authenticateUser*********Entry**********");
		log.info("*************WfmuserController*****authenticateUser****" );
		
		AuthenticationResponseVO vo = new AuthenticationResponseVO();
		String userName = loginCredentialsVO.getUserName();
		String password = loginCredentialsVO.getPassword();
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userName, password));
		
		} catch(BadCredentialsException ex) {
			throw new Exception("Incorrect Username and password ",ex);
		}
		
		//boolean isCredentialsValid = false;
		UserDetails userDetails ;
		
		try {
			userDetails =userDetailsService.loadUserByUsername(loginCredentialsVO.getUserName()); //wfmLoginService.authenticateUser(loginCredentialsVO);
			//final String jwt =jwtUtil.generateToken(userDetails);
			final String jwt = jwtUtil.generateTokenFromUsername(userName);
			vo.setJwt(jwt);
			vo.setUserName(userName);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("*************WfmuserController*****getAllUsersForACompany**Exception occured*");
		}
		UserVO userVo = wfmUserService.getUserByUserName(loginCredentialsVO.getUserName());
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userVo.getUserId());
		vo.setRefreshToken(refreshToken.getToken());
		log.info("*************WfmuserController*****getAlluserRequest*******Exit");
		return new ResponseEntity<AuthenticationResponseVO>(vo, HttpStatus.ACCEPTED);
	}

  @PostMapping("/validatetoken")
  public ResponseEntity<Boolean> validateToken(@RequestBody String token){
	  log.info("*************WfmloginController*****validateToken*******Exit");
	  boolean isValid = false;
	  String userName = jwtUtil.getUsernameFromToken(token);
	  UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userName);
		if(jwtUtil.validateToken(token, userDetails)) {
			isValid=true;
		}		
	  log.info("*************WfmloginController*****validateToken*******Exit");
	  return new ResponseEntity<Boolean>(isValid , HttpStatus.ACCEPTED);
  }
  
	/*
	 * @PostMapping("/refreshtoken") public ResponseEntity<String>
	 * refreshToken(@RequestBody String token){
	 * log.info("*************WfmloginController*****refreshToken*******Exit");
	 * String newToken = ""; String userName = jwtUtils.getUsernameFromToken(token);
	 * UserDetails userDetails =
	 * this.customUserDetailsService.loadUserByUsername(userName); newToken =
	 * jwtUtils.generateToken(userDetails);
	 * log.info("*************WfmloginController*****refreshToken*******Exit");
	 * return new ResponseEntity<String>(newToken,HttpStatus.ACCEPTED); }
	 */
  
  @PostMapping("/createrefreshtokenForAUser") 
  public ResponseEntity<String> createRefreshTokenForAUser(@RequestBody String userName){
	  log.info("*************WfmloginController*****createRefreshTokenForAUser*******Exit");
	  UserVO userVo = wfmUserService.getUserByUserName(userName);
	  RefreshToken refreshToken = refreshTokenService.createRefreshToken(userVo.getUserId());
	  log.info("*************WfmloginController*****createRefreshTokenForAUser*******Exit");
	  return new ResponseEntity<String>(refreshToken.getToken(),HttpStatus.ACCEPTED);
  }
  
  @PostMapping("/refreshtoken")
  public ResponseEntity<?> refreshtoken(@Valid @RequestBody RefreshTokenRequestVO request) {
    
	String requestRefreshToken = request.getRefreshToken();

    return refreshTokenService.findByToken(requestRefreshToken)
        .map(refreshTokenService::verifyExpiration)
        .map(RefreshToken::getUser)
        .map(user -> {
          String token = jwtUtil.generateTokenFromUsername(user.getUserName()); 
          return ResponseEntity.ok(new TokenRefreshResponseVO(token, requestRefreshToken));
        })
        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
            "Refresh token is not in database!"));
  }

}