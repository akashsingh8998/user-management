package com.sapient.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sapient.service.BulkUploadImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/bulkUpload")
public class BulkUploadController {
	@Autowired
	private BulkUploadImpl bulkUploadImpl;

	@PostMapping("/AdminAccess/uploadFile")
	public ArrayList bulkUpload(@RequestBody MultipartFile uploadFile) {
		return bulkUploadImpl.bulkUpload(uploadFile);
	}

}
