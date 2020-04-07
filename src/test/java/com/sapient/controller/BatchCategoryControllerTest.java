package com.sapient.controller;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.model.Category;
import com.sapient.service.BatchCategoryImpl;
import com.sapient.user_management.UserManagementApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)

public class BatchCategoryControllerTest {
	
	@Autowired
	private BatchCategoryController batchCategoryController;
	
	@MockBean	
	BatchCategoryImpl batchCategoryImpl;
	
	@Before
	public void setUp() {
		Category category = new Category();
		category.setCategoryName("Dummy Category");
		category.setDescription("Dummy Category Description");
		ArrayList<Category> list = new ArrayList<Category>();
		list.add(category);
		Mockito.when(batchCategoryImpl.getAllCategoriesOfBatchId(1)).thenReturn(list);
	}
	
	@Test
	public void getCategoryFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<Category> response = (ResponseEntity<Category>) batchCategoryController.getBatchCategoryById(1);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void getCategoryNotFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<Category> response = (ResponseEntity<Category>) batchCategoryController.getBatchCategoryById(2);
		Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}

}
