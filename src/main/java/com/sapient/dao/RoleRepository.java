package com.sapient.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.model.Role;
import com.sapient.model.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
//	@Query("SELECT t FROM User t where t.password = ?1 AND t.email = ?2")
//	ArrayList<User> findAllByPassword(String password, String email);
}
