package com.Service.Goals.Users.Entity;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name="final_score")
public class FinalScore implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id=(long) 0;

	@Column(name="user_id")
	private String user_id="";

	@Column(name="Year")
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name ="quater_id")
	private Quarter quarter;
}
