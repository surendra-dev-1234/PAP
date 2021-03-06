package com.Service.Goals.Users.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="unfreeze")
public class Unfreeze {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id=(long) 0;

	@Column(name="Year")
	private int year=0;           

	@Column(name="Quarter_id")
	private int quarter_id=0;  

	@Column(name="User_Id")
	private int user_id=0;        

	@Column(name="Unfreezefor")
	private String unfreezefor="";

	@Column(name="Unfreezedays")
	private int unfreezedays=0;

	@Column(name="freezedate")
	private String freezedate="";

	@Column(name="Unfreezedata")
	private String unfreezedata="";

	@Column(name="Unfreezeby")
	private int unfreezeby=0;

	@Column(name="Unfreezedate")
	private String unfreezedate="";

	@Column(name="flag")
	private int flag=0;

}
