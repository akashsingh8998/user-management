package com.sapient.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.model.BatchCategory;

@Repository
public interface BatchCategoryRepository extends JpaRepository<BatchCategory, Integer>{

	@Query("SELECT t FROM BatchCategory t where t.batch.batchId = ?1")
	ArrayList<BatchCategory> findByBatchId(Integer batchId);
	
}
