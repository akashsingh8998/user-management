package com.sapient.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.model.Batch;
import com.sapient.model.User;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer>{
//	@Query("SELECT t FROM User t where t.email = ?2")
//	ArrayList<User> findAllByPassword(String email);
}
