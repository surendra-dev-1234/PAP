package com.Service.Goals.Users.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.Goals;
import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Repository.UserScoreRepository;


@Service
public class UserScoreService {

	@Autowired
	UserScoreRepository userscorerepository;

	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	QuarterService quarterservice;

	@Autowired
	UsersService usersservice;

	@Autowired
	GoalsService goalsservice;

	@Autowired
	FinalScoreService finalscoreservice;

	public List<UserScore> getuserscore(String email_id, String year, String quarter_name, String domain_id,String flag) 
	{
		System.out.println("inuser");
		List<UserScore> userscorelist = new ArrayList<UserScore>();
		userscorelist=UserScoreData(email_id, year, quarter_name, domain_id,flag);
		return userscorelist;
	}

	public UserScore updateAllweights(String user_id, String year, String quarter_id, String goal_id, Double weights, String goals_description,String rm_id) {
		UserScore uscore=userscorerepository.findbyuser_id(user_id, year, quarter_id, goal_id);
		if (uscore != null) 
		{
			System.out.println(uscore);
			uscore.setWeights(weights);
			uscore.setWeight_update_by(rm_id);
			uscore.setGoal_Description(goals_description);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			System.out.println(currentDate);
			uscore.setWeight_update_date(currentDate);
		}		

		return userscorerepository.save(uscore);
	}

	//	public UserScore updateWeights(String user_id, String year, String quarter_id, String goal_id,
	//		Double weights, String rm_id) {
	//		UserScore userscore=userscorerepository.findbyuser_id2(user_id, year, quarter_id, goal_id);
	//		userscore.setUser_id(user_id);
	//		userscore.setGoal_id(goal_id);
	//		userscore.setYear(year);
	//		userscore.setQuarter_id(quarter_id);
	//		userscore.setWeights(weights);
	//		userscore.setWeight_update_by(rm_id);
	//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	//		LocalDateTime now = LocalDateTime.now();
	//		String currentDate = dtf.format(now);
	//		System.out.println(currentDate);
	//		userscore.setWeight_update_date(currentDate);
	//		userscorerepository.save(userscore);
	//		return userscore;
	//	}

	public UserScore updateselfscore(String user_id, String year, String quarter_id, String goal_id,Double self_score, String self_comment) {
		List<UserScore> newscorelist=new ArrayList<UserScore>();
		System.out.println(goal_id);
		UserScore  uscore=userscorerepository.findbyuser_id(user_id, year, quarter_id, goal_id);
		if (uscore != null) 
		{
			System.out.println(self_comment);
			uscore.setSelf_score(self_score);
			uscore.setSelf_comment(self_comment);
			uscore.setSelf_score_update_by(user_id);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			System.out.println(currentDate);
			uscore.setSelf_score_update_date(currentDate);
			System.out.println("qw"+uscore);
		}	
		System.out.println("pie    "+newscorelist.size());
		return  userscorerepository.save(uscore);
	}

	public UserScore updatermscore(String user_id, String year, String quarter_id, String goal_id, String rm_id,Double rm_score, String rm_comment) {
		List<UserScore> newscorelist=new ArrayList<UserScore>();
		System.out.println(goal_id);
		UserScore  uscore=userscorerepository.findbyuser_id(user_id, year, quarter_id, goal_id);
		if (uscore != null) 
		{
			System.out.println(rm_score);
			uscore.setRm_score(rm_score);
			uscore.setRm_comment(rm_comment);
			uscore.setRm_score_update_by(rm_id);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			System.out.println(currentDate);
			uscore.setSelf_score_update_date(currentDate);
			System.out.println("qw"+uscore);
		}	
		return  userscorerepository.save(uscore);
	}

	public List<UserScore> findalluserscores(String user_id,String  year,String quarter_id){
		return userscorerepository.findbyuser_id3(user_id,year,quarter_id);
	}
	public List<UserScore> saveAlluserscores(List<UserScore> newscorelist) {
		System.out.println("Saved Sucessfully");
		return userscorerepository.saveAll(newscorelist);
	}

	public List<UserScore> missedselfscoringmislist(String year, String quarter_id) {
		return userscorerepository.missedselfscoringlist(year,quarter_id);
	}

	public List<UserScore> missedmanagerscoringmislist(String year, String quarter_id) {
		return userscorerepository.missedmanagerscoringlist(year,quarter_id);
	}

	public List<UserScore> missedpedscoringmislist(String year, String quarter_id) {
		return userscorerepository.missedpedscoringlist(year,quarter_id);
	}

