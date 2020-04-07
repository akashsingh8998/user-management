package com.sapient.service;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sapient.dao.UserCredentialsRepository;
import com.sapient.dao.UserRepository;
import com.sapient.dao.UserRoleRepository;
import com.sapient.model.Role;
import com.sapient.model.User;
import com.sapient.model.UserCredentials;
import com.sapient.model.UserRole;

@Service
public class UserImpl extends ResponseEntityExceptionHandler {
	public static HttpStatus http_status = null;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserCredentialsRepository userCredentialsRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	public User getUserById(Integer id) {
		
		return userRepository.findById(id).orElseThrow(null);
	}
	
	public Integer addNewUser(User user) {
	    User addedUserName = userRepository.save(user);
	    //TODO check user already exists or not.
//	    if(addedUserName==null)
//	    { 
//	    	return "Email Id or Mobile Number Already Exists";
//	    }
	    //TODO try catch to catch null return
	    addNewUsersPassword(addedUserName);
	    Integer userId = addedUserName.getUserId();
	    return userId;
	    
	}
	
	public void addNewUsersPassword(User addedUserName) {
		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUserId(addedUserName.getUserId());
		userCredentials.setEmail(addedUserName.getEmail());
		String password = addedUserName.getFirstName() + "@" + addedUserName.getMobile().toString();
		String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
		userCredentials.setPassword(pw_hash);
		userCredentialsRepository.save(userCredentials);
	}
	
	
	public ArrayList<User> searchUserByQuery(String searchQuery){
		return userRepository.findAllBySearchQuery(searchQuery);
	}

	public ArrayList<User> searchUserByMobile(long mobile) {
		return userRepository.findAllByMobile(mobile);
	}

//	public boolean isValid(User user) {
//		ArrayList<User> list = userRepository.findAllByPassword(user.getPassword(),user.getEmail());
//		if(list.size()!=0)
//		{
//			return true;
//		}
//		return false;
//	}

	
	public String deleteUser(User user) {
		try {
			userRepository.delete(user);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "User Deleted";
	}

	public ArrayList<User> getAllUsers() {
		return new ArrayList<User>(userRepository.findAll());
	}
	
//	public User getAuthenticatedUser(User user) {
//		ArrayList<User> list = userRepository.findAllByPassword(user.getPassword(),user.getEmail());
//		if(list.size()!=0)
//		{
//			return list.get(0);
//		}
//		return null;
//		
//	}
	
	public boolean isUserValid(String email) {
		ArrayList<User> list = userRepository.findByEmail(email);
		if(list.size()!=0)
		{
			return false;
		}
		return true;
	}

	public ArrayList<User> getAllUsersByBatchId(Integer batchId) {
		ArrayList<User> list = userRepository.findUsersByBatch(batchId);
		return list;
	}

	public ArrayList<User> getAllUsersByBatchIdAndCategoryId(Integer batchId, Integer categoryId) {
		return userRepository.getAllUsersByBatchIdAndCategoryId(batchId, categoryId);
	}

	public User getUserByEmail(String email) {
		ArrayList<User> list = userRepository.findByEmail(email);
		return list.get(0);
	}

	public ArrayList<Role> getUserWithAllRoles(String email) {
		User user = getUserByEmail(email);
		ArrayList<Role> roleList = new ArrayList<Role>();
		ArrayList<UserRole> userRoleList = userRoleRepository.findAllUserRoleWithUserId(user.getUserId());
		for (UserRole userRole : userRoleList) {
			roleList.add(userRole.getRole());
		}
		
//		ArrayList<UserRole>
		return roleList;
	}

	public ArrayList<User> getUserByRole(String roleName) {
		ArrayList<UserRole> userRoleList = userRoleRepository.findAllUserRoleWithRoleName(roleName);
		ArrayList<User> userList = new ArrayList<User>();
		for (UserRole userRole : userRoleList) {
			userList.add(userRole.getUser());
		}
//		Set<User> userSet = new HashSet<User>(userList);
		return userList;
	}
	
}
