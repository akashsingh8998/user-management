//package com.sapient.controller;
//
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.sapient.model.Category;
//import com.sapient.service.CategoryImpl;
//import com.sapient.user_management.UserManagementApplication;
//
// 
//
//@RunWith(SpringRunner.class)
////@SpringBootTest(classes = UserManagementApplication.class)
//@SpringBootTest(webEnvironment = WebEnvironment.NONE)
//@ContextConfiguration(classes=UserManagementApplication.class)
//
//
//public class CategoryControllerTest {
//	
//	@Autowired
//	private CategoryController categoryController;
//	
//	@MockBean
//	private CategoryImpl categoryImpl;
//	
//	@Before
//	public void setUp() {
//		Category category = new Category();
//		category.setCategoryName("Dummy Category");
//		ArrayList<Category> list = new ArrayList<Category>();
//		list.add(category);
//		Mockito.when(categoryImpl.getCategoryById(1)).thenReturn(category);
//		Mockito.when(categoryImpl.addNewCategory(any(Category.class))).thenReturn(1);
//		Mockito.when(categoryImpl.deleteCategory(category)).thenReturn("Category Deleted");
//		Mockito.when(categoryImpl.getAllCategories()).thenReturn(list);
//	}
//	
//
//	@Test
//	public void getCategoryFound() {
//		@SuppressWarnings("unchecked")
//		ResponseEntity<Category> response = (ResponseEntity<Category>) categoryController.getCategoryById(1);
//		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
//	}
//	
//	@Test
//	public void getCategoryNotFound() {
//		@SuppressWarnings("unchecked")
//		ResponseEntity<Category> response = (ResponseEntity<Category>) categoryController.getCategoryById(2);
//		Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//	}
//	
//	
//	@Test
//	public void addCategory() {
//		Category category = new Category();
//		category.setCategoryName("Dummy Category");
//		String string = (String) categoryController.addNew(category).toString();
//		Assert.assertEquals("1",string);
//	}
//	
//	@Test
//	public void deleteCategory() {
//		Category category = new Category();
//		category.setCategoryName("Dummy Category");
//		@SuppressWarnings("unchecked")
//		ResponseEntity<String> response = (ResponseEntity<String>) categoryController.deleteCategory(category);
//		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
//	}
//	
//	@Test
//	public void GetAll() {
//		@SuppressWarnings("unchecked")
//		ResponseEntity<ArrayList<Category>> response = (ResponseEntity<ArrayList<Category>>) categoryController.getallCategories();
//		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
//	}
//
//}