	public List<UserScore> gapmislistAny(String year, String quarter_id, Double gap_size) {
		List<UserScore> scorelist=userscorerepository.gapmislistAny(year, quarter_id);
		List<UserScore> newscorelist=new ArrayList<UserScore>();
		for(UserScore userscore:scorelist) {
			if(userscore.getSelf_score()==null) {
				userscore.setSelf_score(0.0);
			}
			if(userscore.getRm_score()==null) {
				userscore.setRm_score(0.0);
			}
			userscore.setGap_size(Math.abs(userscore.getSelf_score()-userscore.getRm_score()));
			if(Double.compare(userscore.getGap_size(), gap_size) == 0) {
				System.out.println("true");
				newscorelist.add(userscore);
			}
		}
		return newscorelist;
	}

	public List<UserScore> gapmislistParam(String year, String quarter_id, String goal_id,Double gap_size) {
		List<UserScore> scorelist=userscorerepository.gapmislistParam(year, quarter_id,goal_id);
		List<UserScore> newscorelist=new ArrayList<UserScore>();
		for(UserScore userscore:scorelist) {
			if(userscore.getSelf_score()==null) {
				userscore.setSelf_score(0.0);
			}
			if(userscore.getRm_score()==null) {
				userscore.setRm_score(0.0);
			}
			userscore.setGap_size(Math.abs(userscore.getSelf_score()-userscore.getRm_score()));
			if(Double.compare(userscore.getGap_size(), gap_size) == 0) {
				newscorelist.add(userscore);
			}
		}
		return newscorelist;
	}

	public List<UserScore> filteredmisalllist(String year, String quarter_id, Long count) {
		System.out.println(userscorerepository.filteredmisalllist(year,quarter_id,count));
		return userscorerepository.filteredmisalllist(year,quarter_id,count);
	}

	public List<UserScore> filteredmistopselfratedlist(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmistopselfratedlist(year,quarter_id,count);
	}

	public List<UserScore> filteredmistopmanagerratedlist(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmistopmanagerratedlist(year,quarter_id,count);
	}

	public List<UserScore> filteredmistoppedratedlist(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmistoppedratedlist(year,quarter_id, count);
	}

	public List<UserScore>  filteredmisbottomselfratedlist(String year, String quarter_id,Long count) {
		return userscorerepository.filteredmisbottomselfratedlist(year,quarter_id,count);
	}

	public List<UserScore>  filteredmisbottommanagerratedlist(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmisbottommanagerratedlist(year,quarter_id,count);
	}

	public List<UserScore> filteredmisbottompedratedlist(String year, String quarter_id,Long count) {
		return userscorerepository.filteredmisbottompedratedlist(year,quarter_id,count);
	}

	public List<UserScore> filteredmisalllistSelfAsc(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmisalllistSelfAsc(year, quarter_id, count);
	}
	public List<UserScore> filteredmisalllistSelfDesc(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmisalllistSelfDesc(year, quarter_id, count);
	}
	public List<UserScore> filteredmisalllist2(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmisalllist2(year, quarter_id, count);
	}

	public List<UserScore> filteredmistopmanagerratedlist2(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmistopmanagerratedlist2(year,quarter_id,count);
	}

