package com.Service.Goals.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.Goals;

@Repository
public interface GoalsRepository extends JpaRepository<Goals,Long >{

	@Query(value="Select * from goals where goal_id=?1 ;" , nativeQuery = true)
	Goals getgoalname(Long goal_id);

	@Query(value="Select * from goals where name=?1 ;" , nativeQuery = true)
	Goals getgoal_id(String gapparameter);

}
