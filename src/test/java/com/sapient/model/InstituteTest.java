package com.sapient.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.dao.CategoryRepository;

import com.sapient.user_management.UserManagementApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)

public class InstituteTest {

	 @Test
	    public void setterFunctions() {
		 Institute institute = new Institute();
		 institute.setInstituteId(1);
		 institute.setInstituteName("xyz");
		 institute.setInstituteAddress("chennai");
		 institute.setPocName("abhay");
		 institute.setPocMobile((long) 123456789);
		 institute.setUniversity(null);
		
		 assertEquals(1, institute.getInstituteId());
		 assertEquals("xyz",institute.getInstituteName());
		 assertEquals("chennai",institute.getInstituteAddress());
		 assertEquals("abhay",institute.getPocName());
		 assertEquals( 123456789L,institute.getPocMobile());
		 assertEquals(null,institute.getUniversity());
		 
		 
	 }
	 
	  @Test
	    public void checkToString() {
		  Institute institute = new Institute();
	        assertEquals("", institute.toString());
	    }
	  
		@Test
		public void noAllArgsConstructor() {
			Institute institute = new Institute();
			 assertEquals(null, institute.getInstituteId());
			 assertEquals(null,institute.getInstituteName());
			 assertEquals(null,institute.getInstituteAddress());
			 assertEquals(null,institute.getPocName());
			 assertEquals( null,institute.getPocMobile());
			 assertEquals(null,institute.getUniversity());
			
		}
		
		@Test
		public void checkAllArgsConstructor() {
			Institute institute = new Institute(1,"xyz","chennai","abhay",123456789L,null);
			 assertEquals(1, institute.getInstituteId());
			 assertEquals("xyz",institute.getInstituteName());
			 assertEquals("chennai",institute.getInstituteAddress());
			 assertEquals("abhay",institute.getPocName());
			 assertEquals( 123456789L,institute.getPocMobile());
			 assertEquals(null,institute.getUniversity());
			
		}
}
