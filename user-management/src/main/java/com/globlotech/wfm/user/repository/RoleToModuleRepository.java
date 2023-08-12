package com.globlotech.wfm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.Module;
import com.globlotech.wfm.user.entity.RoleToModule;
import com.globlotech.wfm.user.entity.UserRole;

/**
 * @author Manikandan
 *
 */
@Repository
public interface RoleToModuleRepository extends JpaRepository<RoleToModule,Long>{
	
	@Query("select ur from Module m,UserRole ur,RoleToModule rtm where ur.userRoleId=rtm.roleId and rtm.moduleId=m.moduleId and rtm.moduleId=:moduleId")
	List<UserRole> getRolesForAModule(@Param("moduleId") Long moduleId);
	
	@Query("select m from Module m,UserRole ur,RoleToModule rtm where ur.userRoleId=rtm.roleId and rtm.moduleId=m.moduleId and rtm.roleId=:userRoleId")
	List<Module> getModulesForARole(@Param("userRoleId") Long userRoleId);

}
