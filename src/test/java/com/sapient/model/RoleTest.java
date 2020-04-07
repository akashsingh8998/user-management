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
public class RoleTest {

//    @Autowired
//    private RoleRepository RoleRepository;
    
    @Test
    public void findUser() {
    	Role role = new Role("Admin", true, true, true);
    	role.setRoleIden(1);
        Role user = new Role();
        user.setRoleIden(2);
        user.setDeleteAccess(true);
    	user.setReadAccess(true);
    	user.setRoleName("Admin");
    	user.setWriteAccess(true);
    	assertEquals(2, user.getRoleIden());
        assertEquals("Admin", user.getRoleName());
        assertEquals(true, user.getReadAccess());
        assertEquals(true, user.getDeleteAccess());
        assertEquals(true, user.getWriteAccess());
    }
    @Test
    public void ret() {
    	Role user = new Role("admin", true, true, true);
    	assertEquals("", user.toString());
    }
    @Test
    public void checkAllArgsConstructor() {
        Role batch = new Role(1,"admin", true, true, true);
        Integer num=1;
        Assert.assertEquals(num, batch.getRoleIden());
        Assert.assertEquals("admin", batch.getRoleName());
        assertEquals(true, batch.getReadAccess());
        assertEquals(true, batch.getDeleteAccess());
        assertEquals(true, batch.getWriteAccess());
       
    }
  
 
}