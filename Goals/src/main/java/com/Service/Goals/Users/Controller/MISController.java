package com.Service.Goals.Users.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.PDF.UserPDFExporter.FilteredmisPDFExporter;
import com.Service.Goals.Users.PDF.UserPDFExporter.QuaterPDFExporter;
import com.Service.Goals.Users.Service.QuarterService;
import com.Service.Goals.Users.Service.UserScoreService;
import com.lowagie.text.DocumentException;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class MISController {

	@Autowired
	QuarterService quarterservice;

	@Autowired
	UserScoreService userscoreservice;

	@GetMapping("quaterspdf")
	public void exportToPDF(HttpServletResponse response ,@RequestBody Quarter quarter) throws DocumentException, IOException {
		String domain_id=quarter.getDomain_id();
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=quarters.pdf";
		response.setHeader(headerKey, headerValue);
		List<Quarter> listQuarters = quarterservice.getquaterdetails(domain_id);
		QuaterPDFExporter exporter = new QuaterPDFExporter(listQuarters);
		//System.out.println(response);
		exporter.export(response);
	}

	@PostMapping("extractfilteredmislist")
	public void extractfilteredmislist(HttpServletResponse response ,@RequestBody UserScore userscoreinput) throws DocumentException, IOException {
		Map<String,List<UserScore>> filteredmisalllist= new HashMap<String,List<UserScore>>();
		Map<String,Map<String,List<UserScore>>> filteredmislist= new HashMap<String,Map<String,List<UserScore>>>();
		Map<String,List<UserScore>> filteredmisratinglist= new HashMap<String,List<UserScore>>();
		FilteredmisPDFExporter exporter=null;
		List<UserScore> userscorelist=new ArrayList<UserScore>();
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=filteredmis.pdf";
		response.setHeader(headerKey, headerValue);
		System.out.println(userscoreinput.getYear()+""+userscoreinput.getQuarter_id()+""+userscoreinput.getCount());
		if(userscoreinput.getCriteriaflag().equals("All")) {
			if(userscoreinput.getRatingflag().equals("SelfRated")) {
				if(userscoreinput.getOrderby().equals("Ascending")) {
					List<UserScore> newscorelist=new ArrayList<UserScore>();
					userscorelist=userscoreservice.filteredmisalllistSelfAsc(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
					for(UserScore userscore:userscorelist) {
						System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
						System.out.println("trail"+userscore.getUsers().getUsername());
						System.out.println(userscore.getQuarter().getName());
						System.out.println(userscore.getGoals().getName());
						try {
							UserScore score=new UserScore();
							score.setYear(userscore.getYear());
							score.setSelf_score(userscore.getSelf_score());
							score.setRm_score(userscore.getRm_score());
							score.setPed_score(userscore.getPed_score());
							score.setUsername(userscore.getUsers().getUsername());
							score.setQuarter_name(userscore.getQuarter().getName());
							score.setGoal_name(userscore.getGoals().getName());
							try {
								newscorelist.add(score);
							}catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}

					try {
						filteredmisalllist.put("All",newscorelist);
						exporter= new FilteredmisPDFExporter(filteredmisalllist.get("All")/*,userslist,quarterlist,goalslist*/);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				if(userscoreinput.getOrderby().equals("Descending")) {
					List<UserScore> newscorelist=new ArrayList<UserScore>();
					userscorelist=userscoreservice.filteredmisalllistSelfDesc(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
					for(UserScore userscore:userscorelist) {
						System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
						System.out.println("trail"+userscore.getUsers().getUsername());
						System.out.println(userscore.getQuarter().getName());
						System.out.println(userscore.getGoals().getName());
						try {
							UserScore score=new UserScore();
							score.setYear(userscore.getYear());
							score.setSelf_score(userscore.getSelf_score());
							score.setRm_score(userscore.getRm_score());
							score.setPed_score(userscore.getPed_score());
							score.setUsername(userscore.getUsers().getUsername());
							score.setQuarter_name(userscore.getQuarter().getName());
							score.setGoal_name(userscore.getGoals().getName());
							try {
								newscorelist.add(score);
							}catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}

					try {
						filteredmisalllist.put("All",newscorelist);
						exporter= new FilteredmisPDFExporter(filteredmisalllist.get("All")/*,userslist,quarterlist,goalslist*/);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
			else {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmisalllist2(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						try {
							newscorelist.add(score);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}

				try {
					filteredmisalllist.put("All",newscorelist);
					exporter= new FilteredmisPDFExporter(filteredmisalllist.get("All"));
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		if(userscoreinput.getCriteriaflag().equals("Top")) {
			if(userscoreinput.getRatingflag().equals("SelfRated")) {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmistopselfratedlist2(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						newscorelist.add(score);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}	
				}
				try {
					filteredmisratinglist.put("SelfRated",newscorelist);
					filteredmislist.put("Top",filteredmisratinglist);
					exporter= new FilteredmisPDFExporter(filteredmisratinglist.get("SelfRated")/*,users,quarters,goals*/);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
			if(userscoreinput.getRatingflag().equals("ManagerRated")) {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmistopmanagerratedlist(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						newscorelist.add(score);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}	
				}
				try {
					filteredmisratinglist.put("ManagerRated",newscorelist);
					filteredmislist.put("Top",filteredmisratinglist);
					exporter= new FilteredmisPDFExporter(filteredmisratinglist.get("ManagerRated"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			if(userscoreinput.getRatingflag().equals("PEDRated")) {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmistoppedratedlist(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						newscorelist.add(score);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}	
				}
				try {
					filteredmisratinglist.put("PEDRated",newscorelist);
					filteredmislist.put("Top",filteredmisratinglist);
					exporter= new FilteredmisPDFExporter(filteredmisratinglist.get("PEDRated"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		if(userscoreinput.getCriteriaflag().equals("Bottom")) {
			if(userscoreinput.getRatingflag().equals("SelfRated")) {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmisbottomselfratedlist(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						newscorelist.add(score);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}	
				}
				try {
					filteredmisratinglist.put("SelfRated",newscorelist);
					filteredmislist.put("Bottom",filteredmisratinglist);
					exporter= new FilteredmisPDFExporter(filteredmisratinglist.get("SelfRated"));
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if(userscoreinput.getRatingflag().equals("ManagerRated")) {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmisbottommanagerratedlist(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						newscorelist.add(score);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}	
				}
				try {
					filteredmisratinglist.put("ManagerRated",newscorelist);
					filteredmislist.put("Bottom",filteredmisratinglist);
					exporter= new FilteredmisPDFExporter(filteredmisratinglist.get("ManagerRated"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			if(userscoreinput.getRatingflag().equals("PEDRated")) {
				List<UserScore> newscorelist=new ArrayList<UserScore>();
				userscorelist=userscoreservice.filteredmisbottompedratedlist(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getCount());
				for(UserScore userscore:userscorelist) {
					System.out.println(userscore.getUser_id()+" "+userscore.getQuarter_id()+" "+userscore.getGoal_id());
					System.out.println("trail"+userscore.getUsers().getUsername());
					System.out.println(userscore.getQuarter().getName());
					System.out.println(userscore.getGoals().getName());
					try {
						UserScore score=new UserScore();
						score.setYear(userscore.getYear());
						score.setSelf_score(userscore.getSelf_score());
						score.setRm_score(userscore.getRm_score());
						score.setPed_score(userscore.getPed_score());
						score.setUsername(userscore.getUsers().getUsername());
						score.setQuarter_name(userscore.getQuarter().getName());
						score.setGoal_name(userscore.getGoals().getName());
						newscorelist.add(score);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}	
				}

				try {
					filteredmisratinglist.put("PEDRated",newscorelist);
					filteredmislist.put("Bottom",filteredmisratinglist);
					exporter= new FilteredmisPDFExporter(filteredmisratinglist.get("PEDRated"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		exporter.export(response);
	}

	@PostMapping("extractmissedscoringmislist")
	public void extractmissedscoringmislist(HttpServletResponse response,@RequestBody UserScore userscoreinput) throws DocumentException, IOException{
		Map<String,Object> missedscorelist= new HashMap<String,Object>();
		List<UserScore> userscorelist=new ArrayList<UserScore>();
		FilteredmisPDFExporter exporter=null;
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=missedscoringmis.pdf";
		response.setHeader(headerKey, headerValue);
		if(userscoreinput.getMissedbyflag().equals("Self")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			userscorelist=userscoreservice.missedselfscoringmislist(userscoreinput.getYear(),userscoreinput.getQuarter_id());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				missedscorelist.put("Self",newscorelist);
				exporter= new FilteredmisPDFExporter(missedscorelist.get("Self"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		if(userscoreinput.getMissedbyflag().equals("Manager")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			userscorelist=userscoreservice.missedmanagerscoringmislist(userscoreinput.getYear(),userscoreinput.getQuarter_id());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				missedscorelist.put("Manager",newscorelist);
				exporter= new FilteredmisPDFExporter(missedscorelist.get("Manager"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		if(userscoreinput.getMissedbyflag().equals("PED")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			userscorelist=userscoreservice.missedpedscoringmislist(userscoreinput.getYear(),userscoreinput.getQuarter_id());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				missedscorelist.put("PED",newscorelist);
				exporter= new FilteredmisPDFExporter(missedscorelist.get("PED"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		exporter.export(response);
	}
	@PostMapping("extractgapmislist")
	public void extractgapmislist(HttpServletResponse response,@RequestBody UserScore userscoreinput) throws DocumentException, IOException {
		Map<String,List<UserScore>> gapmislistlist= new HashMap<String,List<UserScore>>();	
		List<UserScore> userscorelist=new ArrayList<UserScore>();
		FilteredmisPDFExporter exporter=null;
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=gapmis.pdf";
		response.setHeader(headerKey, headerValue);
		if(userscoreinput.getGoal_id().equals("0")){
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			userscorelist=userscoreservice.gapmislistAny(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getGap_size());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				gapmislistlist.put("GapSize0",newscorelist);
				exporter= new FilteredmisPDFExporter(gapmislistlist.get("GapSize0"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(userscoreinput.getGoal_id().equals("1") || userscoreinput.getGoal_id().equals("6")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			//Goals goals=goalsservice.getgoal_id(userscoreinput.getGapparameter());
			userscorelist=userscoreservice.gapmislistParam(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getGoal_id(),userscoreinput.getGap_size());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				gapmislistlist.put("GapSize1",newscorelist);
				exporter= new FilteredmisPDFExporter(gapmislistlist.get("GapSize1"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(userscoreinput.getGoal_id().equals("2") || userscoreinput.getGoal_id().equals("7")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			//Goals goals=goalsservice.getgoal_id(userscoreinput.getGapparameter());
			userscorelist=userscoreservice.gapmislistParam(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getGoal_id(),userscoreinput.getGap_size());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				gapmislistlist.put("GapSize2",newscorelist);
				exporter= new FilteredmisPDFExporter(gapmislistlist.get("GapSize2"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(userscoreinput.getGoal_id().equals("3") || userscoreinput.getGoal_id().equals("8")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			//Goals goals=goalsservice.getgoal_id(userscoreinput.getGapparameter());
			userscorelist=userscoreservice.gapmislistParam(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getGoal_id(),userscoreinput.getGap_size());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				gapmislistlist.put("GapSize3",newscorelist);
				exporter= new FilteredmisPDFExporter(gapmislistlist.get("GapSize3"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(userscoreinput.getGoal_id().equals("4") || userscoreinput.getGoal_id().equals("9")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			//Goals goals=goalsservice.getgoal_id(userscoreinput.getGapparameter());
			userscorelist=userscoreservice.gapmislistParam(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getGoal_id(),userscoreinput.getGap_size());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				gapmislistlist.put("GapSize4",newscorelist);
				exporter= new FilteredmisPDFExporter(gapmislistlist.get("GapSize4"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(userscoreinput.getGoal_id().equals("5") || userscoreinput.getGoal_id().equals("10")) {
			List<UserScore> newscorelist=new ArrayList<UserScore>();
			//Goals goals=goalsservice.getgoal_id(userscoreinput.getGapparameter());
			userscorelist=userscoreservice.gapmislistParam(userscoreinput.getYear(),userscoreinput.getQuarter_id(),userscoreinput.getGoal_id(),userscoreinput.getGap_size());
			for(UserScore userscore:userscorelist) {
				try {
					UserScore score=new UserScore();
					score.setYear(userscore.getYear());
					score.setSelf_score(userscore.getSelf_score());
					score.setRm_score(userscore.getRm_score());
					score.setPed_score(userscore.getPed_score());
					score.setUsername(userscore.getUsers().getUsername());
					score.setQuarter_name(userscore.getQuarter().getName());
					score.setGoal_name(userscore.getGoals().getName());
					newscorelist.add(score);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			try {
				gapmislistlist.put("GapSize5",newscorelist);
				exporter= new FilteredmisPDFExporter(gapmislistlist.get("GapSize5"));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		exporter.export(response);
	}
}
