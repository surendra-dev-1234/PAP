package com.Service.Goals.Users.Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user_score")
public class UserScore implements Serializable{	
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Getter
	private Long id=new Long(0);
	
	@Column(name="user_id",insertable = false, updatable = false)
	private String user_id="";
	
	@Column(name="goal_id",insertable = false, updatable = false)
	private String goal_id="";
	
	@Column(name="weights")
	private Double weights=0.0;
	
	@Column(name="weight_update_by")
	private String weight_update_by="";
	
	@Column(name="weight_update_date")
	private String weight_update_date="";
	
	@Column(name="year")
	private String year="";
	
	@Column(name="quater_id",insertable = false, updatable = false)
	private String quarter_id="";
	
	@Column(name="self_score")
	private Double self_score=0.0;
	
	@Column(name="self_comment")
	private String self_comment="";
	
	@Column(name="self_score_update_by")
	private String self_score_update_by="";
	
	@Column(name="self_score_update_date")
	private String self_score_update_date="";
	
	@Column(name="rm_score")
	private Double rm_score=0.0;
	
	@Column(name="rm_comment")
	private String rm_comment="";
	
	@Column(name="rm_score_update_by")
	private String rm_score_update_by="";
	
	@Column(name="rm_score_update_date")
	private String rm_score_update_date="";
	
	@Column(name="ped_score")
	private Double ped_score=0.0;
	
	@Column(name="ped_comment")
	private String ped_comment="";
	
	@Column(name="ped_score_update_by")
	private String ped_score_update_by="";
	
	@Column(name="ped_score_update_date")
	private String ped_score_update_date="";
	
	@Column(name="Goal_Description")
	private String goal_Description="";
	
	@Transient
	private String email_id="";
	
	@Transient
	private String username="";
	
	@Transient
	private String goal_name="";
		
	@Transient
	private String quarter_name="";
	
	@Transient
	private String domain_id="";
	
	@Transient
	private String rm_id="";
	
	@Transient
	private String ped_id="";
	
	@Transient
	private String flag="";
	
	@Transient
    private Long count=(long) 0;
		
	@Transient
	private Double gap_size=0.0;
	
	@Transient
	private String criteriaflag="";
	
	@Transient
	private String ratingflag="";
	
	@Transient
	private String missedbyflag="";
	
	@Transient
	private String orderby="";
	
	@Transient
	private String [] goal_Descriptions= {};
		
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id")
	 private Users users;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name ="quater_id")
	private Quarter quarter;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name ="goal_id")
	private Goals goals;
	
	
	}
