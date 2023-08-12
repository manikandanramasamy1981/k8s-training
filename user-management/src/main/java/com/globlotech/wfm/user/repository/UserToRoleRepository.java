package com.globlotech.wfm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.User;
import com.globlotech.wfm.user.entity.UserRole;
import com.globlotech.wfm.user.entity.UserToRole;

@Repository
public interface UserToRoleRepository extends JpaRepository<UserToRole,Long> {
 
	@Query("select ur from User u,UserRole ur,UserToRole utr where utr.userId=u.userId and ur.userRoleId=utr.userRoleId and utr.userId=:userId")
	List<UserRole> getUserRolesForAUser(@Param("userId") Long userId);
	
	@Query("select u from User u,UserRole ur,UserToRole utr where utr.userRoleId=ur.userRoleId and utr.userId = u.userId and utr.userRoleId=:userRoleId")
	List<User> getUsersForAUserRole(@Param("userRoleId") Long userRoleId);
	
	
}
