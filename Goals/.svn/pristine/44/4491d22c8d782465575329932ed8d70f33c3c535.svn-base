package com.Service.Goals.Users.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Repository.QuarterRepository;

@Service
public class QuarterService {

	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	QuarterRepository quarterrepository;

	public Quarter getquarterdate(String year, String quarter_name, String domain_id) {
		System.out.println("this is yeary"+year);
		System.out.println("this is yeary"+quarter_name);
		System.out.println("this is yeary"+domain_id);
		Quarter quarterDate=new Quarter();	
		Connection conn=null;
		try {
			conn=jdbctemplate.getDataSource().getConnection();
			CallableStatement statement = conn.prepareCall("{call usp_quarter_date(?,?,?)}");

			statement.setString(1, year);
			statement.setString(2, quarter_name);
			statement.setString(3, domain_id);

			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String Quarter_name=rs.getString("quarter_name");
				String start_date=rs.getString("start_date");
				String end_date=rs.getString("end_date");
				String weight_freeze_date=rs.getString("weight_freeze_date");
				String score_freeze_date=rs.getString("score_freeze_date");
				String weight_flag=rs.getString("weight_flag");
				String score_flag=rs.getString("score_flag");

				quarterDate=quarterrepository.getquarter_id(Quarter_name,domain_id);
				System.out.println(quarterDate);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(quarterDate);
		return quarterDate;
	}

	public List<Quarter> getquaterdetails(String domain_id) {
		List<Quarter> quarterlist=quarterrepository.getquaterdetails(domain_id);
		// TODO Auto-generated method stub
		return quarterlist;
	}

	public List<Quarter> getquarterrecord(String year, String domain_id) {
		// TODO Auto-generated method stub
		System.out.println(year);
		System.out.println(domain_id);
		List<Quarter> quarterlist = new ArrayList<Quarter>();
		Connection conn=null;
		try {
			conn=jdbctemplate.getDataSource().getConnection();
			CallableStatement statement = conn.prepareCall("{call usp_quater_records(?,?)}");
			System.out.println(statement);
			statement.setString(1, year);
			statement.setString(2, domain_id);
			ResultSet rs=statement.executeQuery();

			System.out.println(rs.getFetchSize());
			while(rs.next()) {
				Quarter quarter = new Quarter();
				String quarter_id=rs.getString("quarter_id");
				String name=rs.getString("name");
				String start_month=rs.getString("start_month");
				String end_month=rs.getString("end_month");
				String weight_freeze_month=rs.getString("Weight_Freeze_Month");
				String score_freeze_month=rs.getString("Score_Freeze_Month");
				String score_freeze_day=rs.getString("Score_Freeze_Day");

				quarter.setYear(year);
				quarter.setDomain_id(domain_id);
				quarter.setQuarter_id(Long.parseLong(quarter_id));
				quarter.setName(name);
				quarter.setStart_month(start_month);
				quarter.setEnd_month(end_month);
				quarter.setWeight_Freeze_Month(weight_freeze_month);
				quarter.setScore_Freeze_Month(score_freeze_month);
				quarter.setScore_Freeze_Day(score_freeze_day);

				quarterlist.add(quarter);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(Quarter q:quarterlist) {
			System.out.println(q.getYear()+" "+q.getDomain_id()+" "+q.getQuarter_id()+" "+q.getName()+" "+q.getStart_month()+" "+q.getEnd_month()+q.getWeight_Freeze_Month()+" "+q.getScore_Freeze_Month()+" "+q.getScore_Freeze_Day());
		}
		return quarterlist;
	}

	public Quarter getquartername(Long quarter_id) {
		return quarterrepository.getquartername(quarter_id);
	}

	public Quarter findQuarteridbymonth(int month_num, String domain_id) {
		return quarterrepository.findQuarteridbymonth(month_num,domain_id);
	}

}
