package com.sapient.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Optional;

 

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.dao.CategoryRepository;
import com.sapient.model.Category;
import com.sapient.model.User;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class CategoryImplTest {
    
    @Autowired
    private CategoryImpl categoryImpl;
    
    @MockBean
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
    	Category category = new Category();
    	category.setCategoryId(1);
    	category.setCategoryName("senior");
    	category.setDescription("senior batch");
    	ArrayList<Category> list = new ArrayList<Category>();
    	list.add(category);
        User user = new User();
        user.setFirstName("Prem");
        user.setLastName("vardhan");
        user.setEmail("prem@abc.in");
        user.setMobile((long)7550181);
        ArrayList<User> listu = new ArrayList<User>();
        listu.add(user);
        Mockito.when(categoryRepository.findAll()).thenReturn(list);
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(category);
//        Mockito.when(categoryRepository.findAllByPassword("varudu", "prem@abc.in")).thenReturn(listu);
        Mockito.when(categoryRepository.findByCategoryName("senior")).thenReturn(list);
        Mockito.verify(categoryRepository, times(0)).delete(any(Category.class));
            
    }
    
    @Test
    public void deleteCategory() {
    	Category category = new Category();
    	category.setCategoryId(1);
    	category.setCategoryName("senior");
    	category.setDescription("senior batch");
    	String string = categoryImpl.deleteCategory(category);
    	Assert.assertEquals("Category Deleted", string);
    }
    
    
    @Test
    public void saveCategory() {
    	Category category = new Category();
    	category.setCategoryId(1);
    	category.setCategoryName("senior");
    	category.setDescription("senior batch");
    	String string = categoryImpl.addNewCategory(category).toString();
    	Assert.assertEquals("1",string);
    }
    
    @Test
    public void mockGetAll() {
        ArrayList<Category> category = categoryImpl.getAllCategories();
        Assert.assertEquals("senior",category.get(0).getCategoryName());
    }
    @Test
    public void mockGetById() {
        Category category = categoryImpl.getCategoryById(1);
        Assert.assertEquals("senior", category.getCategoryName());
    }
    
    
//    @Test
//    public void mockmovalid() {
//    	User user= new User();
//    	
//    	boolean u=categoryImpl.isValid(user);
//    	assertEquals(false,u);
//    	
//    }
   
//    @Test
//    public void mockvalid1() {
//    	 User user = new User();
//        
//         user.setEmail("prem@abc.in");
//         user.setPassword("varudu");
//                
//    	boolean u=categoryImpl.isValid(user);
//    	assertEquals(true,u);
//    	
//    }
    
    @Test
    public void mockname() {
    	Category category = new Category();
    	category.setCategoryId(1);
    	category.setCategoryName("senior");
    	category.setDescription("senior batch"); 
    	 Integer i=categoryImpl.getCategoryByName(category);
    	 Integer p=1;
         Assert.assertEquals(p,i);
    	
    }
    @Test
    public void mockexist() {
    	Category category=new Category();
    	boolean b= categoryImpl.isCategoryExists(category);
    	Assert.assertEquals(false, b);
    }
    @Test
    public void mockexist1() {
    	ArrayList<Category> c= categoryImpl.getAllCategories();
    	Category ca=c.get(0); 
    	boolean b= categoryImpl.isCategoryExists(ca);
    	Assert.assertEquals(true, b);
    }

}
 
