package com.globlotech.wfm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
	
	@Query("select s from Screen s where s.erfModuleId=:moduleId")
	List<Screen> findScreensForAModule(@Param("moduleId")Long moduleId);

}
