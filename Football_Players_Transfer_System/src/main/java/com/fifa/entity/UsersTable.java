package com.fifa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_table")
public class UsersTable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	private Integer userid;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "username", nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 45)
	private String password;

	@Column(name = "role", nullable = false, length = 45)
	private String role;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private TeamsTable team = new TeamsTable();

	public UsersTable() {
	}

	public UsersTable(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UsersTable(String name, String username, String password, String role, TeamsTable teamsTables) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.team = teamsTables;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TeamsTable getTeam() {
		return this.team;
	}

	public void setTeam(TeamsTable teamsTables) {
		this.team = teamsTables;
	}

}
