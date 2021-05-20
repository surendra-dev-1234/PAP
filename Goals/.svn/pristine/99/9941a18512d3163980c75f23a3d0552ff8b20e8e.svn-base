package com.Service.Goals.Users.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.UserScore;

@Repository

public interface UserScoreRepository extends JpaRepository<UserScore, Long>{

	@Query(value = "SELECT * FROM USER_SCORE WHERE user_id= ?1 and year= ?2 and  quater_id= ?3 and goal_id= ?4 ;", nativeQuery = true)
	public UserScore findbyuser_id(String user_id, String year, String quarter_id, String goal_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE user_id= ?1 and year= ?2 and  quater_id= ?3 and goal_id= ?4 ;", nativeQuery = true)
	public UserScore findbyuser_id2(String user_id, String year, String quarter_id, String goal_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 and self_score is null;", nativeQuery = true)
	public List<UserScore> missedselfscoringlist(String year, String quarter_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 and rm_score is null;", nativeQuery = true)
	public List<UserScore> missedmanagerscoringlist(String year, String quarter_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 and ped_score is null;", nativeQuery = true)
	public List<UserScore> missedpedscoringlist(String year, String quarter_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE user_id= ?1 and year= ?2 and  quater_id= ?3  ;", nativeQuery = true)
	public List<UserScore> findbyuser_id3(String user_id, String year, String quarter_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2  ;", nativeQuery = true)
	public List<UserScore> gapmislistAny(String year, String quarter_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 and goal_id=?3 ;", nativeQuery = true)
	public List<UserScore> gapmislistParam(String year, String quarter_id, String goal_id);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 ;", nativeQuery = true)
	public List<UserScore> filteredmisalllist(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by self_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmistopselfratedlist(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by rm_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmistopmanagerratedlist(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by ped_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmistoppedratedlist(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by self_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisbottomselfratedlist(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by rm_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisbottommanagerratedlist(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by ped_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisbottompedratedlist(String year, String quarter_id, Long count);

	@Query(value = "SELECT * FROM user_score us "
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "where year=?1 and quater_id=?2 ;", nativeQuery = true)
	public List<UserScore> filteredmisalllist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE us "
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "WHERE year=?1 and quater_id=?2 order by self_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmistopselfratedlist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE us"
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "WHERE year=?1 and quater_id=?2 order by rm_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmistopmanagerratedlist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE us"
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "WHERE year=?1 and quater_id=?2 order by ped_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmistoppedratedlist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE us "
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "WHERE year=?1 and quater_id=?2 order by self_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisbottomselfratedlist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE us"
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "WHERE year=?1 and quater_id=?2 order by rm_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisbottommanagerratedlist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT top (?3) * FROM USER_SCORE us "
			+ "left join users u on us.user_id=u.user_id "
			+"left join goals g on us.goal_id=g.goal_id "
			+ "left join quarter q on us.quater_id=q.quarter_id "
			+ "WHERE year=?1 and quater_id=?2 order by ped_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisbottompedratedlist2(String year, String quarter_id, Long count);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by self_score asc ;", nativeQuery = true)
	public List<UserScore> filteredmisalllistSelfAsc(String year, String quarter_id, Long count);

	@Query(value = "SELECT * FROM USER_SCORE WHERE year=?1 and quater_id=?2 order by self_score desc ;", nativeQuery = true)
	public List<UserScore> filteredmisalllistSelfDesc(String year, String quarter_id, Long count);

	@Query(value = "SELECT * FROM USER_SCORE WHERE user_id=?1 and year=?2 ;", nativeQuery = true)
	public List<UserScore> findbyyearly(String user_id, String year);
}
