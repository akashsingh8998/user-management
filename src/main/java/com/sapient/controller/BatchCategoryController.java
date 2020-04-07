package com.sapient.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.exception.CategoryNotFoundException;
import com.sapient.model.Category;
import com.sapient.service.BatchCategoryImpl;
import com.sapient.service.UserImpl;


@RestController
@RequestMapping("/api/v1/batchCategory")
public class BatchCategoryController {
	@Autowired
	UserImpl userImpl;

	@Autowired
	BatchCategoryImpl batchCategoryImpl;

	@GetMapping("/AdminAccess/byId/{id}")
	public Object getBatchCategoryById(@PathVariable(value = "id") Integer id) {

		ArrayList<Category> categoriesList = batchCategoryImpl.getAllCategoriesOfBatchId(id);
		if (categoriesList.isEmpty()) {
			CategoryNotFoundException CategoryNotFoundException = new CategoryNotFoundException("Categories not found");

			return new ResponseEntity<String>(CategoryNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ArrayList<Category>>(categoriesList, HttpStatus.OK);

	}

}
