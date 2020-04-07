package com.sapient.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
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
public class TestUser {   
    @Test
    public void findUser() throws ParseException {
        User user = new User();
        user.setUserId(1);
        user.setFirstName("fname");
        user.setLastName("lname");
        user.setEmail("email");
        user.setMobile(9834589384L);
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    	Date d1 = df.parse("12-10-2011");
        user.setBirthdate(d1);
        user.setJobLocation("jobLocation");
        user.setInstitute(null);
        user.setResidentialAddress("asd");
        user.setActiveStatus(null);
        user.setBatch(null);
        user.setCategory(null);
        assertEquals(1, user.getUserId());
        assertEquals("fname", user.getFirstName());
        assertEquals("lname", user.getLastName());
        assertEquals("email", user.getEmail());
        assertEquals(9834589384L, user.getMobile());
        assertEquals(d1, user.getBirthdate());
        assertEquals(null, user.getInstitute());
        assertEquals("jobLocation", user.getJobLocation());
        assertEquals("asd", user.getResidentialAddress());
        assertEquals(null, user.getActiveStatus());
        assertEquals(null, user.getBatch());
        assertEquals(null, user.getCategory());   
    }

    
        @Test
        public void checkAllArgsConstructor() throws ParseException {
        	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        	Date d1 = df.parse("12-10-2011");
            User batch = new User(1, "fname", "lname", "email",9834589384L, d1, "jobLocation", null, "asd", null, null, null);
            Integer num=1;
            Assert.assertEquals(num, batch.getUserId());
            assertEquals("fname", batch.getFirstName());
            assertEquals("lname", batch.getLastName());
            assertEquals("email", batch.getEmail());
            assertEquals(9834589384L, batch.getMobile());
            assertEquals(d1, batch.getBirthdate());
            assertEquals("jobLocation", batch.getJobLocation());
            assertEquals(null, batch.getInstitute());
            assertEquals("asd", batch.getResidentialAddress());
            assertEquals(null, batch.getActiveStatus());
            assertEquals(null, batch.getBatch());
            assertEquals(null, batch.getCategory());
        }
        
        @Test
        public void twoArgsConstructor() {
        	User user = new User("Akash","Singh");
        	assertEquals("Akash", user.getFirstName());
            assertEquals("Singh", user.getLastName());
        }
       
        
        @Test
        public void AllArgsConstructor() throws ParseException {
        	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        	Date d1 = df.parse("12-10-2011");
            User batch = new User("fname", "lname", "email",9834589384L, d1, "jobLocation", "asd", null, null,null);
            assertEquals("fname", batch.getFirstName());
            assertEquals("lname", batch.getLastName());
            assertEquals("email", batch.getEmail());
            assertEquals(9834589384L, batch.getMobile());
            assertEquals(d1, batch.getBirthdate());
            assertEquals("jobLocation", batch.getJobLocation());
            assertEquals("asd", batch.getResidentialAddress());
            assertEquals(null, batch.getActiveStatus());
            assertEquals(null, batch.getBatch());
            assertEquals(null, batch.getCategory());
        }
      
     
    }

 