package com.Service.Goals.Users.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.UserRoleMapping;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long>{

	@Modifying
	@Query(value="INSERT into User_Role_Mapping (role_id,user_id) values (?1,?2)", nativeQuery = true)
	@Transactional
	void adduserrolemapping(String role_id, String user_id);

	@Modifying
	@Query(value="DELETE from User_Role_Mapping where role_id=?1 AND user_id=?2", nativeQuery = true)
	@Transactional
	void deleteuserrolemapping(String role_id, String user_id);

}
