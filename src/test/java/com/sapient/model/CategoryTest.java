package com.sapient.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void setterFunctions() {
    	Category category = new Category();
    	category.setCategoryId(12);
    	category.setCategoryName("Admin");
    	category.setDescription("Have all access");
    	assertEquals("Admin", category.getCategoryName());
    	assertEquals("Have all access",category.getDescription());
    	assertEquals(12, category.getCategoryId());
    }
    @Test
    public void ret() {
    	Category user= new Category();
    	assertEquals("", user.toString());
    }
    @Test
    public void checkAllArgsConstructor() {
        Category category=new Category(12, "Admin", "Have all access");
        
        Integer num=12;
       assertEquals(num, category.getCategoryId());
       assertEquals("Admin", category.getCategoryName());
       assertEquals("Have all access", category.getDescription());
       
    }
    
    @Test
    public void twoArgsConstructor() {
        Category category=new Category("Admin", "Have all access");
        
       assertEquals("Admin", category.getCategoryName());
       assertEquals("Have all access", category.getDescription());
       
    }
  
 
}