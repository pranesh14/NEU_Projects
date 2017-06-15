package com.fifa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "player_attributes")
public class PlayerAttributes {

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "player"))
	@Column(name = "player_id", unique = true, nullable = false)
	private int playerId;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private PlayersTable player;

	@Column(name = "pace")
	private Integer pace;

	@Column(name = "shooting")
	private Integer shooting;

	@Column(name = "passing")
	private Integer passing;

	@Column(name = "dribbling")
	private Integer dribbling;

	@Column(name = "defending")
	private Integer defending;

	@Column(name = "physical")
	private Integer physical;

	public PlayerAttributes() {
	}

	public PlayerAttributes(PlayersTable playersTable) {
		this.player = playersTable;
	}

	public PlayerAttributes(PlayersTable playersTable, Integer pace, Integer shooting, Integer passing,
			Integer dribbling, Integer defending, Integer physical) {
		this.player = playersTable;
		this.pace = pace;
		this.shooting = shooting;
		this.passing = passing;
		this.dribbling = dribbling;
		this.defending = defending;
		this.physical = physical;
	}

	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public PlayersTable getPlayer() {
		return this.player;
	}

	public void setPlayer(PlayersTable playersTable) {
		this.player = playersTable;
	}

	public Integer getPace() {
		return this.pace;
	}

	public void setPace(Integer pace) {
		this.pace = pace;
	}

	public Integer getShooting() {
		return this.shooting;
	}

	public void setShooting(Integer shooting) {
		this.shooting = shooting;
	}

	public Integer getPassing() {
		return this.passing;
	}

	public void setPassing(Integer passing) {
		this.passing = passing;
	}

	public Integer getDribbling() {
		return this.dribbling;
	}

	public void setDribbling(Integer dribbling) {
		this.dribbling = dribbling;
	}

	public Integer getDefending() {
		return this.defending;
	}

	public void setDefending(Integer defending) {
		this.defending = defending;
	}

	public Integer getPhysical() {
		return this.physical;
	}

	public void setPhysical(Integer physical) {
		this.physical = physical;
	}

}
