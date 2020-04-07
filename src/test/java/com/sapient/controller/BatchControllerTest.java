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

import com.sapient.model.Batch;
import com.sapient.model.Category;
import com.sapient.service.BatchCategoryImpl;
import com.sapient.service.BatchImpl;
import com.sapient.service.CategoryImpl;
import com.sapient.user_management.UserManagementApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)

public class BatchControllerTest {
	
	@Autowired
	private BatchController batchController;
	
	@MockBean
	BatchImpl batchImpl;

	@MockBean
	CategoryImpl CategoryImpl;

	@MockBean
	BatchCategoryImpl batchCategoryImpl;
	
	@Before
	public void setUp() {
		Batch batch = new Batch();
		batch.setBatchName("Dummy Batch");
		batch.setDescription("Dummy Batch description");
		ArrayList<Batch> list = new ArrayList<Batch>();
		list.add(batch);
		Mockito.when(batchImpl.getBatchById(1)).thenReturn(batch);
		Mockito.when(batchImpl.deleteBatch(batch)).thenReturn("Batch Deleted");
		Mockito.when(batchImpl.getAllBatches()).thenReturn(list);
	}
	
	@Test
	public void getBatchFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<Batch> response = (ResponseEntity<Batch>) batchController.getBatchById(1);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void getBatchNotFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<Batch> response = (ResponseEntity<Batch>) batchController.getBatchById(2);
		Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}
	
	@Test
	public void deleteRole() {
		Batch batch = new Batch();
		batch.setBatchName("Dummy Batch");
		batch.setDescription("Dummy Batch description");
		@SuppressWarnings("unchecked")
		ResponseEntity<String> response = (ResponseEntity<String>) batchController.deleteBatch(batch);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void GetAll() {
		@SuppressWarnings("unchecked")
		ResponseEntity<ArrayList<Batch>> response = (ResponseEntity<ArrayList<Batch>>) batchController.getallBatches();
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void gettersOfBatchCategoryWithLoggedIn() {
		Batch batches = new Batch();
		batches.setBatchName("Dummy Batch");
		batches.setBatchId(1);
		batches.setDescription("Dummy Batch Description");
		BatchCategoryWithLoggedIn batch = new BatchCategoryWithLoggedIn();
		batch.setBatch(batches);
		batch.setCategory(null);
		Assert.assertEquals("Dummy Batch", batch.getBatch().getBatchName());
		Assert.assertEquals("1", batch.getBatch().getBatchId().toString());
		Assert.assertEquals("Dummy Batch Description", batch.getBatch().getDescription());
	}
	
	@Test
	public void settersOfBatchCategoryWithLoggedIn() {
		Batch batches = new Batch();
		batches.setBatchName("Dummy Batch");
		Category[] category = new Category[1];
		category[0] = new Category();
		category[0].setCategoryName("Dummy Category");
		category[0].setCategoryId(1);
		category[0].setDescription("Dummy Category Description");
		BatchCategoryWithLoggedIn batch = new BatchCategoryWithLoggedIn();
		batch.setBatch(batches);
		batch.setCategory(category);
		Assert.assertEquals("Dummy Category", batch.getCategory()[0].getCategoryName());
	}


}
