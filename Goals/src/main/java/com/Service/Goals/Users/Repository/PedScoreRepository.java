package com.Service.Goals.Users.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Service.Goals.Users.Entity.PedScore;

public interface PedScoreRepository extends JpaRepository<PedScore, Long>{

	@Query(value = "SELECT * FROM ped_score WHERE user_id= ?1 and year= ?2 ;", nativeQuery = true)
	public PedScore getpedscorebyid(String user_id, String year);
}
