package com.Service.Goals.Users.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Goals.Users.Entity.FinalScore;
import com.Service.Goals.Users.Entity.PedScore;
import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Repository.FinalScoreRepository;
import com.Service.Goals.Users.Repository.QuarterRepository;
import com.Service.Goals.Users.Repository.UserScoreRepository;
import com.Service.Goals.Users.Service.PedScoreService;
import com.Service.Goals.Users.Service.UsersService;

import Services.EmailNotificationService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class PEDController {

	@Autowired
	UserScoreRepository userscorerepository;

	@Autowired
	PedScoreService pedscoreservice;

	@Autowired
	FinalScoreRepository finalscorerepository;

	@Autowired
	UsersService usersservice;

	@Autowired
	QuarterRepository quarterrepository;

	//	@PostMapping("getyearlyscore")
	//	public Map<String,Object> getyearlyscore(@RequestBody PedScore pedscoreinput) {
	//		Map<String,Object> yearlyMap=new HashMap<String,Object>();
	//		Double avg_self_score=0.0,avg_rm_score=0.0,goal_1_selfscore_avg=0.0,goal_2_selfscore_avg=0.0,goal_3_selfscore_avg=0.0,goal_4_selfscore_avg=0.0,goal_5_selfscore_avg=0.0,goal_1_rmscore_avg=0.0,goal_2_rmscore_avg=0.0,goal_3_rmscore_avg=0.0,goal_4_rmscore_avg=0.0,goal_5_rmscore_avg=0.0;
	//		List<Double> goal_1_selfscore=new ArrayList<Double>();
	//		List<Double> goal_2_selfscore=new ArrayList<Double>();
	//		List<Double> goal_3_selfscore=new ArrayList<Double>();
	//		List<Double> goal_4_selfscore=new ArrayList<Double>();
	//		List<Double> goal_5_selfscore=new ArrayList<Double>();
	//		List<Double> goal_1_rmscore=new ArrayList<Double>();
	//		List<Double> goal_2_rmscore=new ArrayList<Double>();
	//		List<Double> goal_3_rmscore=new ArrayList<Double>();
	//		List<Double> goal_4_rmscore=new ArrayList<Double>();
	//		List<Double> goal_5_rmscore=new ArrayList<Double>(); 
	//		List<Double> goal_selfscores=new ArrayList<Double>(); 
	//	    List<Double> goal_rmscores=new ArrayList<Double>(); 
	//		Set<String> goal_names=new HashSet<String>();
	//		List<UserScore> userscorelist=userscorerepository.findbyyearly(pedscoreinput.getUser_id(),pedscoreinput.getYear());
	//		System.out.println("size"+userscorelist.size());
	//		for(UserScore userscore:userscorelist) {
	//			if(userscore.getSelf_score() == null) {
	//				userscore.setSelf_score(0.0);
	//			}
	//			if(userscore.getRm_score() == null) {
	//				userscore.setRm_score(0.0);
	//			}
	//			goal_names.add(userscore.getGoals().getName());
	//			if((userscore.getQuarter_name().equals("Inclusive"))
	//				||(userscore.getQuarter_id().equals("11")||userscore.getQuarter_id().equals("15"))
	//				||(userscore.getQuarter_id().equals("12")||userscore.getQuarter_id().equals("16"))||
	//				(userscore.getQuarter_id().equals("10")||userscore.getQuarter_id().equals("14"))){
	//				if(userscore.getGoal_id().equals("1")||userscore.getGoal_id().equals("6")) {
	//					  goal_1_selfscore.add(userscore.getSelf_score()/4);
	//						goal_1_rmscore.add(userscore.getRm_score()/4);
	//				}
	//				if(userscore.getGoal_id().equals("2")||userscore.getGoal_id().equals("7")) {
	//					  goal_2_selfscore.add(userscore.getSelf_score()/4);
	//						goal_2_rmscore.add(userscore.getRm_score()/4);
	//				}
	//				if(userscore.getGoal_id().equals("3")||userscore.getGoal_id().equals("8")) {
	//					  goal_3_selfscore.add(userscore.getSelf_score()/4);
	//						goal_3_rmscore.add(userscore.getRm_score()/4);
	//				}
	//				if(userscore.getGoal_id().equals("4")||userscore.getGoal_id().equals("9")) {
	//					  goal_4_selfscore.add(userscore.getSelf_score()/4);
	//						goal_4_rmscore.add(userscore.getRm_score()/4);
	//				}
	//				if(userscore.getGoal_id().equals("5")||userscore.getGoal_id().equals("10")) {
	//					  goal_5_selfscore.add(userscore.getSelf_score()/4);
	//						goal_5_rmscore.add(userscore.getRm_score()/4);
	//				}
	//			}
	//		}
	//		
	//		for(Double goal1_self :goal_1_selfscore) {
	//			goal_1_selfscore_avg += goal1_self;
	//		}
	//		for(Double goal2_self :goal_2_selfscore) {
	//			goal_2_selfscore_avg += goal2_self;
	//		}
	//		for(Double goal3_self :goal_3_selfscore) {
	//			goal_3_selfscore_avg += goal3_self;
	//		}
	//		for(Double goal4_self :goal_4_selfscore) {
	//			goal_4_selfscore_avg += goal4_self;
	//		}
	//		for(Double goal5_self :goal_5_selfscore) {
	//			goal_5_selfscore_avg += goal5_self;
	//		}
	//		for(Double goal1_rm :goal_1_rmscore) {
	//			goal_1_rmscore_avg += goal1_rm;
	//		}
	//		for(Double goal2_rm :goal_2_rmscore) {
	//			goal_2_rmscore_avg += goal2_rm;
	//		}
	//		for(Double goal3_rm :goal_3_rmscore) {
	//			goal_3_rmscore_avg += goal3_rm;
	//		}
	//		for(Double goal4_rm :goal_4_rmscore) {
	//			goal_4_rmscore_avg += goal4_rm;
	//		}
	//		for(Double goal5_rm :goal_5_rmscore) {
	//			goal_5_rmscore_avg += goal5_rm;
	//		}
	//		goal_selfscores.add(goal_1_selfscore_avg);
	//		goal_selfscores.add(goal_2_selfscore_avg);
	//		goal_selfscores.add(goal_3_selfscore_avg);
	//		goal_selfscores.add(goal_4_selfscore_avg);
	//		goal_selfscores.add(goal_5_selfscore_avg);
	//		goal_rmscores.add(goal_1_selfscore_avg);
	//		goal_rmscores.add(goal_2_selfscore_avg);
	//		goal_rmscores.add(goal_3_selfscore_avg);
	//		goal_rmscores.add(goal_4_selfscore_avg);
	//		goal_rmscores.add(goal_5_selfscore_avg);
	//		avg_self_score=(goal_1_selfscore_avg+goal_2_selfscore_avg+goal_3_selfscore_avg+goal_4_selfscore_avg+goal_5_selfscore_avg)/5;
	//		avg_rm_score=(goal_1_rmscore_avg+goal_2_rmscore_avg+goal_3_rmscore_avg+goal_4_rmscore_avg+goal_5_rmscore_avg)/5;
	//		PedScore pedscore=new PedScore();
	//		pedscore.setGoal_names(goal_names);
	//		pedscore.setGoal_selfscores(goal_selfscores);
	//		pedscore.setGoal_rmscores(goal_rmscores);
	//		pedscore.setSelfscore_avg(avg_self_score);
	//		pedscore.setRmscore_avg(avg_rm_score);
	//		PedScore pedScore=pedscoreservice.updatepedscore(pedscoreinput);
	//		yearlyMap.put("yearly", pedscore);
	//		yearlyMap.put("pedscore", pedScore);
	//		return yearlyMap;
	//	}

	@PostMapping("getpeduseremployees")
	public List<Users> getpeduseremployees(@RequestBody Users usersinput){
		return pedscoreservice.getpeduseremployees(usersinput.getPed_id());
	}

	@PostMapping("getquarterlyscore")
	public Map<String,Object> getquarterlyscore(@RequestBody FinalScore finalscoreinput) {
		Map<String,Object> quarterlymap=new HashMap<String,Object>();
		List<FinalScore> finalscorelist=finalscorerepository.findfinalscore(finalscoreinput.getUser_id(), finalscoreinput.getYear());
		Users user=usersservice.findbyuserid(Long.parseLong(finalscoreinput.getUser_id()));
		Double finalselfavg=finalscorerepository.findfinalselfscoreavg(finalscoreinput.getUser_id(), finalscoreinput.getYear());
		Double finalrmavg=finalscorerepository.findfinalrmscoreavg(finalscoreinput.getUser_id(), finalscoreinput.getYear());
		quarterlymap.put("quarterlyscores", finalscorelist);
		quarterlymap.put("selfscoreavg", finalselfavg);
		quarterlymap.put("rmscoreavg", finalrmavg);
		quarterlymap.put("rmname", user.getUsername());
		return quarterlymap;
	}
}
