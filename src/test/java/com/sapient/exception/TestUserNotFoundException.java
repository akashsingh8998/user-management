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
public class TestUserNotFoundException 
    {
        //This test case fails because it was expecting ArithmeticException
        @Test(expected = UserNotFoundException.class)
        public void expectUserNotFoundException() throws BatchNotFoundException, UserNotFoundException
        {
            throw new UserNotFoundException();
        }
        
        @Test(expected = UserNotFoundException.class)
        public void expectUserNotFoundException2() throws BatchNotFoundException, UserNotFoundException
        {
            throw new UserNotFoundException("message");
        }
        
        @Test(expected = UserNotFoundException.class)
        public void expectUserNotFoundException3() throws BatchNotFoundException, UserNotFoundException
        {
            throw new UserNotFoundException("message",null);
        }
    
}