package com.Service.Goals.Users.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.UserGoals;
import com.Service.Goals.Users.Entity.UserScore;

@Repository
public interface UserGoalsRepository extends JpaRepository<UserGoals,Long>{

	@Query(value = "SELECT * FROM USER_GOALS WHERE user_id= ?1 and year= ?2 and goal_id= ?3 ;", nativeQuery = true)
	UserGoals findusergoals(String user_id, String year, String goal_id);
}
