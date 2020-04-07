package com.sapient.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.BatchCategoryRepository;
import com.sapient.model.BatchCategory;
import com.sapient.model.Category;


@Service
public class BatchCategoryImpl {
	@Autowired
	BatchCategoryRepository batchCategoryRepository;

	public Integer addNewBatchCategory(BatchCategory batchCategory) {
		return batchCategoryRepository.save(batchCategory).getBatchCategoryId();
		
	}

	public ArrayList<Category> getAllCategoriesOfBatchId(Integer batchId) {
		ArrayList<BatchCategory> list = batchCategoryRepository.findByBatchId(batchId);
		ArrayList<Category> categoriesList = new ArrayList<>();
		for (BatchCategory batchCategory : list) {
			categoriesList.add(batchCategory.getCategory());
		}
		return categoriesList;
	}
	
	
	
}
