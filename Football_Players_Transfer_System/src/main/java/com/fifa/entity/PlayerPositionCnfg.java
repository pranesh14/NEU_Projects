package com.fifa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player_position_cnfg")
public class PlayerPositionCnfg {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "position_cnfg_id", unique = true, nullable = false)
	private Integer positionCnfgId;

	@Column(name = "position", nullable = false, length = 45)
	private String position;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "playerPositionCnfg")
	private Set<PlayersTable> players = new HashSet<PlayersTable>();

	public PlayerPositionCnfg() {
	}

	public PlayerPositionCnfg(String position) {
		this.position = position;
	}

	public PlayerPositionCnfg(String position, Set<PlayersTable> playersTables) {
		this.position = position;
		this.players = playersTables;
	}

	public Integer getPositionCnfgId() {
		return this.positionCnfgId;
	}

	public void setPositionCnfgId(Integer positionCnfgId) {
		this.positionCnfgId = positionCnfgId;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Set<PlayersTable> getPlayers() {
		return this.players;
	}

	public void setPlayers(Set<PlayersTable> playersTables) {
		this.players = playersTables;
	}
	
	@Override 
	public String toString(){
		return position;
	}

}
