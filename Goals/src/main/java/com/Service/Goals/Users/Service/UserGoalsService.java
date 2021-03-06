package com.Service.Goals.Users.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.UserGoals;
import com.Service.Goals.Users.Repository.UserGoalsRepository;

@Service
public class UserGoalsService {

	@Autowired
	UserGoalsRepository usergoalsrepository;

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<UserGoals> getuserWeights(String email_id, String year) {

		List<UserGoals> usergoalslist=new ArrayList<UserGoals>();
		Connection conn = null;
		try {
			conn=jdbctemplate.getDataSource().getConnection();
			CallableStatement statement = conn.prepareCall("{call usp_usergoalinsert(?,?)}");
			statement.setString(1, email_id);
			statement.setString(2, year);

			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String user_id=rs.getString("user_id");
				String username=rs.getString("username");
				String goal_id=rs.getString("goal_id");
				String goal_name=rs.getString("goal_name");
				String description=rs.getString("description");
				String weights=rs.getString("weights");

				UserGoals usergoals=new UserGoals();
				usergoals.setUser_id(user_id);
				usergoals.setEmail_id(email_id);
				usergoals.setUsername(username);
				usergoals.setGoal_id(goal_id);
				usergoals.setGoal_name(goal_name);
				if(description!=null) {
					usergoals.setGoal_Description(description);
					usergoals.setGoal_Descriptions(description.split(";"));
				}
				Double str1 = new Double(weights);
				usergoals.setWeights(str1);
				usergoals.setYear(year);
				usergoalslist.add(usergoals);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return usergoalslist;
	}

	public UserGoals findusergoals(String user_id, String year, String goal_id) {
		return usergoalsrepository.findusergoals(user_id,year,goal_id);
	}

	public UserGoals updateAllweights(String user_id, String year, String goal_id, Double weights, String goals_description,String rm_id) {
		System.out.println(user_id+" "+year+" "+goal_id+" "+" "+weights+" "+goals_description+" "+ rm_id);
		UserGoals usergoals=findusergoals(user_id, year,goal_id);
		if (usergoals != null) 
		{
			usergoals.setWeights(weights);
			usergoals.setWeight_update_by(rm_id);
			LocalDateTime date = LocalDateTime.now();
			System.out.println(date);
			usergoals.setWeight_update_date(date.toString());
			usergoals.setGoal_Description(goals_description);
			System.out.println(usergoals.getGoal_Description());
			System.out.println(usergoals);
			return usergoalsrepository.save(usergoals);
		}		
		else {
			usergoals=new UserGoals();
			return usergoals;
		}

	}	
}
