package com.sapient.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

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
public class UniversityTest {
   @Test
   public void findUniversity() throws ParseException {
	   University university=new University();
       university.setUniversityIden(1);
       university.setUniversityName("xyz");
       university.setUniversityAddress("Delhi");
       assertEquals(1, university.getUniversityIden());
       assertEquals("xyz", university.getUniversityName());
       assertEquals("Delhi", university.getUniversityAddress());
   }
   
   @Test
   public void constructorWithPara() {
	   String name="xyz";
	   String add="Delhi";
	   University university=new University(name,add);
	   
   }
   
   @Test
   public void constructorWithAllPara() {
	   Integer id=1;
	   String name="xyz";
	   String add="Delhi";
	   University university=new University(id,name,add);
	   
   }
   
   @Test
   public void forToString() {
	   University university=new University(1,"xyz","Delhi");
	   Assert.assertEquals("", university.toString());
   }
}
