package com.Service.Goals.Users.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.FinalScore;
import com.Service.Goals.Users.Repository.FinalScoreRepository;

@Service
public class FinalScoreService {

	@Autowired
	FinalScoreRepository finalscorerepository;

	public void updatefinalselfscore(String user_id, String year, String quarter_id, Double selfscorefinal, String selfcommentfinal) {
		FinalScore finalscore= new FinalScore();
		finalscore.setUser_id(user_id);
		finalscore.setQuarter_id(quarter_id);
		finalscore.setYear(year);
		finalscore.setSelf_score(selfscorefinal);
		finalscore.setSelf_comment(selfcommentfinal);
		finalscore.setSelf_score_update_by(user_id);
		LocalDate date = LocalDate.now();  
		finalscore.setSelf_score_update_date(date.toString());
		finalscorerepository.save(finalscore);
	}

	public void updatefinalrmscore(String user_id, String year, String quarter_id, String rm_id,Double rmscorefinal, String rmcommentfinal) {
		FinalScore finalscore= new FinalScore();
		finalscore.setUser_id(user_id);
		finalscore.setQuarter_id(quarter_id);
		finalscore.setYear(year);
		finalscore.setRm_score(rmscorefinal);
		finalscore.setRm_comment(rmcommentfinal);
		finalscore.setRm_score_update_by(rm_id);
		LocalDate date = LocalDate.now();  
		finalscore.setRm_score_update_date(date.toString());
		finalscorerepository.save(finalscore);
	}

	public void updatefinalselfscoreexists(String user_id, String year, String quarter_id, Double selfscorefinal, String selfcommentfinal) {
		LocalDate date = LocalDate.now();  
		finalscorerepository.updatefinalselfscoreexists(user_id,year,quarter_id,selfscorefinal,selfcommentfinal,date.toString());
	}

	public FinalScore findfinalscore(String user_id, String year, String quarter_id){
		return finalscorerepository.findfinalscore(user_id, year, quarter_id);
	}

	public void updatefinalrmscoreexists(String user_id, String year, String quarter_id, String rm_id,
			Double rmscorefinal, String rmcommentfinal) {
		LocalDate date = LocalDate.now(); 
		finalscorerepository.updatefinalrmscoreexists(user_id,year,quarter_id,rm_id,rmscorefinal,rmcommentfinal,date.toString());
	}

	public void updatefinalpedscoreexists(String user_id, String year, String quarter_id, String ped_id,
			Double pedscorefinal) {
		finalscorerepository.updatefinalpedscoreexists(user_id,year,quarter_id,ped_id,pedscorefinal);
	}

}
