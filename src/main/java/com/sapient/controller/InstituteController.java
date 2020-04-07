package com.sapient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.model.Institute;
import com.sapient.service.InstituteImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/institute")
public class InstituteController {
	@Autowired
	InstituteImpl instituteImpl;
	
	@PostMapping("/AdminAccess/addNewInstitute")
	public Institute addNewUniversity(@Valid @RequestBody Institute institute) {
		return instituteImpl.addNewInstitute(institute);
	}
	
	@GetMapping("/AdminAccess/getInstitute/{id}")
	public Institute getInstitute(@PathVariable(value="id") Integer id) {
		return instituteImpl.getInstituteById(id);
	}
}
