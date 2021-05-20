package com.Service.Goals.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{


	@Query(value = "SELECT * FROM Role WHERE rolename= ?1", nativeQuery = true)
	Role getrolename(String role_name);

}
