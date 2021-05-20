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

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class HRPEDController {

	@Autowired
	UsersService usersservice;

	@Autowired
	RoleService  roleservice;

	@Autowired
	UserRoleMappingService userrolemappingservice;

	@PostMapping("updatepedusermapping")
	public Map<String,Object> updatepedusermapping(@RequestBody Users usersinput){
		Map<String,Object> hrMap=new HashMap<String,Object>();
		if(usersinput.getPedmappingflag().equals("A")){
			Long[] user_ids=usersinput.getUser_ids();
			for(Long user_id:user_ids) {
				usersinput.setUser_id(user_id);
				usersservice.hrmapselectedempupdate(usersinput.getPed_id(),usersinput.getUser_id());
				hrMap.put("Avaliable", usersservice.hrmapavaliableemp(Long.parseLong(usersinput.getPed_id()),usersinput.getDomain_id()));
				hrMap.put("Selected", usersservice.hrmapselectedemp(Long.parseLong(usersinput.getPed_id()),usersinput.getDomain_id()));
			}
		}

		if(usersinput.getPedmappingflag().equals("D")){
			Long[] user_ids=usersinput.getUser_ids();
			for(Long user_id:user_ids) {
				usersinput.setUser_id(user_id);
				try {
					usersservice.hrmapselectedempdeleted(usersinput.getUser_id());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				hrMap.put("Avaliable", usersservice.hrmapavaliableemp(Long.parseLong(usersinput.getPed_id()),usersinput.getDomain_id()));
				hrMap.put("Selected", usersservice.hrmapselectedemp(Long.parseLong(usersinput.getPed_id()),usersinput.getDomain_id()));
			}
		}
		return hrMap;
	}

	@PostMapping("gethrmapemplist")
	public Map<String,Object> gethrmapemplist(@RequestBody Users usersinput) {
		Map<String,Object> hrMap=new HashMap<String,Object>();
		hrMap.put("Avaliable", usersservice.hrmapavaliableemp(Long.parseLong(usersinput.getPed_id()),usersinput.getDomain_id()));
		hrMap.put("Selected", usersservice.hrmapselectedemp(Long.parseLong(usersinput.getPed_id()),usersinput.getDomain_id()));
		return hrMap;
	}

	@PostMapping("addpeduser")
	public  Map<String,Object> addpeduser(@RequestBody Users usersinput){ 
		Map<String,Object> pedMap=new HashMap<String, Object>();
		usersservice.addpeduser(usersinput.getUser_id());
		Role roleinput=new Role();
		roleinput.setRolename("PED_USER");
		UserRoleMapping userrolemappinginput=new UserRoleMapping();
		Role roledata=roleservice.getrolename(roleinput.getRolename());
		userrolemappinginput.setRole_id(Long.toString(roledata.getRole_id()));
		userrolemappingservice.adduserrolemapping(userrolemappinginput.getRole_id(),Long.toString(usersinput.getUser_id()));
		pedMap.put("Ped",usersservice.getPedlist(usersinput.getDomain_id()));
		pedMap.put("NonPed",usersservice.getnonPedlist(usersinput.getDomain_id()));
		return pedMap;
	}

	@PostMapping("deletepeduser")
	public Map<String,Object> deletepeduser(@RequestBody Users usersinput){ 
		Map<String,Object> pedMap=new HashMap<String, Object>();
		usersservice.deletepeduser(usersinput.getUser_id().toString());
		usersservice.deletepeduserupdated(usersinput.getUser_id());
		Role roleinput=new Role();
		roleinput.setRolename("PED_USER");
		UserRoleMapping userrolemappinginput=new UserRoleMapping();
		Role roledata=roleservice.getrolename(roleinput.getRolename());
		userrolemappinginput.setRole_id(Long.toString(roledata.getRole_id()));
		userrolemappingservice.deleteuserrolemapping(userrolemappinginput.getRole_id(),Long.toString(usersinput.getUser_id()));
		pedMap.put("Ped",usersservice.getPedlist(usersinput.getDomain_id()));
		pedMap.put("NonPed",usersservice.getnonPedlist(usersinput.getDomain_id()));
		return pedMap;
	}

	@PostMapping("getpedlist")
	public  Map<String, Object> getpedlist(@RequestBody Users usersinput){ 
		Map<String,Object> pedMap=new HashMap<String, Object>();
		pedMap.put("Ped",usersservice.getPedlist(usersinput.getDomain_id()));
		pedMap.put("NonPed",usersservice.getnonPedlist(usersinput.getDomain_id()));
		return pedMap;
	}
}
