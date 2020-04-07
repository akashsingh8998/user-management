package com.sapient.service;

import static org.mockito.Mockito.*;
//import static org.junit.Assert.assertEquals;

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

import com.sapient.dao.UserRepository;
import com.sapient.dao.UserRoleRepository;
import com.sapient.model.Batch;
import com.sapient.model.Category;
import com.sapient.model.Role;
import com.sapient.model.User;
import com.sapient.model.UserRole;
import com.sapient.user_management.UserManagementApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class UserImplTest {
    
    @Autowired
    private UserImpl userImpl;
//    @Autowired
//    private UserRoleImpl userRoleImpl;
    
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserRoleRepository userRoleRepository;

    @Before
    public void setUp() {
    	Batch batch=new Batch();
    	batch.setBatchId(1);
    	Category category= new Category();
    	category.setCategoryId(1);
    	 User user = new User();
         user.setFirstName("Prem");
         user.setLastName("vardhan");
         user.setEmail("prem@abc.in");
         user.setUserId(1);
         user.setMobile((long)7550181);
         user.setBatch(batch);
         user.setCategory(category);
        ArrayList<User> list = new ArrayList<User>();
        list.add(user);
        

    	Role role= new Role();
    	role.setRoleIden(1);
    	role.setRoleName("Admin");
    	UserRole userrole= new UserRole();
    	userrole.setUserRoleId(1);
    	userrole.setRole(role);
    	userrole.setUser(user);
    	
        ArrayList<UserRole> urlist = new ArrayList<UserRole>();
        urlist.add(userrole);
        Mockito.when(userRepository.findAll()).thenReturn(list);
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findAllBySearchQuery("prem")).thenReturn(list);
        Mockito.when(userRepository.findAllByMobile((long)7550181)).thenReturn(list);
        Mockito.when(userRepository.findByEmail("prem@abc.in")).thenReturn(list);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        Mockito.verify(userRepository, times(0)).delete(any(User.class));
        Mockito.when(userRoleRepository.findAllUserRoleWithUserId(1)).thenReturn(urlist);
        Mockito.when(userRoleRepository.findAllUserRoleWithRoleName("Admin")).thenReturn(urlist);
        Mockito.when(userRoleRepository.save(any(UserRole.class))).thenReturn(userrole);
        Mockito.when(userRepository.findUsersByBatch(1)).thenReturn(list);
        Mockito.when(userRepository.getAllUsersByBatchIdAndCategoryId(1,1)).thenReturn(list);
    }
    @Test
    public void mockGetById() {
        User user = userImpl.getUserById(1);
        Assert.assertEquals("Prem", user.getFirstName());
    }
    
    @Test
    public void deleteUsers() {
    	 User user = new User();
         user.setFirstName("Prem");
         user.setLastName("vardhan");
         user.setEmail("prem@abc.in");
         user.setMobile((long)7550181);
    	String string = userImpl.deleteUser(user);
    	Assert.assertEquals("User Deleted", string);
    }
    @Test
    public void getuserwithrole() {
    	ArrayList<Role> rlist= userImpl.getUserWithAllRoles("prem@abc.in");
    	Assert.assertEquals(1, rlist.size());
    	
    }
    @Test
    public void getuserbyrole() {
    	
    	
    	ArrayList<User> x= userImpl.getUserByRole("Admin");
    	Assert.assertEquals(true, x.size()>0);
    	
    }
    
    
    @Test
    public void getuserbybatchid() {
    	Batch batch=new Batch();
    	batch.setBatchId(1);
    	User user=new User();
    	user.setUserId(1);
    	user.setFirstName("prem");
    	user.setBatch(batch);
    	ArrayList<User> list= userImpl.getAllUsersByBatchId(1);
    	Assert.assertEquals(true, list.size()>0);
    	
    	
    }
    @Test
    public void getuserbybatchidandcategory() {
    	Batch batch=new Batch();
    	batch.setBatchId(1);
    	Category category= new Category();
    	category.setCategoryId(1);
    	User user=new User();
    	user.setUserId(1);
    	user.setFirstName("prem");
    	user.setBatch(batch);
    	ArrayList<User> list= userImpl.getAllUsersByBatchIdAndCategoryId(1,1);
    	Assert.assertEquals(true, list.size()>0);
    	
    }
    
    @Test
    public void mockGetAll() {
        ArrayList<User> list = userImpl.getAllUsers();
        Assert.assertEquals("Prem",list.get(0).getFirstName());
    }
    
    @Test
    public void mockqueryfind() {
    	ArrayList<User> user=userImpl.searchUserByQuery("prem");
    	 Assert.assertEquals(true, user.size()>0);
    	
    }

    @Test
    public void mockmouservalid() {
    	 
    	boolean u=userImpl.isUserValid("prem@abc.in");
    	Assert.assertEquals(false,u);
    	
    }
    @Test
    public void mockuservalid1() {
    	boolean u=userImpl.isUserValid("asdas@gmail.com");
    	Assert.assertEquals(true,u);
    	
    }
    
    
    @Test
    public void mockadd1() {
    	
    	 User user = new User();
         user.setFirstName("Prem");
         user.setLastName("vardhan");
         user.setEmail("prem@abc.in");
         user.setUserId(1);
         user.setMobile((long)7550181);
    	 String s= userImpl.addNewUser(user).toString();
    	
    	 Assert.assertEquals("1",s);
    }

    @Test
    public void mockmobile()
    {
    	ArrayList<User> user=userImpl.searchUserByMobile((long) 7550181);
   	 	Assert.assertEquals(true, user.size()>0);
   	
    	
    }
    @Test
    public void mockemail()
    {
    	User p= new User();
    	p.setEmail("prem@abc.in");
    	p.setFirstName("Prem");
//    	String s= userImpl.addNewUser(p).toString();
    	User user=userImpl.getUserByEmail("prem@abc.in");
   	 	Assert.assertEquals("Prem",user.getFirstName());
   	
    	
    }
    


}
 