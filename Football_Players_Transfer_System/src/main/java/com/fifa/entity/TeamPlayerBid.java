package com.fifa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team_player_bid")
public class TeamPlayerBid {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bid_id", unique = true, nullable = false)
	private Integer bidId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player_id", nullable = false)
	private PlayersTable player;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id", nullable = false)
	private TeamsTable team;

	@Column(name = "bid_amount", nullable = false)
	private long bidAmount;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	public TeamPlayerBid() {
	}

	public TeamPlayerBid(PlayersTable playersTable, TeamsTable teamsTable, long bidAmount, boolean isActive) {
		this.player = playersTable;
		this.team = teamsTable;
		this.bidAmount = bidAmount;
		this.isActive = isActive;
	}

	public Integer getBidId() {
		return this.bidId;
	}

	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}

	public PlayersTable getPlayer() {
		return this.player;
	}

	public void setPlayer(PlayersTable playersTable) {
		this.player = playersTable;
	}

	public TeamsTable getTeam() {
		return this.team;
	}

	public void setTeam(TeamsTable teamsTable) {
		this.team = teamsTable;
	}

	public long getBidAmount() {
		return this.bidAmount;
	}

	public void setBidAmount(long bidAmount) {
		this.bidAmount = bidAmount;
	}

	public boolean isIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
