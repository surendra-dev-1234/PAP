package com.Service.Goals.Users.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.UserRoleMapping;
import com.Service.Goals.Users.Repository.UserRoleMappingRepository;

@Service
public class UserRoleMappingService {

	@Autowired
	UserRoleMappingRepository userrolemappingrepository;

	public void adduserrolemapping(String role_id, String user_id) {
		userrolemappingrepository.adduserrolemapping(role_id,user_id);
	}

	public void deleteuserrolemapping(String role_id, String user_id) {
		userrolemappingrepository.deleteuserrolemapping(role_id,user_id);
	}

	public List<UserRoleMapping> getuserrolemapping() {
		// TODO Auto-generated method stub
		return userrolemappingrepository.findAll();
	}

}
