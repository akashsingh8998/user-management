package com.sapient.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT t FROM User t where t.firstName LIKE CONCAT('%',?1,'%') OR t.lastName LIKE CONCAT('%',?1,'%') OR  t.email LIKE CONCAT('%',?1,'%')")
	ArrayList<User> findAllBySearchQuery(String searchQuery);
	
	@Query("SELECT t FROM User t where t.mobile = ?1")
	ArrayList<User> findAllByMobile(long mobile);

//	@Query("SELECT t FROM User t where t.password = ?1 AND t.email = ?2")
//	ArrayList<User> findAllByPassword(String password, String email);
	
	@Query("SELECT t FROM User t where t.email = ?1")
	ArrayList<User> findByEmail(String email);

	@Query("SELECT t FROM User t where t.batch.batchId = ?1")
	ArrayList<User> findUsersByBatch(Integer batchId);

	@Query("SELECT t FROM User t where t.batch.batchId = ?1 AND t.category.categoryId=?2")
	ArrayList<User> getAllUsersByBatchIdAndCategoryId(Integer batchId, Integer categoryId);

	
}
