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
public class TestCategoryNotFoundException 
    {
        //This test case fails because it was expecting ArithmeticException
        @Test(expected = CategoryNotFoundException.class)
        public void expectCategoryNotFoundException() throws BatchNotFoundException, CategoryNotFoundException
        {
            throw new CategoryNotFoundException();
        }
        
        @Test(expected = CategoryNotFoundException.class)
        public void expectCategoryNotFoundException2() throws BatchNotFoundException, CategoryNotFoundException
        {
            throw new CategoryNotFoundException("message");
        }
        
        @Test(expected = CategoryNotFoundException.class)
        public void expectCategoryNotFoundException3() throws BatchNotFoundException, CategoryNotFoundException
        {
            throw new CategoryNotFoundException("message",null);
        }
    
}