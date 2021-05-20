package com.Service.Goals.Users.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.Goals;
import com.Service.Goals.Users.Repository.GoalsRepository;

@Service
public class GoalsService {

	@Autowired
	GoalsRepository goalsrepository;

	public Goals getgoalname(Long goal_id) {
		return goalsrepository.getgoalname(goal_id);
	}

	public Goals getgoal_id(String gapparameter) {
		return goalsrepository.getgoal_id(gapparameter);
	}

}
