package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.model.Institute;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Integer>{
//	@Query("SELECT t FROM User t where t.email = ?2")
//	ArrayList<User> findAllByPassword(String email);
}
