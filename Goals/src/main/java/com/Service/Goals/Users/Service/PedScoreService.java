package com.Service.Goals.Users.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.PedScore;
import com.Service.Goals.Users.Entity.Users;
import com.Service.Goals.Users.Repository.PedScoreRepository;
import com.Service.Goals.Users.Repository.UsersRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Service
public class PedScoreService {

	@Autowired
	PedScoreRepository pedscorerepository;

	@Autowired
	UsersRepository usersrepository;

	public PedScore updatepedscore(PedScore pedscoreinput) {
		pedscoreinput.setPed_score_update_by(pedscoreinput.getPed_id());
		LocalDate date= LocalDate.now();
		pedscoreinput.setPed_score_update_date(date.toString());
		PedScore pedscore=new PedScore();
		try {
			pedscore=pedscorerepository.getpedscorebyid(pedscoreinput.getUser_id(),pedscoreinput.getYear());
			pedscore.setPed_score(pedscoreinput.getPed_score());
			pedscore.setPed_comment(pedscoreinput.getPed_comment());
			pedscore.setPed_score_update_by(pedscoreinput.getPed_score_update_by());
			pedscore.setPed_score_update_date(pedscoreinput.getPed_score_update_date());
			return pedscorerepository.save(pedscore);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return pedscorerepository.save(pedscoreinput);
		}
	}

	public List<Users> getpeduseremployees(String ped_id) {
		return usersrepository.getpeduseremployees(ped_id);
	}
}
