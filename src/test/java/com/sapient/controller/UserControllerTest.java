package com.sapient.controller;

import static org.mockito.Mockito.*;
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

import com.sapient.model.User;
import com.sapient.service.UserImpl;
import com.sapient.user_management.UserManagementApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)


public class UserControllerTest {
	
	@Autowired
	private UserController userController;
	
	@MockBean
	private UserImpl userImpl;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setFirstName("Prem");
		user.setLastName("vardhan");
		ArrayList<User> list = new ArrayList<User>();
		list.add(user);
		Mockito.when(userImpl.getUserById(1)).thenReturn(user);
//		Mockito.when(userImpl.addNewUser(any(UserRole.class))).thenReturn("Prem");
		Mockito.when(userImpl.deleteUser(user)).thenReturn("User Deleted");
		Mockito.when(userImpl.getAllUsers()).thenReturn(list);
	}
	

	@Test
	public void getUserFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<User> response = (ResponseEntity<User>) userController.getUserById(1);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void getUserNotFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<User> response = (ResponseEntity<User>) userController.getUserById(2);
		Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}
	
//	@Test
//	public void addUser() {
//		User user = new User();
//		user.setFirstName("Prem");
//		user.setLastName("vardhan");
//		String string = (String) userController.addNew(user);
//		Assert.assertEquals("Prem",string);
//	}
	
	@Test
	public void deleteUser() {
		User user = new User();
		user.setFirstName("Prem");
		user.setLastName("vardhan");
		@SuppressWarnings("unchecked")
		ResponseEntity<String> response = (ResponseEntity<String>) userController.deleteUser(user);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void GetAll() {
		@SuppressWarnings("unchecked")
		ResponseEntity<ArrayList<User>> response = (ResponseEntity<ArrayList<User>>) userController.getallUsers();
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}

}
