package com.sapient.exception;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.text.ParseException;


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


public class TestErrorInfo {
 
    @Test
    public void findUser() throws ParseException {
        ErrorInfo Err = new ErrorInfo("hello","message");
         assertEquals("hello", Err.getUrl());
         assertEquals("message", Err.getMessage());
    }
    
    @Test
    public void findUser2() throws ParseException {
        ErrorInfo Err = new ErrorInfo();
         assertEquals(null, Err.getUrl());
         assertEquals(null, Err.getMessage());
    }
    
    @Test
    public void findUser3() throws ParseException {
        ErrorInfo Err = new ErrorInfo();
         Err.setUrl("admin");
         Err.setMessage("message");
         assertEquals("admin", Err.getUrl());
         assertEquals("message", Err.getMessage());
         
    }
    }

