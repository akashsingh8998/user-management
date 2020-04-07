package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.UserRoleRepository;
import com.sapient.model.UserRole;


@Service
public class UserRoleImpl {
	@Autowired
	UserRoleRepository userRoleRepository;

	public Integer addNewUserRole(UserRole userRole) {
		return userRoleRepository.save(userRole).getUserRoleId();
		
	}

//	public ArrayList<Category> getAllCategoriesOfBatchId(Integer batchId) {
//		ArrayList<BatchCategory> list = batchCategoryRepository.findByBatchId(batchId);
//		ArrayList<Category> categoriesList = new ArrayList<>();
//		for (BatchCategory batchCategory : list) {
//			categoriesList.add(batchCategory.getCategory());
//		}
//		return categoriesList;
//	}
	
	
	
}
