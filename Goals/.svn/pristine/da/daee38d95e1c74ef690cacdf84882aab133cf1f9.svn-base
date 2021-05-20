package com.Service.Goals.Users.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	UsersRepository usersrepository;

	public Users findbyemail(String email_id) {
		return usersrepository.findbyemail(email_id);
	}

	public Users findbyuserid(Long user_id) {
		return usersrepository.findbyuserid(user_id);
	}

	public List<Users>getuserdetails(String domain_id,String rm_id){
		List<Users> userslist=usersrepository.getuserdetails(domain_id, rm_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public Users getuserpermission(String email_id, String username) {
		Users userPermission=new Users();
		Connection conn=null;
		try {
			conn=jdbctemplate.getDataSource().getConnection();
			CallableStatement statement = conn.prepareCall("{call usp_userinsert(?,?)}");

			statement.setString(1, email_id);
			statement.setString(2, username);

			ResultSet rs=statement.executeQuery();
			String roleName="";

			while(rs.next()) {
				String user_id=rs.getString("user_id");
				String Username=rs.getString("username");
				String rolename=rs.getString("rolename");
				String domain_name=rs.getString("domain_name");
				String domain_id=rs.getString("domain_id");

				Users userde= new Users();
				userde.setUser_id(Long.parseLong(user_id));
				userde.setEmail_id(email_id);
				userde.setUsername(Username);
				userde.setRole_name(rolename);
				userde.setDomain_name(domain_name);
				userde.setDomain_id(domain_id);

				userPermission.setUser_id(userde.getUser_id());
				userPermission.setEmail_id(userde.getEmail_id());
				userPermission.setUsername(userde.getUsername());
				roleName+=userde.getRole_name()+",";
				userPermission.setRole_name(roleName);
				userPermission.setDomain_name(userde.getDomain_name() );
				userPermission.setDomain_id(userde.getDomain_id());
				userPermission.setLogo(userde.getLogo());

				if(userde.getRole_name().equals("LEVEL3_USER")) {
					userPermission.setLevel3_user(true);
				}

				if(userde.getRole_name().equals("LEVEL2_USER")) {
					userPermission.setLevel2_user(true);
				}

				if(userde.getRole_name().equals("LEVEL1_USER")) {
					userPermission.setLevel1_user(true);
				}

				if(userde.getRole_name().equals("HR")) {
					userPermission.setHr(true);
				}
				if(userde.getRole_name().equals("MIS_USER")) {
					userPermission.setMis_user(true);
				}
				if(userde.getRole_name().equals("PED_USER")) {
					userPermission.setPed_user(true);
				}
				if(userde.getRole_name().equals("UNFREEZE_USER")) {
					userPermission.setUnfreeze(true);
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userPermission;
	}

	public List<Users> getPedlist(String domain_id) {
		List<Users> userslist=usersrepository.getPedlist(domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public List<Users> getnonPedlist(String domain_id) {
		List<Users> userslist=usersrepository.getnonPedlist(domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public int addpeduser(Long user_id) {
		return usersrepository.addpeduser(user_id);
	}

	public int deletepeduser(String user_id) {
		return usersrepository.deletepeduser(user_id);
	}

	public int deletepeduserupdated(Long user_id) {
		return usersrepository.deletepeduserupdated(user_id);
	}

	public List<Users> getMislist(String domain_id) {
		List<Users> userslist=usersrepository.getMislist(domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public List<Users> getnonMislist(String domain_id) {
		List<Users> userslist=usersrepository.getnonMislist(domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public int addmisuser(Long user_id) {
		return usersrepository.addmisuser(user_id);
	}

	public int deletemisuser(Long user_id) {	
		return usersrepository.deletemisuser(user_id);
	}

	public List<Users> getFreezelist() {
		List<Users> userslist=usersrepository.getFreezelist();
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public List<Users> getunFreezelist() {
		List<Users> userslist=usersrepository.getunFreezelist();
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public int freeze(Long user_id) {
		return usersrepository.freeze(user_id);		
	}

	public int unfreeze(Long user_id) {
		return usersrepository.unfreeze(user_id);		
	}

	public int hrdefaultemp(String user_id) {
		return usersrepository.hrmapdefaultemp(user_id);
	}

	public List<Users> hrmapavaliableemp(Long user_id, String domain_id) {
		List<Users> userslist=usersrepository.hrmapavaliableemp(user_id,domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}
			newuserslist.add(users);
		}
		return newuserslist;
	}

	public List<Users> hrmapselectedemp(Long user_id, String domain_id) {
		List<Users> userslist=usersrepository.hrmapselectedemp(user_id,domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}

	public int hrmapselectedempupdate(String ped_id,Long user_id) {
		return usersrepository.hrmapselectedempupdate(ped_id, user_id);
	}


	public int hrmapselectedempdeleted(Long user_id) {
		return usersrepository.hrmapselectedempdeleted(user_id);
	}

	public List<Users> getuser(long user_id) {
		List<Users> userslist=usersrepository.getuser(user_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist){
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}
			newuserslist.add(users);
		}
		return usersrepository.getuser(user_id);
	}

	public Users getusername(long user_id) {
		Users users=usersrepository.getusername(user_id);
		if(users.getRm_id()==null) {
			users.setRm_id("");
		}
		if(users.getRm_valid_from()==null) {
			users.setRm_valid_from("");
		}
		if(users.getRm_valid_to()==null) {
			users.setRm_valid_to("");
		}
		if(users.getPed_id()==null) {
			users.setPed_id("");
		}
		if(users.getPed_valid_from()==null) {
			users.setPed_valid_from("");
		}
		if(users.getPed_valid_to()==null) {
			users.setPed_valid_to("");
		}
		if(users.getIs_ped_flag()==null) {
			users.setIs_ped_flag("");
		}
		if(users.getIs_mis_flag()==null) {
			users.setIs_mis_flag("");
		}
		if(users.getIs_freeze_flag()==null) {
			users.setIs_freeze_flag("");
		}
		if(users.getIs_freeze_flag()==null) {
			users.setIs_freeze_flag("");
		}
		if(users.getEmp_Id()==null) {
			users.setEmp_Id("");
		}
		if(users.getLogo()==null) {
			users.setLogo("");
		}
		return users;
	}

	public List<Users> getuserdetails(String domain_id) {
		List<Users> userslist=usersrepository.getuserdetails(domain_id);
		List<Users> newuserslist= new ArrayList<Users>();
		for(Users users:userslist) {
			if(users.getRm_id()==null) {
				users.setRm_id("");
			}
			if(users.getRm_valid_from()==null) {
				users.setRm_valid_from("");
			}
			if(users.getRm_valid_to()==null) {
				users.setRm_valid_to("");
			}
			if(users.getPed_id()==null) {
				users.setPed_id("");
			}
			if(users.getPed_valid_from()==null) {
				users.setPed_valid_from("");
			}
			if(users.getPed_valid_to()==null) {
				users.setPed_valid_to("");
			}
			if(users.getIs_ped_flag()==null) {
				users.setIs_ped_flag("");
			}
			if(users.getIs_mis_flag()==null) {
				users.setIs_mis_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getIs_freeze_flag()==null) {
				users.setIs_freeze_flag("");
			}
			if(users.getEmp_Id()==null) {
				users.setEmp_Id("");
			}
			if(users.getLogo()==null) {
				users.setLogo("");
			}

			newuserslist.add(users);
		}
		return newuserslist;
	}
}
