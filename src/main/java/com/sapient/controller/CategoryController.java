package com.sapient.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.exception.CategoryNotFoundException;
import com.sapient.model.Category;
import com.sapient.service.CategoryImpl;
import com.sapient.service.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

	@Autowired
	CategoryImpl CategoryImpl;

	@Autowired
	UserImpl userImpl;

	@GetMapping("/AdminAccess/byId/{id}")
	public Object getCategoryById(@PathVariable(value = "id") Integer id) {
		try {
			Category c = CategoryImpl.getCategoryById(id);
			log.info("Category returned with details {}", c);
			if (c == null) {
				CategoryNotFoundException CategoryNotFoundException = new CategoryNotFoundException(
						"Category not found");

				return new ResponseEntity<String>(CategoryNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Category>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

	}

	@PostMapping("/AdminAccess/addNewCategory")
	public Object addNew(@Valid @RequestBody Category category) {
		return CategoryImpl.addNewCategory(category);

	}

	@DeleteMapping("/AdminAccess/deleteCategory")
	public Object deleteCategory(@Valid @RequestBody Category category) {
		String message = CategoryImpl.deleteCategory(category);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping("/AdminAccess/allCategories")
	public Object getallCategories() {
		ArrayList<Category> listOfCategories = CategoryImpl.getAllCategories();
		return new ResponseEntity<ArrayList<Category>>(listOfCategories, HttpStatus.OK);

	}
}
