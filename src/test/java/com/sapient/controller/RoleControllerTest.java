package com.sapient.controller;

import static org.mockito.ArgumentMatchers.any;
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

import com.sapient.model.Role;
import com.sapient.service.RoleImpl;
import com.sapient.user_management.UserManagementApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)

public class RoleControllerTest {
	@Autowired
	private RoleController roleController;
	
	@MockBean
	private RoleImpl roleImpl;
	
	@Before
	public void setUp() {
		Role role = new Role();
		role.setRoleName("Dummy Role");
		ArrayList<Role> list = new ArrayList<Role>();
		list.add(role);
		Mockito.when(roleImpl.getRoleById(1)).thenReturn(role);
		Mockito.when(roleImpl.addNewRole(any(Role.class))).thenReturn("Prem");
		Mockito.when(roleImpl.deleteRole(role)).thenReturn("Role Deleted");
		Mockito.when(roleImpl.getAllRoles()).thenReturn(list);
	}
	

	@Test
	public void getRoleFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<Role> response = (ResponseEntity<Role>) roleController.getRoleById(1);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void getRoleNotFound() {
		@SuppressWarnings("unchecked")
		ResponseEntity<Role> response = (ResponseEntity<Role>) roleController.getRoleById(2);
		Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}
	
	
	@Test
	public void addRole() {
		Role role = new Role();
		role.setRoleName("Dummy Role");
		String string = (String) roleController.addNew(role);
		Assert.assertEquals("Prem",string);
	}
	
	@Test
	public void deleteRole() {
		Role role = new Role();
		role.setRoleName("Dummy Role");
		@SuppressWarnings("unchecked")
		ResponseEntity<String> response = (ResponseEntity<String>) roleController.deleteRole(role);
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void GetAll() {
		@SuppressWarnings("unchecked")
		ResponseEntity<ArrayList<Role>> response = (ResponseEntity<ArrayList<Role>>) roleController.getallRoles();
		Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	}
}
