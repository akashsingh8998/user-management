package com.sapient.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.exception.UserNotFoundException;
import com.sapient.model.Category;
import com.sapient.model.Role;
import com.sapient.model.User;
import com.sapient.model.UserRole;
import com.sapient.service.BatchCategoryImpl;
import com.sapient.service.RoleImpl;
import com.sapient.service.UserImpl;
import com.sapient.service.UserRoleImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserImpl userImpl;
	
	@Autowired
	RoleImpl roleImpl;
	
	@Autowired
	UserRoleImpl userRoleImpl;
	
	@Autowired
	BatchCategoryImpl batchCategoryImpl;
	
	@GetMapping("/UserAccess/byId/{id}")
	public Object getUserById(@PathVariable(value = "id") Integer id) {
		try {
			User c = userImpl.getUserById(id);
			log.info("User returned with details {}", c);
			if (c == null) {
				UserNotFoundException userNotFoundException = new UserNotFoundException("User not found");

				return new ResponseEntity<String>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<User>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

	}


	@PostMapping("/AdminAccess/addNewUser")
	public Object addNew(@Valid @RequestBody UserRoleObject userRoleObject) {
			Integer userId = userImpl.addNewUser(userRoleObject.getUser());
			Integer[] roles = userRoleObject.getRoles();
//			Integer batchId = batchImpl.addNewBatch(batch);
//			Batch updatedBatch = batchImpl.getBatchById(batchId);
			User updatedUser = userImpl.getUserById(userId);
			ArrayList<Integer> userRoleIdlist = new ArrayList<>();
			for (Integer roleID : roles) {
//				Integer updatedCategory = null;
				Role role = roleImpl.getRoleById(roleID);

				
//				Category updatedCategoryObject = CategoryImpl.getCategoryById(updatedCategory);
				UserRole userRole = new UserRole();
				userRole.setUser(updatedUser);
				userRole.setRole(role);
				Integer userRoleId = userRoleImpl.addNewUserRole(userRole);
				userRoleIdlist.add(userRoleId);
			}
			return new ResponseEntity<ArrayList<Integer>>(userRoleIdlist, HttpStatus.OK);
	}
	
	@PostMapping("/AdminAccess/updateUser")
	public Object updateUser(@Valid @RequestBody UserRoleObject userRoleObject) {
		Integer userId = userImpl.addNewUser(userRoleObject.getUser());
		Integer[] roles = userRoleObject.getRoles();
		User updatedUser = userImpl.getUserById(userId);
		ArrayList<Integer> userRoleIdlist = new ArrayList<>();
		for (Integer roleID : roles) {
			Role role = roleImpl.getRoleById(roleID);
			UserRole userRole = new UserRole();
			userRole.setUser(updatedUser);
			userRole.setRole(role);
			Integer userRoleId = userRoleImpl.addNewUserRole(userRole);
			userRoleIdlist.add(userRoleId);
		}
		return new ResponseEntity<ArrayList<Integer>>(userRoleIdlist, HttpStatus.OK);
	}

	@DeleteMapping("/AdminAccess/deleteUser")
	public Object deleteUser(@Valid @RequestBody User user) {
		String message = userImpl.deleteUser(user);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping("/UserAccess/allUsers")
	public Object getallUsers() {
		ArrayList<User> listOfUsers = userImpl.getAllUsers();
		return new ResponseEntity<ArrayList<User>>(listOfUsers, HttpStatus.OK);
	}
	
	@GetMapping("/AdminAccess/UsersByBatchId/{batchId}")
	public Object getallUsersByBatchId(@PathVariable(value="batchId") Integer batchId) {
		ArrayList<User> listOfUsers = userImpl.getAllUsersByBatchId(batchId);
		return new ResponseEntity<ArrayList<User>>(listOfUsers, HttpStatus.OK);
	}
	
	@GetMapping("/AdminAccess/UsersByBatchAndSpecificCategory/{batchId}/{categoryId}")
	public Object getallUsersByCategoryId(@PathVariable(value="batchId") Integer batchId,@PathVariable(value="categoryId") Integer categoryId) {
		ArrayList<User> listOfUsers = userImpl.getAllUsersByBatchIdAndCategoryId(batchId,categoryId);
		return new ResponseEntity<ArrayList<User>>(listOfUsers, HttpStatus.OK);
	}

	@GetMapping("/AdminAccess/UserByEmail/{email}")
	public User getUserByEmail(@PathVariable(value="email")String email) {
		return userImpl.getUserByEmail(email);
	}	
	
	@GetMapping("/AdminAccess/UserWithAllRolesByEmail/{email}")
	public ArrayList<Role> getUserWithAllRoles(@PathVariable(value="email")String email) {
		return userImpl.getUserWithAllRoles(email);
	}
	
	@GetMapping("/AdminAccess/UserByRole/{roleName}")
	public ArrayList<User> getUserByRole(@PathVariable(value="roleName")String roleName) {
		return userImpl.getUserByRole(roleName);
	}
}


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class UserRoleObject {
	private Integer roles[];
	private User user;
}
