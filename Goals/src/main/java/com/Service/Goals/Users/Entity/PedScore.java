package com.Service.Goals.Users.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name="ped_score")
public class PedScore implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id=(long)0;

	@Column(name="ped_comment")
	private String ped_comment="";

	@Column(name="ped_score")
	private Double ped_score=0.0;

	@Column(name="ped_score_update_by")
	private String ped_score_update_by="";

	@Column(name="ped_score_update_date")
	private String ped_score_update_date="";

	@Column(name="user_id")
	private String user_id="";

	@Column(name="year")
	private String year="";

	@Transient
	private String ped_id="";

	@Transient
	private Double selfscore_avg=0.0;

	@Transient
	private Double rmscore_avg=0.0;

	@Transient
	private Set<String> goal_names=new HashSet<String>();

	@Transient
	private List<Double> goal_selfscores=new ArrayList<Double>();

	@Transient
	private List<Double> goal_rmscores=new ArrayList<Double>();

}
