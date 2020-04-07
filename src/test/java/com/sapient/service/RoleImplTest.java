package com.sapient.service;
import static org.junit.Assert.assertEquals;

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

import com.sapient.dao.RoleRepository;
import com.sapient.model.Role;
import com.sapient.model.User;
import com.sapient.user_management.UserManagementApplication;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class RoleImplTest {
    
    @Autowired
    private RoleImpl roleImpl;
    
    @MockBean
    private RoleRepository roleRepository;

    
    @Before
    public void setUp() {
    	Role role = new Role();
    	role.setRoleIden(1);
    	role.setDeleteAccess(true);
    	role.setReadAccess(true);
    	role.setWriteAccess(true);
    	role.setRoleName("Admin");
    	ArrayList<Role> list = new ArrayList<Role>();
    	list.add(role);
        User user = new User();
        user.setFirstName("Prem");
        user.setLastName("vardhan");
        user.setEmail("prem@abc.in");
        //user.setPassword("varudu");
        user.setMobile((long)7550181);
        ArrayList<User> listu = new ArrayList<User>();
        listu.add(user);
        Mockito.when(roleRepository.findAll()).thenReturn(list);
        Mockito.when(roleRepository.findById(1)).thenReturn(Optional.of(role));
        Mockito.when(roleRepository.save(any(Role.class))).thenReturn(role);
        //Mockito.when(roleRepository.findAllByPassword("varudu", "prem@abc.in")).thenReturn(listu);
        Mockito.verify(roleRepository, times(0)).delete(any(Role.class));
        
    }
    
    @Test
    public void deleteRoles() {
    	Role role = new Role();
    	role.setRoleIden(1);
    	role.setDeleteAccess(true);
    	role.setReadAccess(true);
    	role.setWriteAccess(true);
    	role.setRoleName("Admin");
    	String string = roleImpl.deleteRole(role);
    	Assert.assertEquals("Role Deleted", string);
    }
    
    @Test
    public void add() {
    	Role role = new Role();
    	role.setRoleIden(1);
    	role.setDeleteAccess(true);
    	role.setReadAccess(true);
    	role.setWriteAccess(true);
    	role.setRoleName("Admin");
    	String x= roleImpl.addNewRole(role);
    	Assert.assertEquals(role.getRoleName(),x);
    	
    }
    
    @Test
    public void mockGetAll() {
        ArrayList<Role> role = roleImpl.getAllRoles();
        Assert.assertEquals("Admin",role.get(0).getRoleName());
    }
    @Test
    public void mockGetById() {
        Role role = roleImpl.getRoleById(1);
        Assert.assertEquals("Admin", role.getRoleName());
    }
//    @Test
//    public void mockmovalid() {
//    	User user= new User();
//    	 
//    	boolean u=roleImpl.isValid(user);
//    	assertEquals(false,u);
//    	
//    }
//    @Test
//    public void mockvalid1() {
//    	User x = new User();
//    	x.setPassword("varudu");
//    	x.setEmail("prem@abc.in");
//    	boolean u=roleImpl.isValid(x);
//    	assertEquals(true,u);
//    	
//    }
  
}
 