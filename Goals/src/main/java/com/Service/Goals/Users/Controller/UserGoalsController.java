package com.Service.Goals.Users.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UpdateUserScore;
import com.Service.Goals.Users.Entity.UserGoals;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Service.QuarterService;
import com.Service.Goals.Users.Service.UserGoalsService;
import com.Service.Goals.Users.Service.UserScoreService;
import com.Service.Goals.Users.Service.UsersService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserGoalsController {

	@Autowired
	UserGoalsService usergoalsservice;

	@Autowired
	QuarterService quarterservice;

	@Autowired
	UserScoreService userscoreservice;

	@Autowired
	UsersService usersservice;

	@PostMapping("getuserweights")
	public Map<String, Object> getuserWeight(@RequestBody UserGoals usergoalsinput) 
	{
		Map<String,Object> userweightsmap=new HashMap<String,Object>();
		List<UserGoals> usergoalslist = usergoalsservice.getuserWeights(usergoalsinput.getEmail_id(),usergoalsinput.getYear());
		Quarter quarterdate = quarterservice.getquarterdate(usergoalsinput.getYear(), usergoalsinput.getQuarter_name(), usergoalsinput.getDomain_id());
		userweightsmap.put("Weights",usergoalslist);
		userweightsmap.put("Flag", quarterdate);
		return userweightsmap;
	}

	@PostMapping("updateAllweights2")
	public ResponseEntity<String> updateAllweights(@RequestBody UpdateUserScore updateuserscore) 
	{
		List<UserGoals> usergoalsinput=updateuserscore.getUsergoals();
		Long quarter_id = (long)0;
		LocalDate datelocal=LocalDate.now();
		Month month=datelocal.getMonth();
		int month_num =month.getValue();
		//Users users=usersservice.getusername(Long.parseLong(usergoalsinput.get(0).getUser_id()));
		//Quarter quarter=quarterservice.findQuarteridbymonth(month_num,users.getDomain_id().toString());
		for(UserGoals usergoals:usergoalsinput) 
		{	
			if(quarter_id==0) {
				Users users=usersservice.getusername(Long.parseLong(usergoals.getUser_id()));
				Quarter quarter=quarterservice.findQuarteridbymonth(month_num,users.getDomain_id().toString());
				quarter_id=quarter.getQuarter_id();
				System.out.println(quarter_id);
			}
			String desc="";
			for(String goal_description:usergoals.getGoal_Descriptions()) {
				desc+=goal_description+";";
			}
			usergoals.setGoal_Description(desc);
			try 
			{
				usergoalsservice.updateAllweights(usergoals.getUser_id(), usergoals.getYear(), usergoals.getGoal_id(), usergoals.getWeights(), usergoals.getGoal_Description(), usergoals.getRm_id());
				userscoreservice.updateAllweights(usergoals.getUser_id(), usergoals.getYear(),quarter_id.toString(), usergoals.getGoal_id(), usergoals.getWeights(), usergoals.getGoal_Description(), usergoals.getRm_id());
			}catch (Exception e) 
			{
				System.out.println(e.getMessage());
				return new ResponseEntity<String>("Failed : "+e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<String>("Weights are updated Sucessfully", HttpStatus.OK);
	}

}
