package com.Service.Goals.Users.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.GoalDescription;
import com.Service.Goals.Users.Repository.GoalDescriptionRepository;

@Service
public class GoalDescriptionService {

	@Autowired
	GoalDescriptionRepository goaldescriptionrepository;

	public List<GoalDescription> getGoalsDescription() {
		return goaldescriptionrepository.findAll();
	}
}
