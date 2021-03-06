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
@Table(name="domain")
public class Domain implements Serializable{
	private static final long serialVersionUID = -5294188737237640015L;
	@Id
	@Column(name="domain_id")
	private Long domain_id=(long)0;

	@Column(name="name")
	private String name="";

	@Column(name="logo")
	private String logo="";
}
