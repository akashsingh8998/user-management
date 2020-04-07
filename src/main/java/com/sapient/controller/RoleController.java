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

import com.sapient.exception.RoleNotFoundException;
import com.sapient.model.Role;
import com.sapient.service.RoleImpl;
import com.sapient.service.UserImpl;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

	@Autowired
	RoleImpl roleImpl;

	@Autowired
	UserImpl userImpl;
	
	@GetMapping("/AdminAccess/byId/{id}")
	public Object getRoleById(@PathVariable(value = "id") Integer id) {
		try {
			Role c = roleImpl.getRoleById(id);
			log.info("Role returned with details {}", c);
			if (c == null) {
				RoleNotFoundException RoleNotFoundException = new RoleNotFoundException("Role not found");

				return new ResponseEntity<String>(RoleNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Role>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

	}

	@PostMapping("/AdminAccess/addNewRole")
	public Object addNew(@RequestBody Role role) {
		return roleImpl.addNewRole(role);

	}

	@DeleteMapping("/AdminAccess/deleteRole")
	public Object deleteRole(@Valid @RequestBody Role role) {
		String message = roleImpl.deleteRole(role);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping("/AdminAccess/allRoles")
	public Object getallRoles() {
		ArrayList<Role> listOfRoles = roleImpl.getAllRoles();
		return new ResponseEntity<ArrayList<Role>>(listOfRoles, HttpStatus.OK);

	}
}
