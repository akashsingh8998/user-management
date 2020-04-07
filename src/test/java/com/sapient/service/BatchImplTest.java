package com.sapient.service;

 
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

 

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

import com.sapient.dao.BatchRepository;
import com.sapient.model.Batch;
import com.sapient.model.User;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class BatchImplTest {
    
    @Autowired
    private BatchImpl batchImpl;
    
    @MockBean
    private BatchRepository batchRepository;

    @Before
    public void setUp() {
        Batch batch = new Batch();
        batch.setBatchId(1);
        batch.setBatchName("psi2020");
        batch.setDescription("2020 product engineers");
        ArrayList<Batch> list = new ArrayList<Batch>();
        list.add(batch);
        User user = new User();
        user.setFirstName("Prem");
        user.setLastName("vardhan");
        user.setEmail("prem@abc.in");
       // user.setPassword("varudu");
        user.setMobile((long)7550181);
        ArrayList<User> listu = new ArrayList<User>();
        listu.add(user);
        Mockito.when(batchRepository.findAll()).thenReturn(list);
        Mockito.when(batchRepository.findById(1)).thenReturn(Optional.of(batch));
        Mockito.when(batchRepository.save(any(Batch.class))).thenReturn(batch);
        //Mockito.when(batchRepository.findAllByPassword("varudu", "prem@abc.in")).thenReturn(listu);
        Mockito.verify(batchRepository, times(0)).delete(any(Batch.class));
          
    }
    
    @Test
    public void deleteBatches() {
    	 Batch batch = new Batch();
         batch.setBatchId(1);
         batch.setBatchName("psi2020");
         batch.setDescription("2020 product engineers");
    	String string = batchImpl.deleteBatch(batch);
    	Assert.assertEquals("Batch Deleted", string);
    }
    
    
    @Test
    public void mockGetAll() {
        ArrayList<Batch> list = batchImpl.getAllBatches();
        Assert.assertEquals("psi2020",list.get(0).getBatchName());
    }
    @Test
    public void mockGetById() {
        Batch batch = batchImpl.getBatchById(1);
        Assert.assertEquals("psi2020",batch.getBatchName());
    }
    @Test
    public void mockadd1() {
        Batch batch = new Batch();
        batch.setBatchId(1);
        batch.setBatchName("psi2020");
        batch.setDescription("2020 product engineers");
    	Integer x = batchImpl.addNewBatch(batch);
    	Assert.assertEquals(batch.getBatchId(),x);
    }
//    @Test
//    public void mockmovalid() {
//    	User user= new User();
//    	boolean u=batchImpl.isValid(user);
//    	assertEquals(false,u);
//    }
    
   
//    @Test
//    public void mockvalid1() {
//    	 User user = new User();
//        
//         user.setEmail("prem@abc.in");
//         user.setPassword("varudu");
//                
//    	boolean u=batchImpl.isValid(user);
//    	assertEquals(true,u);
//    	
//    }

}
 