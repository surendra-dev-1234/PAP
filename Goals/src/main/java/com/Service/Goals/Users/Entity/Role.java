package com.Service.Goals.Users.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Role")
public class Role implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long role_id=(long)0;

	@Column(name="rolename")
	private String rolename="";

	@Column(name="description")
	private String description="";

}
