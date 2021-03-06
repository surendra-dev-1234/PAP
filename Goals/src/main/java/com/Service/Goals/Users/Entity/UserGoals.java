package com.Service.Goals.Users.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_goals")
public class UserGoals {
	@Id
	@Column(name="id")
	private Long id=(long)0;

	@Column(name="user_id")
	private String user_id="";

	@Column(name="goal_id")
	private String goal_id="";

	@Column(name="weights")
	private Double weights=0.0;

	@Column(name="weight_update_by")
	private String weight_update_by="";

	@Column(name="weight_update_date")
	private String weight_update_date="";

	@Column(name="year")
	private String year="";

	@Column(name="goal_Description")
	private String goal_Description="";

	@Transient
	private String email_id="";

	@Transient
	private String username="";

	@Transient
	private String goal_name="";

	@Transient
	private String rm_id="";

	@Transient
	private String[] goal_Descriptions;

	@Transient
	private String quarter_name;

	@Transient
	private String domain_id;
}
