package com.Service.Goals.Users.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name="users")
public class Users implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long user_id=(long) 0;

	@Column(name="email_id")
	private String email_id="";

	@Column(name="username")
	private String username="";

	@Column(name="rm_id")
	private String rm_id="";

	@Column(name="rm_valid_from")
	private String rm_valid_from="";

	@Column(name="rm_valid_to")
	private String rm_valid_to="";

	@Column(name="ped_id")
	private String ped_id="";

	@Column(name="ped_valid_from")
	private String ped_valid_from="";

	@Column(name="ped_valid_to")
	private String ped_valid_to="";

	@Column(name="domain_id")
	private String domain_id="";

	@Column(name="Emp_Id")
	private String  emp_Id="";

	@Column(name="Flag")
	private String  flag="";

	@Column(name="Is_PED_Flag")
	private String  is_ped_flag="";

	@Column(name="Is_MIS_Flag")
	private String is_mis_flag="";

	@Column(name="Is_Freeze_Flag")
	private String is_freeze_flag="";

	@Transient
	private String role_name="";

	@Transient
	private String domain_name="";

	@Transient
	private boolean hr=false;

	@Transient
	private boolean level1_user=false;

	@Transient
	private boolean level2_user=false;

	@Transient
	private boolean level3_user=false;

	@Transient
	private boolean mis_user=false;

	@Transient
	private boolean ped_user=false;

	@Transient
	private boolean unfreeze=false;

	@Transient
	private String logo="";

	@Transient
	@JsonProperty("user_ids")
	private Long[] user_ids= {} ;

	@Transient
	private String pedmappingflag="";

	//	@OneToMany(mappedBy="users",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//	@Column(nullable = true)
	//	@JsonManagedReference(value="users")
	//    private List<UserScore> userscore;
}
