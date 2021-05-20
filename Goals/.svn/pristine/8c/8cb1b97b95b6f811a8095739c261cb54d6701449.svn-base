package com.Service.Goals.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long>{

	@Query(value = "SELECT * FROM DOMAIN WHERE domain_id= ?1", nativeQuery = true)
	Domain getdomainid(String domain_id);

}
