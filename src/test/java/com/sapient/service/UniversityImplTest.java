package com.sapient.service;



import static org.mockito.Mockito.*;
//import static org.junit.Assert.assertEquals;


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

import com.sapient.dao.UniversityRepository;
import com.sapient.model.University;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class UniversityImplTest {
    
    @Autowired
    private UniversityImpl universityImpl;
    
    @MockBean
    private UniversityRepository universityRepository;

    @Before
    public void setUp() {
    	University university= new University();
    	university.setUniversityName("anna");
        
        
        Mockito.when(universityRepository.save(any(University.class))).thenReturn(university);
        
      
          
    }
    
    @Test
    public void mockadd1() {
    	University university= new University();
    	university.setUniversityName("anna");
    	University x= universityImpl.addNewUniversity(university);
    	
    	Assert.assertEquals("anna",x.getUniversityName());
    }


}
 
