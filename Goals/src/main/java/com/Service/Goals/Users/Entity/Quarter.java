package com.Service.Goals.Users.Entity;

import java.io.Serializable;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="quarter")
public class Quarter implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	@Column(name="quarter_id")
	private Long quarter_id=new Long(0);

	@Column(name="name")
	private String name="";

	@Column(name="start_month")
	private String start_month="";

	@Column(name="end_month")
	private String end_month="";

	@Column(name="domain_id")
	private String domain_id="";

	@Column(name="Weight_Freeze_Month")
	private String Weight_Freeze_Month="";

	@Column(name="Weight_Freeze_Day")
	private String Weight_Freeze_Day="";

	@Column(name="Score_Freeze_Month")
	private String Score_Freeze_Month="";

	@Column(name="Score_Freeze_Day")
	private String Score_Freeze_Day="";

	//	@Transient
	//	private String quarter_name="";

	@Transient
	private String start_date="";

	@Transient
	private String End_date="";

	@Transient
	private String weight_freeze_date="";

	@Transient
	private String score_freeze_date="";

	@Transient
	private String weight_flag="";

	@Transient
	private String score_flag="";

	@Transient
	private String year="";

	//	@OneToMany(mappedBy="quarter",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//	@Column(nullable = true)
	//	@JsonManagedReference(value="quarter")
	//    private List<UserScore> userscore;

}
