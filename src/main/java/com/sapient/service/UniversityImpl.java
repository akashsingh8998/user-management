package com.sapient.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.UniversityRepository;
import com.sapient.model.University;

@Service
public class UniversityImpl {
	
	@Autowired
	UniversityRepository universityRepository;

	public University addNewUniversity(@Valid University university) {
		return universityRepository.save(university);
	} 
}
