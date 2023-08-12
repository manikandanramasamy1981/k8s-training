package com.globlotech.wfm.user.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.globlotech.wfm.user.service.CustomUserDetailsService;
import com.globlotech.wfm.user.service.WfmLoginService;
import com.globlotech.wfm.user.util.JwtRequestFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(SpringSecurityConfig.class);

	/*
	 * @Autowired DataSource dataSource;
	 */
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception  {
		//super.configure(auth);
		
		auth.userDetailsService(customUserDetailsService);
		
		log.info( "*************SpringSecurityConfig*****configure(AuthenticationManagerBuilder auth)*************authentication******");
		
		/* For JDBC authentication */
		//auth.jdbcAuthentication()
		//.dataSource(dataSource).
		//usersByUsernameQuery("select username,password,enabled from users where username=?")
		//.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
		
		/*.withDefaultSchema()
		.withUser(
				User.withUsername("mani")
				.password("test")
				.roles("manager"))
		.withUser(User.withUsername("bala")
				.password("test")
				.roles("manager")
				) */

		;
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { //
	 * TODO Auto-generated method stub http.authorizeHttpRequests().
	 * //antMatchers("admin").hasRole("ADMIN")
	 * //.antMatchers("/user").hasAnyRole("ADMIN","USER").
	 * antMatchers("/").permitAll(). and().formLogin();
	 * 
	 * }
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();//new BCryptPasswordEncoder();
	}
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * http.authorizeHttpRequests((authz)->authz.anyRequest().authenticated())
	 * .httpBasic(); return http.build(); }
	 */
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
			
			/*
			 * http .authorizeRequests() .anyRequest().authenticated() .and() .formLogin()
			 * .and() .httpBasic();
			 */	 
		
		log.info( "*************SpringSecurityConfig*****configure(AuthenticationManagerBuilder auth)*************authorization******");
		/*
		 * http .requiresChannel(channel -> channel.anyRequest().requiresSecure())
		 * .authorizeRequests(authorize -> authorize.anyRequest().permitAll()) .build();
		 */
		http.csrf().disable()
		  .authorizeRequests().
		  antMatchers("/login/v1/authenticateUser").permitAll().
		  //.hasAnyRole("SUPERVISOR").
		  //antMatchers("/swagger-ui/index.html")
		  //.hasRole("SUPERVISOR")
		  //.antMatchers("/swagger/*").hasAnyRole("SUPERVISOR","ADMIN").
		  antMatchers("/login/v1/refreshtoken").permitAll().
		  antMatchers("/login/v1/validatetoken").permitAll().
		  //antMatchers("/user/companyCode/*").hasRole("SUPERVISOR").
		  //antMatchers("bala").hasAnyRole("SUPERVISOR","ADMIN").
		   //antMatchers("/").permitAll()
		  anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		   //.and().formLogin();
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		   
		   
		
	  }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

		/*
		 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
		 * throws Exception {
		 * 
		 * }
		 */	
}
