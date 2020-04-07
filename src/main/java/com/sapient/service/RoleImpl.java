package com.sapient.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.RoleRepository;
import com.sapient.model.Role;
import com.sapient.model.User;

@Service
public class RoleImpl {
	@Autowired
	RoleRepository roleRepository;
	
	
	public Role getRoleById(Integer id) {
		return roleRepository.findById(id).orElseThrow(null);
	}
	
	public String addNewRole(Role role) {
		return roleRepository.save(role).getRoleName();
	}
//	public boolean isValid(User user) {
//		ArrayList<User> list = roleRepository.findAllByPassword(user.getPassword(),user.getEmail());
//		if(list.size()!=0)
//		{
//			return true;
//		}
//		return false;
//	}
	
	public String deleteRole(Role role) {
		try {
			roleRepository.delete(role);
			return "Role Deleted";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}

	public ArrayList<Role> getAllRoles() {
		return new ArrayList<Role>(roleRepository.findAll());
	}

	
}
