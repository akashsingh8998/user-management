package com.sapient.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class BatchTests {
	
	
	@Test
	public void checkAllArgsConstructor() {
		Batch batch = new Batch(1,"PSI2020","SDE");
		Integer num=1;
		Assert.assertEquals(num, batch.getBatchId());
		Assert.assertEquals("PSI2020",batch.getBatchName());
		Assert.assertEquals("SDE",batch.getDescription());
		
	}
	
	@Test
	public void noAllArgsConstructor() {
		Batch batch = new Batch();
		Assert.assertEquals(null, batch.getBatchId());
		Assert.assertEquals(null,batch.getBatchName());
		Assert.assertEquals(null,batch.getDescription());
		
	}
	
	@Test
	public void twoArgsConstructor() {
		Batch batch = new Batch("PSI2020","SDE");
		Assert.assertEquals("PSI2020",batch.getBatchName());
		Assert.assertEquals("SDE",batch.getDescription());
		
	}
	
	  @Test
	    public void checkToString() {
		  Batch batch = new Batch(1,"PSI2020","SDE");
	        assertEquals("", batch.toString());
	    }

		@Test
		public void checkSetter() {
			Batch batch = new Batch();
			batch.setBatchId(1);
			batch.setBatchName("PSI2020");
			batch.setDescription("SDE");
			Integer num=1;
			Assert.assertEquals(num, batch.getBatchId());
			Assert.assertEquals("PSI2020",batch.getBatchName());
			Assert.assertEquals("SDE",batch.getDescription());
			
		}
}