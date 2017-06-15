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
@Table(name = "player_type_cnfg")
public class PlayerTypeCnfg {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "player_type_id", unique = true, nullable = false)
	private Integer playerTypeId;

	@Column(name = "type", nullable = false, length = 45)
	private String type;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "playerTypeCnfg")
	private Set<PlayersTable> players = new HashSet<PlayersTable>();

	public PlayerTypeCnfg() {
	}

	public PlayerTypeCnfg(String type) {
		this.type = type;
	}

	public PlayerTypeCnfg(String type, Set<PlayersTable> playersTables) {
		this.type = type;
		this.players = playersTables;
	}

	public Integer getPlayerTypeId() {
		return this.playerTypeId;
	}

	public void setPlayerTypeId(Integer playerTypeId) {
		this.playerTypeId = playerTypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<PlayersTable> getPlayers() {
		return this.players;
	}

	public void setPlayers(Set<PlayersTable> playersTables) {
		this.players = playersTables;
	}
	
	@Override 
	public String toString(){
		return type;
	}

}
