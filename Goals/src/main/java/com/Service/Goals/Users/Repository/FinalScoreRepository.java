package com.Service.Goals.Users.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Service.Goals.Users.Entity.FinalScore;

public interface FinalScoreRepository extends JpaRepository<FinalScore, Long>{

	@Query(value = "SELECT * FROM final_score WHERE user_id= ?1 and year= ?2 and  quater_id= ?3  ;", nativeQuery = true)
	public FinalScore findfinalscore(String user_id, String year, String quarter_id);

	@Query(value = "update final_score set self_score= ?4, self_comment= ?5, self_score_update_by=?1, self_score_update_date=?6 where user_id=?1 and year=?2 and quater_id=?3 ;", nativeQuery = true)
	public void updatefinalselfscoreexists(String user_id, String year, String quarter_id, Double selfscorefinal, String selfcommentfinal, String date);

	@Query(value = "update final_score set rm_score= ?5, rm_comment=?6, rm_score_update_by=?4, rm_score_update_date=?7 where user_id=?1 and year=?2 and quater_id=?3 ;", nativeQuery = true)
	public void updatefinalrmscoreexists(String user_id, String year, String quarter_id, String rm_id,
			Double rmscorefinal, String rmcommentfinal, String date);

	@Query(value = "update final_score set ped_score= ?5, ped_score_update_by=?4 where user_id=?1 and year=?2 and quater_id=?3 ;", nativeQuery = true)
	public void updatefinalpedscoreexists(String user_id, String year, String quarter_id, String ped_id,
			Double pedscorefinal);

	@Query(value = "select * from final_score left join quarter on final_score.quater_id=quarter.quarter_id where user_id=?1 and year= ?2 order by name", nativeQuery = true)
	public List<FinalScore> findfinalscore(String user_id, String year);

	@Query(value = "select avg(final_score.self_score) from final_score where user_id=?1 and year= ?2 ", nativeQuery = true)
	public Double findfinalselfscoreavg(String user_id, String year);

	@Query(value = "select avg(final_score.rm_score) from final_score where user_id=?1 and year= ?2 ", nativeQuery = true)
	public Double findfinalrmscoreavg(String user_id, String year);
}
