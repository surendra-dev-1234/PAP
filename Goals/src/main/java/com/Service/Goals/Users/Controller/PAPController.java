package com.Service.Goals.Users.Controller;

import java.util.ArrayList;
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

import com.Service.Goals.Users.Entity.FinalScore;
import com.Service.Goals.Users.Entity.GoalDescription;
import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UpdateUserScore;
import com.Service.Goals.Users.Entity.UserGoals;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Exception.UserEmptyNullException;
import com.Service.Goals.Users.Exception.UserNotFoundException;
import com.Service.Goals.Users.Repository.UserGoalsRepository;
import com.Service.Goals.Users.Service.FinalScoreService;
import com.Service.Goals.Users.Service.GoalDescriptionService;
import com.Service.Goals.Users.Service.QuarterService;
import com.Service.Goals.Users.Service.UnfreezeService;
import com.Service.Goals.Users.Service.UserGoalsService;
import com.Service.Goals.Users.Service.UserScoreService;
import com.Service.Goals.Users.Service.UsersService;


@RestController
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200","http://15.207.231.163:4200","http://localhost:3005", "http://15.207.231.163:4200","http://15.206.224.193:3005/"})
@CrossOrigin(origins="*", allowedHeaders="*")
//@CrossOrigin({"${client.url1}", "${client.url2}","${client.url3}", "${client.url4}","${client.url5}","${client.url6}"})
public class PAPController {

	@Autowired
	UsersService usersservice;

	@Autowired
	UserScoreService userscoreservice;

	@Autowired
	QuarterService quarterservice;

	@Autowired
	FinalScoreService finalscoreservice;

	@Autowired
	GoalDescriptionService goaldescriptionservice;

	@Autowired
	UnfreezeService unfreezeservice;

	//	@PostMapping("getallusers")
	//	public Users getfindbyemail(@RequestBody Users userdetails) {
	//		String email=userdetails.getEmail_id();
	//		return repo.findbyemail(email);
	//	}

	//	@PostMapping("getquaterdetails")
	//	public List<Quarter> getquaterdetails(@RequestBody Quarter quarter) {
	//		String domain_id = quarter.getDomain_id();
	//		return quarterservice.getquaterdetails(domain_id);
	//	}

	@PostMapping("getquarterrecords")
	public List<Quarter> getquarterrecord(@RequestBody Quarter quarter) {
		return quarterservice.getquarterrecord(quarter.getYear(),quarter.getDomain_id());
	}

	@PostMapping("getuserpermission")
	public ResponseEntity<Users> getuserpermission(@RequestBody Users userd)
			throws UserEmptyNullException, UserNotFoundException {
		String email_id = userd.getEmail_id();
		String username = userd.getUsername();
		Users userPermission = new Users();
		if ((email_id.equals("") && username.equals("")) || ((email_id == null) && username == null)) {
			System.out.println("null");
			throw new UserEmptyNullException("Emailid and Username are required.");
		} else {
			Users user = usersservice.getuserpermission(email_id, username);
			userPermission = user;
			return ResponseEntity.ok(userPermission);
		}
	}

	@PostMapping("getgoaldescription")
	public Map<String,List<GoalDescription>> getGoalDescription() {
		List<GoalDescription> goaldescriptionlist=goaldescriptionservice.getGoalsDescription();
		Map<String,List<GoalDescription>> goaldescriptionMap= new HashMap<String,List<GoalDescription>>();
		List<GoalDescription> goaldesclist=null;
		for(GoalDescription goaldescription:goaldescriptionlist) 
		{
			if(goaldescriptionMap.get(goaldescription.getGoal_id())!=null) {
				System.out.println(goaldescriptionMap.get(goaldescription.getGoal_id()));
				goaldesclist = goaldescriptionMap.get(goaldescription.getGoal_id());	
			}
			else{
				goaldesclist=new ArrayList<GoalDescription>();
			}
			goaldesclist.add(goaldescription);
			goaldescriptionMap.put(goaldescription.getGoal_id(), goaldesclist);
		}
		System.out.println(goaldescriptionMap);
		return goaldescriptionMap;
	}
}
