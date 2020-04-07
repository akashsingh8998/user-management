package com.sapient.service;


import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.dao.BatchCategoryRepository;
import com.sapient.model.Batch;
import com.sapient.model.BatchCategory;
import com.sapient.model.Category;
import com.sapient.model.User;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class BatchCategoryImplTest {
    
    @Autowired
    private BatchCategoryImpl batchCategoryImpl;
    
    @MockBean
    private BatchCategoryRepository batchCategoryRepository;

    @Before
    public void setUp() {
    	Batch batch= new Batch();
    	batch.setBatchId(1);
    	batch.setBatchName("psi2020");
    	batch.setDescription("engineers 2020");
    	BatchCategory role = new BatchCategory();
    	Category category = new Category();
    	category.setCategoryId(1);
    	category.setCategoryName("senior");
    	category.setDescription("senior batch");
    	role.setBatch(batch);
    	role.setBatchCategoryId(1);
    	role.setCategory(category);
    	
    	ArrayList<BatchCategory> list = new ArrayList<BatchCategory>();
    	list.add(role);
        User user = new User();
        user.setFirstName("Prem");
        user.setLastName("vardhan");
        user.setEmail("prem@abc.in");
        user.setMobile((long)7550181);
        ArrayList<User> listu = new ArrayList<User>();
        listu.add(user);
        Mockito.when(batchCategoryRepository.findByBatchId(1)).thenReturn(list);
        Mockito.when(batchCategoryRepository.save(any(BatchCategory.class))).thenReturn(role);  
    }
    
    @Test
    public void mockGetById() {
        ArrayList<Category> role = batchCategoryImpl.getAllCategoriesOfBatchId(1);
        Assert.assertEquals("1",role.get(0).getCategoryId().toString());
    }
    
    @Test
    public void saveBatchCategory() {
    	Batch batch= new Batch();
    	batch.setBatchId(1);
    	batch.setBatchName("psi2020");
    	batch.setDescription("engineers 2020");
    	BatchCategory role = new BatchCategory();
    	Category category = new Category();
    	category.setCategoryId(1);
    	category.setCategoryName("senior");
    	category.setDescription("senior batch");
    	role.setBatch(batch);
    	role.setBatchCategoryId(1);
    	role.setCategory(category);
    	String id = batchCategoryImpl.addNewBatchCategory(role).toString();
    	Assert.assertEquals("1", id);
    	
    }
    
  
}
 
