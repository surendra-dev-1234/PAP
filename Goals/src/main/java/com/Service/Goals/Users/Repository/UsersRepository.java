package com.Service.Goals.Users.Repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long>{

	@Query(value = "SELECT * FROM USERS WHERE email_id= ?1 order by username", nativeQuery = true)
	Users findbyemail(String email);

	@Query(value = "SELECT * FROM USERS WHERE user_id= (SELECT rm_id FROM USERS WHERE user_id=?1) order by username", nativeQuery = true)
	Users findbyuserid(Long user_id);

	@Query(value="Select * from Users where domain_id = ?1 and rm_id=?2 order by username", nativeQuery = true)
	List<Users> getuserdetails(String domainid,String rm_id);

	@Query(value="Select * from Users where domain_id = ?1 order by username", nativeQuery = true)
	List<Users> getuserdetails(String domain_id);

	@Modifying
	@Query(value="UPDATE Users SET Is_PED_Flag = 1 where user_id=?1")
	@Transactional
	public int addpeduser(Long user_id);

	@Query(value="Select * from Users where Is_PED_Flag =1 and domain_id=?1 order by username", nativeQuery = true)
	List<Users> getPedlist(String domain_id);

	@Query(value="Select * from Users where (Is_PED_Flag =0 or Is_PED_Flag is null) and domain_id=?1 order by username", nativeQuery = true)
	List<Users> getnonPedlist(String domain_id);

	@Modifying
	@Query(value="UPDATE Users SET ped_id= Null where ped_id=?1")
	@Transactional
	int deletepeduser(String user_id);

	@Modifying
	@Query(value="UPDATE Users SET Is_PED_Flag = 0 where user_id=?1")
	@Transactional
	int deletepeduserupdated(Long user_id);

	@Modifying
	@Query(value="UPDATE Users SET Is_MIS_Flag = 1 where user_id=?1")
	@Transactional
	int addmisuser(Long user_id);

	@Query(value="Select * from Users where Is_MIS_Flag =1  and domain_id=?1 order by username", nativeQuery = true)
	List<Users> getMislist(String domain_id);

	@Query(value="Select * from Users where (Is_MIS_Flag =0 or Is_MIS_Flag is null)  and domain_id=?1 order by username", nativeQuery = true)
	List<Users> getnonMislist(String domain_id);

	@Modifying
	@Query(value="UPDATE Users SET Is_MIS_Flag = 0 where user_id=?1")
	@Transactional
	int deletemisuser(Long user_id);

	@Modifying
	@Query(value="UPDATE Users SET Is_Freeze_Flag = 1 where user_id=?1")
	@Transactional
	int freeze(Long user_id);

	@Query(value="Select * from Users where Is_Freeze_Flag =1  and domain_id=2 order by username", nativeQuery = true)
	List<Users> getFreezelist();


	@Query(value="Select * from Users where (Is_Freeze_Flag =0 or Is_Freeze_Flag is null) and domain_id=2 order by username", nativeQuery = true)
	List<Users> getunFreezelist();

	@Modifying
	@Query(value="UPDATE Users SET Is_Freeze_Flag = 0 where user_id=?1")
	@Transactional
	int unfreeze(Long user_id);

	@Query(value="Select * from Users where ped_id is NULL or ped_id= 0 and user_id!=?1 and domain_id=?2 order by username", nativeQuery = true)
	List<Users> hrmapavaliableemp(Long user_id, String domain_id);

	@Modifying
	@Query(value="UPDATE Users SET ped_id=?1 where user_id=?2")
	@Transactional
	int hrmapselectedempupdate(String ped_id,Long user_id);

	@Modifying
	@Query(value="UPDATE Users SET ped_id = 0 where user_id=?2")
	@Transactional
	int hrmapselectedempdeleted(String fiter, Long user_id);	

	@Query(value="Select * from Users where ped_id=?1 and domain_id=?2 order by username", nativeQuery = true)
	List<Users> hrmapselectedemp(Long user_id, String domain_id);

	@Modifying
	@Query(value="UPDATE Users SET ped_id=NULL where ped_id=?1")
	@Transactional
	int hrmapdefaultemp(String user_id);

	@Modifying
	@Query(value="UPDATE Users SET ped_id=NULL where user_id=?1")
	@Transactional
	int hrmapselectedempdeleted(Long user_id);

	@Query(value="Select * from Users where user_id=?1 order by username", nativeQuery = true)
	List<Users> getuser(long user_id);

	@Query(value="Select * from Users where user_id=?1", nativeQuery = true)
	Users getusername(long user_id);

	@Query(value="Select * from Users where ped_id=?1", nativeQuery = true)
	List<Users> getpeduseremployees(String ped_id);
}




