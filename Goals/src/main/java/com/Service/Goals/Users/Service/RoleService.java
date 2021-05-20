package com.Service.Goals.Users.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.Role;
import com.Service.Goals.Users.Repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository rolerepository;

	public Role getrolename(String role_name) {
		return rolerepository.getrolename(role_name);
	}


}
