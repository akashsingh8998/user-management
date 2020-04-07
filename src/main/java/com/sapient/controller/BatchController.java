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

import com.sapient.exception.BatchNotFoundException;
import com.sapient.model.Batch;
import com.sapient.model.BatchCategory;
import com.sapient.model.Category;
import com.sapient.service.BatchCategoryImpl;
import com.sapient.service.BatchImpl;
import com.sapient.service.CategoryImpl;
import com.sapient.service.UserImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/batch")
public class BatchController {

	@Autowired
	BatchImpl batchImpl;

	@Autowired
	UserImpl userImpl;

	@Autowired
	CategoryImpl CategoryImpl;

	@Autowired
	BatchCategoryImpl batchCategoryImpl;

	@GetMapping("/AdminAccess/byId/{id}")
	public Object getBatchById(@PathVariable(value = "id") Integer id) {
		try {
			Batch c = batchImpl.getBatchById(id);
			log.info("Batch returned with details {}", c);
			if (c == null) {
				BatchNotFoundException BatchNotFoundException = new BatchNotFoundException("Batch not found");

				return new ResponseEntity<String>(BatchNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Batch>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

	}


	@PostMapping("/AdminAccess/addNewBatchWithCategories")
	public Object addNew(@Valid @RequestBody BatchCategoryWithLoggedIn request) {

		Batch batch = (Batch) request.getBatch();
		Category[] categories = request.getCategory();
		ArrayList<Integer> batchCategoryIdlist = new ArrayList<Integer>();
		Integer batchId = batchImpl.addNewBatch(batch);
		Batch updatedBatch = batchImpl.getBatchById(batchId);
		for (Category category : categories) {
			Integer updatedCategory = null;
			if (!CategoryImpl.isCategoryExists(category)) {
				updatedCategory = CategoryImpl.addNewCategory(category);
			} else {
				updatedCategory = CategoryImpl.getCategoryByName(category);

			}
			Category updatedCategoryObject = CategoryImpl.getCategoryById(updatedCategory);
			BatchCategory batchCategory = new BatchCategory();
			batchCategory.setBatch(updatedBatch);
			batchCategory.setCategory(updatedCategoryObject);
			Integer batchCategoryId = batchCategoryImpl.addNewBatchCategory(batchCategory);
			batchCategoryIdlist.add(batchCategoryId);
		}
		return new ResponseEntity<ArrayList<Integer>>(batchCategoryIdlist, HttpStatus.OK);

	}

	@DeleteMapping("/AdminAccess/deleteBatch")
	public Object deleteBatch(@Valid @RequestBody Batch request) {
		String message = batchImpl.deleteBatch(request);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping("/AdminAccess/allBatches")
	public Object getallBatches() {
		ArrayList<Batch> listOfBatches = batchImpl.getAllBatches();
		return new ResponseEntity<ArrayList<Batch>>(listOfBatches, HttpStatus.OK);

	}
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class BatchCategoryWithLoggedIn {
	private Batch batch;
	private Category category[];
}
