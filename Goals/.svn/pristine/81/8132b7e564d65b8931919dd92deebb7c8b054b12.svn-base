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
import com.Service.Goals.Users.Entity.PedScore;
import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UpdateUserScore;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Repository.UserScoreRepository;
import com.Service.Goals.Users.Service.FinalScoreService;
import com.Service.Goals.Users.Service.PedScoreService;
import com.Service.Goals.Users.Service.QuarterService;
import com.Service.Goals.Users.Service.UserScoreService;
import com.Service.Goals.Users.Service.UsersService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserScoreController {

	@Autowired
	UsersService usersservice;

	@Autowired
	UserScoreService userscoreservice;

	@Autowired
	FinalScoreService finalscoreservice;

	@Autowired
	QuarterService quarterservice;

	@Autowired
	PedScoreService pedscoreservice;

	@PostMapping("getuserdetails")
	public List<Users> getuserdetails(@RequestBody Users userdetails) {
		List<Users> userslist=new ArrayList<Users>();
		System.out.println(!userdetails.getRm_id().equals(""));
		if(!userdetails.getRm_id().equals("") && !userdetails.getRm_id().equals(null)) {
			userslist=usersservice.getuserdetails(userdetails.getDomain_id(), userdetails.getRm_id());
		}
		else {
			userslist=usersservice.getuserdetails(userdetails.getDomain_id());
		}
		return userslist;
	}

	@PostMapping("getuserscore")
	public Map<String, Object> getuserscore(@RequestBody UserScore usere) 
	{
		Map<String, Object> responseMap = new HashMap<String, Object>();
		List<UserScore> userscorelist = userscoreservice.getuserscore(usere.getEmail_id(), usere.getYear(), usere.getQuarter_name(), usere.getDomain_id(),usere.getFlag() );
		System.out.println("id"+userscorelist.get(0).getUser_id());
		Quarter quarterdate = quarterservice.getquarterdate(usere.getYear(), usere.getQuarter_name(), usere.getDomain_id());
		System.out.println(quarterdate);
		FinalScore finalscore = finalscoreservice.findfinalscore(userscorelist.get(0).getUser_id(), usere.getYear(),userscorelist.get(0).getQuarter_id());		
		responseMap.put("Scores",userscorelist);
		responseMap.put("Flag", quarterdate);
		if(finalscore!=null) 
		{
			responseMap.put("Finalscore", finalscore);
		}
		else 
		{
			finalscore=new FinalScore();
			responseMap.put("Finalscore", finalscore);
		}

		return responseMap;
	}

	@PostMapping("updateselfscore")
	public ResponseEntity<String> updateselfscore(@RequestBody UpdateUserScore updateuserscore) 
	{
		try
		{
			List<UserScore> userscorelist = updateuserscore.getUserscore();
			Double selfscorefinal=0.0;
			String selfcommentfinal="";
			Integer count = userscorelist.size();
			for(UserScore userscore:userscorelist) 
			{
				System.out.println("score:"+userscore.getSelf_score()+"comment:"+userscore.getSelf_comment());
				selfscorefinal +=userscore.getSelf_score()/count;
				selfcommentfinal +=userscore.getSelf_comment()+";";
				userscoreservice.updateselfscore(userscore.getUser_id(), userscore.getYear(),userscore.getQuarter_id(), userscore.getGoal_id(),userscore.getSelf_score(),userscore.getSelf_comment());
			}
			System.out.println(selfscorefinal);
			System.out.println(selfcommentfinal);
			try {
				if(finalscoreservice.findfinalscore(userscorelist.get(0).getUser_id(), userscorelist.get(0).getYear(), userscorelist.get(0).getQuarter_id())!=null) {
					finalscoreservice.updatefinalselfscoreexists(userscorelist.get(0).getUser_id(), userscorelist.get(0).getYear(), userscorelist.get(0).getQuarter_id(),selfscorefinal,selfcommentfinal);
				}
				else {
					finalscoreservice.updatefinalselfscore(userscorelist.get(0).getUser_id(), userscorelist.get(0).getYear(), userscorelist.get(0).getQuarter_id(), selfscorefinal,selfcommentfinal);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return new ResponseEntity<String>("SelfScores are updated Sucessfully", HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Failed"+e.getMessage(), HttpStatus.OK);
		}	
	}

	@PostMapping("updatermscore")
	public ResponseEntity<String> updatermscore(@RequestBody UpdateUserScore updateuserscore) 
	{
		try
		{
			List<UserScore> userscorelist = updateuserscore.getUserscore();
			UserScore score=new UserScore();
			Double rmscorefinal=0.0;
			String rmcommentfinal="";
			Integer count = userscorelist.size();
			System.out.println(count);
			for(UserScore userscore:userscorelist) 
			{
				System.out.println(userscore.getGoal_id());
				System.out.println("score:"+userscore.getRm_score()+"comment:"+userscore.getRm_comment());
				rmscorefinal +=userscore.getRm_score()/count;
				rmcommentfinal +=userscore.getRm_comment()+";";
				userscoreservice.updatermscore(userscore.getUser_id(), userscore.getYear(),userscore.getQuarter_id(), userscore.getGoal_id(),userscore.getRm_id(),userscore.getRm_score(),userscore.getRm_comment());
			}
			System.out.println(rmscorefinal);
			try {
				if(finalscoreservice.findfinalscore(userscorelist.get(0).getUser_id(), userscorelist.get(0).getYear(), userscorelist.get(0).getQuarter_id())!=null) {
					finalscoreservice.updatefinalrmscoreexists(userscorelist.get(0).getUser_id(), userscorelist.get(0).getYear(), userscorelist.get(0).getQuarter_id(),userscorelist.get(0).getRm_id(),rmscorefinal,rmcommentfinal);
				}
				else {
					finalscoreservice.updatefinalrmscore(userscorelist.get(0).getUser_id(), userscorelist.get(0).getYear(), userscorelist.get(0).getQuarter_id(), userscorelist.get(0).getRm_id(),rmscorefinal,rmcommentfinal);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return new ResponseEntity<String>("RmScores are updated Sucessfully", HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Failed"+e.getMessage(), HttpStatus.OK);
		}
	}

	@PostMapping("updateAllweights")
	public ResponseEntity<String> updateAllWeights(@RequestBody UpdateUserScore updateuserscore){
		System.out.println(updateuserscore);
		List<UserScore> userscorelist = updateuserscore.getUserscore();
		for (int i = 0; i < userscorelist.size(); i++) 
		{
			//System.out.println("values" + i);
			UserScore usajson = userscorelist.get(i);
			//System.out.println(usajson.getGoal_Descriptions());
			int length=0;
			length=usajson.getGoal_Descriptions().length;
			System.out.print(length+" ");
			String desc="";
			for(String goal_description:usajson.getGoal_Descriptions()) {
				desc+=goal_description+";";
			}
			System.out.println(desc);
			usajson.setGoal_Description(desc);
			try
			{
				userscoreservice.updateAllweights(usajson.getUser_id(), usajson.getYear(),usajson.getQuarter_id(), usajson.getGoal_id(),usajson.getWeights(),usajson.getGoal_Description(),usajson.getRm_id());
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				return new ResponseEntity<String>("Failed : "+e.getMessage(), HttpStatus.NOT_FOUND);
			}	
		}
		return new ResponseEntity<String>("Weights are updated Sucessfully", HttpStatus.OK);
	}


	@PostMapping("updatepedscore")
	public ResponseEntity<String> updatepedscore(@RequestBody PedScore pedscoreinput){
		try {

			pedscoreservice.updatepedscore(pedscoreinput);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Failed", HttpStatus.OK);
		}
		//}
		return new ResponseEntity<String>("Weights are updated Sucessfully", HttpStatus.OK);
	}
}
