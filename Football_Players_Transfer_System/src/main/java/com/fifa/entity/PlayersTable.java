package com.fifa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@NamedQueries({ @NamedQuery(name = "findPlayerById", query = "from PlayersTable where playerId = :playerID") })

@Entity
@Table(name = "players_table")
public class PlayersTable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "player_id", unique = true, nullable = false)
	private Integer playerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "position_id", nullable = false)
	private PlayerPositionCnfg playerPositionCnfg;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", nullable = false)
	private PlayerTypeCnfg playerTypeCnfg;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private TeamsTable team;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "country", nullable = false, length = 45)
	private String country;

	@Column(name = "image", length = 100)
	private String image;

	@Column(name = "start_bid")
	private Long startBid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "is_in_auction", nullable = false)
	private boolean isInAuction;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "player")
	private PlayerAttributes playerAttributes;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
	private Set<TeamPlayerBid> teamPlayerBids = new HashSet<TeamPlayerBid>();

	@Transient
	private CommonsMultipartFile photo;

	public PlayersTable() {
	}

	public PlayersTable(PlayerPositionCnfg playerPositionCnfg, PlayerTypeCnfg playerTypeCnfg, String name,
			String country, boolean isInAuction) {
		this.playerPositionCnfg = playerPositionCnfg;
		this.playerTypeCnfg = playerTypeCnfg;
		this.name = name;
		this.country = country;
		this.isInAuction = isInAuction;
	}

	public PlayersTable(PlayerPositionCnfg playerPositionCnfg, PlayerTypeCnfg playerTypeCnfg, TeamsTable teamsTable,
			String name, String country, String image, Long startBid, Date startTime, boolean isInAuction,
			PlayerAttributes playerAttributes, Set<TeamPlayerBid> teamPlayerBids) {
		this.playerPositionCnfg = playerPositionCnfg;
		this.playerTypeCnfg = playerTypeCnfg;
		this.team = teamsTable;
		this.name = name;
		this.country = country;
		this.image = image;
		this.startBid = startBid;
		this.startTime = startTime;
		this.isInAuction = isInAuction;
		this.playerAttributes = playerAttributes;
		this.teamPlayerBids = teamPlayerBids;
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public PlayerPositionCnfg getPlayerPositionCnfg() {
		return this.playerPositionCnfg;
	}

	public void setPlayerPositionCnfg(PlayerPositionCnfg playerPositionCnfg) {
		this.playerPositionCnfg = playerPositionCnfg;
	}

	public PlayerTypeCnfg getPlayerTypeCnfg() {
		return this.playerTypeCnfg;
	}

	public void setPlayerTypeCnfg(PlayerTypeCnfg playerTypeCnfg) {
		this.playerTypeCnfg = playerTypeCnfg;
	}

	public TeamsTable getTeam() {
		return this.team;
	}

	public void setTeam(TeamsTable teamsTable) {
		this.team = teamsTable;
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

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getStartBid() {
		return this.startBid;
	}

	public void setStartBid(Long startBid) {
		this.startBid = startBid;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public boolean isIsInAuction() {
		return this.isInAuction;
	}

	public void setIsInAuction(boolean isInAuction) {
		this.isInAuction = isInAuction;
	}

	public PlayerAttributes getPlayerAttributes() {
		return this.playerAttributes;
	}

	public void setPlayerAttributes(PlayerAttributes playerAttributes) {
		this.playerAttributes = playerAttributes;
	}

	public Set<TeamPlayerBid> getTeamPlayerBids() {
		return this.teamPlayerBids;
	}

	public void setTeamPlayerBids(Set<TeamPlayerBid> teamPlayerBids) {
		this.teamPlayerBids = teamPlayerBids;
	}

}
