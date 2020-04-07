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
import com.sapient.dao.InstituteRepository;
import com.sapient.model.Batch;
import com.sapient.model.Institute;
import com.sapient.model.User;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class InstituteImplTest {
    
    @Autowired
    private InstituteImpl instituteImpl;
    
    @MockBean
    private InstituteRepository instituteRepository;

    @Before
    public void setUp() {
        Institute institute= new Institute();
        institute.setInstituteName("stb");
        institute.setInstituteId(1);
        Mockito.when(instituteRepository.findById(1)).thenReturn(Optional.of(institute));
        Mockito.when(instituteRepository.save(any(Institute.class))).thenReturn(institute);
        
      
          
    }
    
    

  
    @Test
    public void mockGetById() {
        Institute institute = instituteImpl.getInstituteById(1);
        Assert.assertEquals("stb",institute.getInstituteName());
    }
    @Test
    public void mockadd1() {
        Institute institute = new Institute();
        institute.setInstituteId(1);
        institute.setInstituteName("stb");
        Institute x= instituteImpl.addNewInstitute(institute);
    	
    	Assert.assertEquals("stb",x.getInstituteName());
    }


}
 
