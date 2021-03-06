package com.Service.Goals.Users.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.Quarter;

@Repository
public interface QuarterRepository extends JpaRepository<Quarter, Long>{

	@Query(value="Select * from Quarter where domain_id = ?1" , nativeQuery = true)
	List<Quarter> getquaterdetails(String domainid);

	@Query(value = "{call usp_quarter_date(:year,:quarter_name,:domain_id)}", nativeQuery = true)
	List<Object[]> getquarterdate(@Param("year") String year,@Param("quarter_name") String quarter_name,@Param("domain_id")  String domain_id);

	@Query(value="Select * from Quarter where name=?1 and domain_id = ?2" , nativeQuery = true)
	Quarter getquarter_id(String quarter_name, String domain_id);

	@Query(value="Select * from Quarter where quarter_id=?1 " , nativeQuery = true)
	Quarter getquartername(Long quarter_id);

	@Query(value="select * from quarter where start_month<=?1 and end_month >=?1 and domain_id =?2 " , nativeQuery = true)
	Quarter findQuarteridbymonth(int month_num, String domain_id);
}
