package com.globlotech.wfm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globlotech.wfm.user.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

}
