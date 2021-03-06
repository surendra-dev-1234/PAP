package com.Service.Goals.Users.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Goals.Users.Entity.Role;
import com.Service.Goals.Users.Entity.Unfreeze;
import com.Service.Goals.Users.Entity.UserRoleMapping;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Service.RoleService;
import com.Service.Goals.Users.Service.UnfreezeService;
import com.Service.Goals.Users.Service.UserRoleMappingService;
import com.Service.Goals.Users.Service.UsersService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class HRUnfreezeController {

	@Autowired
	UnfreezeService unfreezeservice;

	@Autowired
	RoleService roleservice;

	@Autowired
	UserRoleMappingService userrolemappingservice;

	@Autowired
	UsersService usersservice;

	@PostMapping("hrunfreezeuser")
	public ResponseEntity<String> hrunfreezeuser(@RequestBody Unfreeze unfreezeinput) {
		unfreezeservice.hrunfreezeuser(unfreezeinput.getYear(),unfreezeinput.getQuarter_id(),unfreezeinput.getUser_id(),unfreezeinput.getUnfreezefor(),unfreezeinput.getUnfreezedays(),unfreezeinput.getUnfreezedata(),unfreezeinput.getUnfreezeby());
		return new ResponseEntity<String>("The Hr has unfreeze the user, Sucessfully", HttpStatus.OK);
	}

	@PostMapping("unfreeze")
	public Map<String,Object> unfreeze(@RequestBody Users usersinput){
		Map<String,Object> freezeMap=new HashMap<String, Object>();
		usersinput.getUser_id();
		usersservice.unfreeze(usersinput.getUser_id());
		Role roleinput=new Role();
		roleinput.setRolename("UNFREEZE_USER");
		UserRoleMapping userrolemappinginput=new UserRoleMapping();
		Role roledata=roleservice.getrolename(roleinput.getRolename());
		userrolemappinginput.setRole_id(Long.toString(roledata.getRole_id()));
		userrolemappingservice.deleteuserrolemapping(userrolemappinginput.getRole_id(),Long.toString(usersinput.getUser_id()));
		freezeMap.put("Freeze",usersservice.getFreezelist());
		freezeMap.put("UnFreeze",usersservice.getunFreezelist());
		return freezeMap;
	}

	@PostMapping("freeze")
	public Map<String,Object> freeze(@RequestBody Users usersinput){
		Map<String,Object> freezeMap=new HashMap<String, Object>();
		usersinput.getUser_id();
		usersservice.freeze(usersinput.getUser_id());
		Role roleinput=new Role();
		roleinput.setRolename("UNFREEZE_USER");
		UserRoleMapping userrolemappinginput=new UserRoleMapping();
		Role roledata=roleservice.getrolename(roleinput.getRolename());
		userrolemappinginput.setRole_id(Long.toString(roledata.getRole_id()));
		userrolemappingservice.deleteuserrolemapping(userrolemappinginput.getRole_id(),Long.toString(usersinput.getUser_id()));
		freezeMap.put("Freeze",usersservice.getFreezelist());
		freezeMap.put("UnFreeze",usersservice.getunFreezelist());
		return freezeMap;
	}

	@PostMapping("getfreezelist")
	public  Map<String,Object> getfreezelist(){ 
		Map<String,Object> freezeMap=new HashMap<String, Object>();
		freezeMap.put("Freeze", usersservice.getFreezelist());
		freezeMap.put("UnFreeze", usersservice.getunFreezelist());
		return freezeMap;
	}
}
