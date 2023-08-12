package com.globlotech.wfm.user.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Manikandan
 *
 */
@Configuration
@EnableSwagger2
public class WfmUserSwagger {
	
	private static final Logger log = LoggerFactory.getLogger(WfmUserSwagger.class);
	
	    @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(metaData());
	    }
	    
	    private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "WfmUserSwagger REST API",
	                "WfmUserSwagger REST API for WorkForceManagementSystem",
	                "Version 1.0",
	                "Terms of service",
	                "APIs to manage(add/update/delete) user , modules",
	                "APIs to manage(add/update/delete) User Roles ",
	                "");
	        log.info("WfmuserSwagger ----- metadata");
	        return apiInfo;
	    }
}
