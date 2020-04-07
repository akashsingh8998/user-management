package com.sapient.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

 

import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class TestRoleNotFoundException 
    {
        //This test case fails because it was expecting ArithmeticException
        @Test(expected = RoleNotFoundException.class)
        public void expectRoleNotFoundException() throws BatchNotFoundException, RoleNotFoundException
        {
            throw new RoleNotFoundException();
        }
        
        @Test(expected = RoleNotFoundException.class)
        public void expectRoleNotFoundException2() throws BatchNotFoundException, RoleNotFoundException
        {
            throw new RoleNotFoundException("message");
        }
        
        @Test(expected = RoleNotFoundException.class)
        public void expectRoleNotFoundException3() throws BatchNotFoundException, RoleNotFoundException
        {
            throw new RoleNotFoundException("message",null);
        }
    
}