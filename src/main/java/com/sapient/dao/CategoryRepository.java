package com.sapient.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.model.Category;
import com.sapient.model.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
//	@Query("SELECT t FROM User t where t.password = ?1 AND t.email = ?2")
//	ArrayList<User> findAllByPassword(String password, String email);

	@Query("SELECT t FROM Category t where t.categoryName = ?1")
	ArrayList<Category> findByCategoryName(String categoryName);
}
