package com.sapient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.model.University;
import com.sapient.service.UniversityImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/university")
public class UniversityController {
	@Autowired
	UniversityImpl universityImpl;
	
	@PostMapping("/AdminAccess/addNewUniversity")
	public Object addNewUniversity(@Valid @RequestBody University university) {
		return universityImpl.addNewUniversity(university);
	}
}
