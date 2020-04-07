package com.sapient.model;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.dao.RoleRepository;
import com.sapient.dao.UserRepository;
import com.sapient.model.User;
import com.sapient.user_management.UserManagementApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)

public class UserRoleTest {

	@Test
    public void checkAllArgsConstructor() {
		UserRole userRole = new UserRole(1, null, null);
        Integer num=1;
        Assert.assertEquals(num, userRole.getUserRoleId());
        Assert.assertEquals(null,userRole.getRole());
        Assert.assertEquals(null,userRole.getUser());
		
	}
	
	   @Test
	    public void noAllArgsConstructor() {
		   UserRole userRole = new UserRole();
	        Assert.assertEquals(null, userRole.getUserRoleId());
	        Assert.assertEquals(null,userRole.getRole());
	        Assert.assertEquals(null,userRole.getUser());  
	    }
	   
       @Test
       public void checkSetter() {
    	   UserRole userRole = new UserRole();
           userRole.setUserRoleId(1);
           userRole.setRole(null);
           Integer num=1;
           Assert.assertEquals(num, userRole.getUserRoleId());
           Assert.assertEquals(null,userRole.getRole());
           Assert.assertEquals(null,userRole.getUser());
           
       }
}
