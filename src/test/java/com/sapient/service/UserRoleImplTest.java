package com.sapient.service;

import static org.mockito.Mockito.*;

import org.junit.Assert;

//import static org.junit.Assert.assertEquals;
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

import com.sapient.dao.UserRoleRepository;
import com.sapient.model.UserRole;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class UserRoleImplTest {
    
    @Autowired
    private UserRoleImpl userRoleImpl;
    
    @MockBean
    private UserRoleRepository userRoleRepository;

    @Before
    public void setUp() {
    	UserRole userRole= new UserRole();
    	userRole.setUserRoleId(1);
    	Mockito.when(userRoleRepository.save(any(UserRole.class))).thenReturn(userRole);  
    }
    
   
    
    @Test
    public void saveBatchCategory() {
    	UserRole userRole= new UserRole();
    	userRole.setUserRoleId(1);
    	String id= userRoleImpl.addNewUserRole(userRole).toString();
    	Assert.assertEquals("1", id);
    	
    }
    
  
}
 
