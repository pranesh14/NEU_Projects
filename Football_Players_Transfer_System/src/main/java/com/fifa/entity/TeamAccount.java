package com.fifa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "fetchAllTeamAccounts", query = "from TeamAccount") })

@Entity
@Table(name = "team_account")
public class TeamAccount {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Integer accountId;

	@OneToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamsTable team;

	@Column(name = "account_number", nullable = false, length = 45)
	private String accountNumber;

	@Column(name = "debit_amount")
	private Long debitAmount;

	public TeamAccount() {
	}

	public TeamAccount(TeamsTable teamsTable, String accountNumber) {
		this.team = teamsTable;
		this.accountNumber = accountNumber;
	}

	public TeamAccount(TeamsTable teamsTable, String accountNumber, Long debitAmount) {
		this.team = teamsTable;
		this.accountNumber = accountNumber;
		this.debitAmount = debitAmount;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public TeamsTable getTeam() {
		return this.team;
	}

	public void setTeam(TeamsTable teamsTable) {
		this.team = teamsTable;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getDebitAmount() {
		return this.debitAmount;
	}

	public void setDebitAmount(Long debitAmount) {
		this.debitAmount = debitAmount;
	}

}
