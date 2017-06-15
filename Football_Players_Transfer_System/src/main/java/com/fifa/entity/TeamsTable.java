package com.fifa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@NamedQueries({ @NamedQuery(name = "fetchAllTeams", query = "from TeamsTable") })

@Entity
@Table(name = "teams_table")
public class TeamsTable {

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "teamid", unique = true, nullable = false)
	private Integer teamid;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id", nullable = false)
	private UsersTable user;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "country", nullable = false, length = 45)
	private String country;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	private Set<TeamPlayerBid> bids = new HashSet<TeamPlayerBid>();

	@OneToOne(mappedBy = "team")
	private TeamAccount account = new TeamAccount();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	private Set<PlayersTable> players = new HashSet<PlayersTable>();

	@Column(name = "logo", length = 100)
	private String logo;

	@Transient
	private CommonsMultipartFile photo;
	
	public TeamsTable() {
	}

	public TeamsTable(UsersTable usersTable, String name, String country) {
		this.user = usersTable;
		this.name = name;
		this.country = country;
	}

	public TeamsTable(UsersTable usersTable, String name, String country, Set<TeamPlayerBid> teamPlayerBids,
			TeamAccount teamAccounts, Set<PlayersTable> playersTables, String logo) {
		this.user = usersTable;
		this.name = name;
		this.country = country;
		this.bids = teamPlayerBids;
		this.account = teamAccounts;
		this.players = playersTables;
		this.logo = logo;
	}

	public Integer getTeamid() {
		return this.teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	public UsersTable getUser() {
		return this.user;
	}

	public void setUser(UsersTable usersTable) {
		this.user = usersTable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<TeamPlayerBid> getBids() {
		return this.bids;
	}

	public void setBids(Set<TeamPlayerBid> teamPlayerBids) {
		this.bids = teamPlayerBids;
	}

	public Set<PlayersTable> getPlayers() {
		return this.players;
	}

	public void setPlayers(Set<PlayersTable> playersTables) {
		this.players = playersTables;
	}

	public TeamAccount getAccount() {
		return account;
	}

	public void setAccount(TeamAccount account) {
		this.account = account;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}	
	
}
