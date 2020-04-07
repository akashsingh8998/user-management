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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.model.User;
import com.sapient.service.UserImpl;
import com.sapient.user_management.UserManagementApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)


public class SearchControllerTest {
	
	@Autowired 
	private SearchController searchController;
	
	@MockBean
	private UserImpl userImpl;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setFirstName("Prem");
		user.setLastName("vardhan");
		ArrayList<User> list = new ArrayList<User>();
		list.add(user);
		Mockito.when(userImpl.searchUserByQuery("Prem")).thenReturn(list);
	}
	
	@Test
	public void findByQuery(){
		@SuppressWarnings("unchecked")
		ArrayList<User> response =  (ArrayList<User>) searchController.getUserByQuery("Prem");
		Assert.assertEquals("Prem",response.get(0).getFirstName());

	}

}
