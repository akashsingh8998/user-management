package com.sapient.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.InstituteRepository;
import com.sapient.model.Institute;


@Service
public class InstituteImpl {
	
	@Autowired
	InstituteRepository instituteRepository;

	public Institute addNewInstitute(@Valid Institute institute) {
		return instituteRepository.save(institute);
	}

	public Institute getInstituteById(Integer id) {
//		
		return instituteRepository.findById(id).orElseThrow(null);
	}

	
}
