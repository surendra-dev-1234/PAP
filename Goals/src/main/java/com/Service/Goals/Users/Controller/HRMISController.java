package com.Service.Goals.Users.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Goals.Users.Entity.Role;
import com.Service.Goals.Users.Entity.UserRoleMapping;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Service.RoleService;
import com.Service.Goals.Users.Service.UserRoleMappingService;
import com.Service.Goals.Users.Service.UsersService;

import Services.EmailNotificationService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class HRMISController {

	@Autowired
	UsersService usersservice;

	@Autowired
	RoleService  roleservice;

	@Autowired
	UserRoleMappingService userrolemappingservice;

	@PostMapping("addmisuser")
	public Map<String,Object> addmisuser(@RequestBody Users usersinput){ 
		Map<String,Object> misMap=new HashMap<String, Object>();
		usersinput.getUser_id();
		usersservice.addmisuser(usersinput.getUser_id());
		Role roleinput=new Role();
		roleinput.setRolename("MIS_USER");
		UserRoleMapping userrolemappinginput=new UserRoleMapping();
		Role roledata=roleservice.getrolename(roleinput.getRolename());
		userrolemappinginput.setRole_id(Long.toString(roledata.getRole_id()));
		userrolemappingservice.adduserrolemapping(userrolemappinginput.getRole_id(),Long.toString(usersinput.getUser_id()));
		try {
			EmailNotificationService emailnotificationservie=new EmailNotificationService();
			emailnotificationservie.SendAddMISUserNotification("sreddy@Quantira.com","surendra");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		misMap.put("Mis",usersservice.getMislist(usersinput.getDomain_id()));
		misMap.put("NonMis",usersservice.getnonMislist(usersinput.getDomain_id()));
		return misMap;
	}

	@PostMapping("deletemisuser")
	public Map<String,Object> deletemisuser(@RequestBody Users usersinput){
		Map<String,Object> misMap=new HashMap<String, Object>();
		usersinput.getUser_id();
		usersservice.deletemisuser(usersinput.getUser_id());
		Role roleinput=new Role();
		roleinput.setRolename("MIS_USER");
		UserRoleMapping userrolemappinginput=new UserRoleMapping();
		Role roledata=roleservice.getrolename(roleinput.getRolename());
		userrolemappinginput.setRole_id(Long.toString(roledata.getRole_id()));
		userrolemappingservice.deleteuserrolemapping(userrolemappinginput.getRole_id(),Long.toString(usersinput.getUser_id()));
		misMap.put("Mis",usersservice.getMislist(usersinput.getDomain_id()));
		misMap.put("NonMis",usersservice.getnonMislist(usersinput.getDomain_id()));
		return misMap; 
	}

	@PostMapping("getmislist")
	public  Map<String, Object> getmislist(@RequestBody Users usersinput){ 
		Map<String,Object> misMap=new HashMap<String, Object>();
		misMap.put("Mis",usersservice.getMislist(usersinput.getDomain_id()));
		misMap.put("NonMis",usersservice.getnonMislist(usersinput.getDomain_id()));
		return misMap;
	}


}
