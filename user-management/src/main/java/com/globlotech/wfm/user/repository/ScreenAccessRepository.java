package com.globlotech.wfm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.ScreenAccess;

/**
 * @author Manikandan
 *
 */
@Repository
public interface ScreenAccessRepository extends JpaRepository<ScreenAccess,Long> {

	@Query("select sa from ScreenAccess sa where sa.screenId=:screenId")
	List<ScreenAccess> findScreenAccessForAScreen(@Param("screenId") Long screenId);
	
}