	public List<UserScore> filteredmistopselfratedlist2(String year, String quarter_id, Long count) {
		return userscorerepository.filteredmistopselfratedlist2(year, quarter_id, count);
	}
	public List<UserScore> filteredmisbottomselfratedlist2(String year, String quarter_id, Long count){
		return userscorerepository.filteredmisbottomselfratedlist2(year, quarter_id, count);
	}
	public List<UserScore> getnewfilteredmisalllist(String year, String quarter_id, Long count) {
		Quarter quarters=new Quarter();
		Goals goals=new Goals();
		Users users=new Users();
		UserScoreService obj=new UserScoreService();
		System.out.println("jhjhj");
		System.out.println(year+" "+quarter_id+" "+count);
		List<UserScore> userscorelist=obj.filteredmisalllist(year, quarter_id, count);
		System.out.println(obj.filteredmisalllist(year, quarter_id, count));
		List<UserScore> newscorelist=new ArrayList<UserScore>();
		for(UserScore userscore:userscorelist) {
			System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
			users=new Users();
			users=usersservice.getusername(Long.parseLong(userscore.getUser_id()));
			System.out.println(users.getUsername());
			quarters=new Quarter();
			quarters=quarterservice.getquartername(Long.parseLong(userscore.getQuarter_id()));
			System.out.println(quarters.getName());				
			goals=new Goals();
			goals=goalsservice.getgoalname(Long.parseLong(userscore.getGoal_id()));
			System.out.println(goals.getName());
			try {
				UserScore score=new UserScore();
				score.setYear(userscore.getYear());
				score.setSelf_score(userscore.getSelf_score());
				score.setRm_score(userscore.getRm_score());
				score.setPed_score(userscore.getPed_score());
				score.setUsername(users.getUsername());
				score.setQuarter_name(quarters.getName());
				score.setGoal_name(goals.getName());
				try {
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return newscorelist;

	}

	public UserScore getweightdescription(String user_id, String year, String quarter_id, String goal_id) {
		return userscorerepository.findbyuser_id(user_id, year, quarter_id, goal_id);
	}

	public List<UserScore> UserScoreData(String email_id, String year, String quarter_name, String domain_id,String flag){
		System.out.println("in userdata");
		System.out.println("eid"+email_id);
		System.out.println("y"+year);
		System.out.println("qname"+quarter_name);
		System.out.println("did"+domain_id);
		System.out.println("f"+flag);
		List<UserScore> userscorelist=new ArrayList<UserScore>();
		Double selfscorefinal=0.0;
		Double rmscorefinal=0.0;
		Double pedscorefinal=0.0;
		Connection conn = null;
		try {
			conn=jdbctemplate.getDataSource().getConnection();
			CallableStatement statement = conn.prepareCall("{call usp_userscoreinsert(?,?,?,?)}");
			System.out.println("inside stored procedure");
			//System.out.println(statement.execute());
			System.out.println(email_id);
			System.out.println(year);
			System.out.println(quarter_name);
			System.out.println(flag);
			statement.setString(1, email_id);
			statement.setString(2, year);
			statement.setString(3, quarter_name);
			statement.setString(4, flag);

			ResultSet rs=statement.executeQuery();
			System.out.println(rs.getFetchSize());
			while(rs.next()) {
				String user_id=rs.getString("user_id");
				System.out.println(rs.getString("user_id"));
				String Username=rs.getString("username");
				String goal_id=rs.getString("goal_id");
				String goal_name=rs.getString("goal_name");
				String goal_description=rs.getString("description");
				Double weights=rs.getDouble("weights");
				String quarter_id=rs.getString("q_id");
				System.out.println("user"+user_id);
				System.out.println(goal_description);
				System.out.println(user_id);
				UserScore useree= new UserScore();
				if(flag.equals("1")||flag.equals("3")) {
					Double self_score=rs.getDouble("self_score");
					selfscorefinal+=self_score/5;
					String self_comment=rs.getString("self_comment");
					String self_score_update_by=rs.getString("self_score_update_by");
					String self_score_update_date=rs.getString("self_score_update_date");
					useree.setSelf_score(self_score);
					useree.setSelf_comment(self_comment);
					useree.setSelf_score_update_by(self_score_update_by);
					useree.setSelf_score_update_date(self_score_update_date);
				}
				if(flag.equals("2")||flag.equals("3")) {
					Double rm_score=rs.getDouble("rm_score");
					rmscorefinal+=rm_score/5;
					String rm_comment=rs.getString("rm_comment");
					String rm_score_update_by=rs.getString("rm_score_update_by");
					String rm_score_update_date=rs.getString("rm_score_update_date");
					useree.setRm_score(rm_score);
					useree.setRm_comment(rm_comment);
					useree.setRm_score_update_by(rm_score_update_by);
					useree.setRm_score_update_date(rm_score_update_date);
				}
				if(flag.equals("3")) {
					Double ped_score=rs.getDouble("ped_score");
					pedscorefinal+=ped_score/5;

					String ped_comment=rs.getString("ped_comment");
					String ped_score_update_by=rs.getString("ped_score_update_by");
					String ped_score_update_date=rs.getString("ped_score_update_date");
					useree.setPed_score(ped_score);
					useree.setPed_comment(ped_comment);
					useree.setPed_score_update_by(ped_score_update_by);
					useree.setPed_score_update_date(ped_score_update_date);
				}
				useree.setUser_id(user_id);
				useree.setEmail_id(email_id);
				useree.setUsername(Username);
				useree.setGoal_id(goal_id);
				useree.setGoal_name(goal_name);
				useree.setWeights(weights);
				useree.setYear(year);
				useree.setQuarter_name(quarter_name);
				useree.setQuarter_id(quarter_id);
				if(goal_description!=null) {
					useree.setGoal_Description(goal_description);
					useree.setGoal_Descriptions(goal_description.split(";"));
				}
				userscorelist.add(useree);
			}}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(userscorelist.size());
		return userscorelist;
	}

	public UserScore updatermscoreexists(String user_id, String year, String quarter_id, String goal_id, String rm_id,
			Double rm_score, String rm_comment) {
		UserScore  uscore=userscorerepository.findbyuser_id(user_id, year, quarter_id, goal_id);
		if (uscore != null) 
		{
			uscore.setRm_score(rm_score);
			uscore.setRm_comment(rm_comment);
			uscore.setRm_score_update_by(rm_id);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			System.out.println(currentDate);
			uscore.setRm_score_update_date(currentDate);
		}		
		else {
			System.out.println("no.....");
		}
		return userscorerepository.save(uscore);

	}
}
