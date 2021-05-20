package com.Service.Goals.Users.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserScore implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@JsonProperty("userscore")
	private List<UserScore> userscore=new ArrayList<UserScore>();

	@JsonProperty("usergoals")
	private List<UserGoals> usergoals=new ArrayList<UserGoals>();

	@JsonProperty("pedscore")
	private List<PedScore> pedscore=new ArrayList<PedScore>();

}
