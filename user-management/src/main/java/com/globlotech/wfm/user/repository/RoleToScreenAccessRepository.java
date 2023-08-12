package com.globlotech.wfm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.RoleToScreenAccess;
import com.globlotech.wfm.user.entity.ScreenAccess;
import com.globlotech.wfm.user.entity.UserRole;

/**
 * @author Manikandan
 *
 */
@Repository
public interface RoleToScreenAccessRepository extends JpaRepository<RoleToScreenAccess,Long> {
	
	@Query("select sa from ScreenAccess sa,UserRole ur,RoleToScreenAccess rtsa where sa.screenAccessId=rtsa.erfScreenAccessId and ur.userRoleId=rtsa.erfRoleId and rtsa.erfRoleId=:userRoleId")
	List<ScreenAccess> getScreenAccessesForARole(@Param("userRoleId") Long userRoleId);
	
	@Query("select ur from ScreenAccess sa,UserRole ur,RoleToScreenAccess rtsa where sa.screenAccessId=rtsa.erfScreenAccessId and ur.userRoleId=rtsa.erfRoleId and rtsa.erfScreenAccessId=:screenAccessId")
	List<UserRole> getUserRolesForScreenAccess(@Param("screenAccessId") Long screenAccessId);
	

}
