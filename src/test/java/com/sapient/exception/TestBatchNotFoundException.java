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
public class TestBatchNotFoundException 
    {
        //This test case fails because it was expecting ArithmeticException
        @Test(expected = BatchNotFoundException.class)
        public void expectBatchNotFoundException() throws BatchNotFoundException
        {
            throw new BatchNotFoundException();
        }
        
        @Test(expected = BatchNotFoundException.class)
        public void expectBatchNotFoundException2() throws BatchNotFoundException
        {
            throw new BatchNotFoundException("message");
        }
        
        @Test(expected = BatchNotFoundException.class)
        public void expectBatchNotFoundException3() throws BatchNotFoundException
        {
            throw new BatchNotFoundException("message",null);
        }
    
}