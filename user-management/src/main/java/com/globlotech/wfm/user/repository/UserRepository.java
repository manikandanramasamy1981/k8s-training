package com.globlotech.wfm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.User;

/**
 * @author Manikandan
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("select u from User u where u.companyId=:companyId and u.userId=:userId")
	User getUserDetailsByCompanyCodeAndUserId(@Param("companyId")String companyId,@Param("userId") Long userId);
	
	@Query("select u from User u where u.companyId=:companyId")
	List<User> getAllUserDetailsForACompany(@Param("companyId")String companyId);
	
	@Query("select u from User u where u.userName=:userName")
	User findByUserName(@Param("userName") String userName);
	
	@Query("select u from User u where u.userName=:username and u.password=:password")
	User authenticateUser(@Param("username")String username ,@Param("password")String password);
	
}
