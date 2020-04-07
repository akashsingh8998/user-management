package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sapient.service.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

	@Autowired
	UserImpl userImpl;

	@GetMapping("/AdminAccess/{searchQuery}")
	public Object getUserByQuery(@PathVariable(value = "searchQuery") String searchQuery)
	{
		try {
			return userImpl.searchUserByQuery(searchQuery);

		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

	}

}
