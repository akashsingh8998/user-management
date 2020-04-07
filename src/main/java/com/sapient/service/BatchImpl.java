package com.sapient.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.BatchRepository;
import com.sapient.model.Batch;
import com.sapient.model.User;


@Service
public class BatchImpl {
	@Autowired
	BatchRepository batchRepository;
	
	
	public Batch getBatchById(Integer id) {
		return batchRepository.findById(id).orElseThrow(null);
	}
	
	public Integer addNewBatch(Batch batch) {
		return batchRepository.save(batch).getBatchId();
	}
	
//	public boolean isValid(User user) {
//		ArrayList<User> list = batchRepository.findAllByPassword(user.getPassword(),user.getEmail());
//		if(list.size()!=0)
//		{
//			return true;
//		}
//		return false;
//	}
	
	public String deleteBatch(Batch batch) {
		try {
			batchRepository.delete(batch);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Batch Deleted";
	}

	public ArrayList<Batch> getAllBatches() {
		return new ArrayList<Batch>(batchRepository.findAll());
	}
}
