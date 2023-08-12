package com.globlotech.wfm.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WfmUserApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WfmUserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WfmUserApplication.class, args);
		log.info("WfmUserApplication Logger Started");
	}

}
