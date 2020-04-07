package com.sapient.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{

	@Query("SELECT t FROM UserRole t where t.user.userId = ?1")
	ArrayList<UserRole> findAllUserRoleWithUserId(Integer userId);

	@Query("SELECT t FROM UserRole t where t.role.roleName = ?1")
	ArrayList<UserRole> findAllUserRoleWithRoleName(String roleName);
	
}
