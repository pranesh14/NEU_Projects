package com.fifa.entity;

public class TeamDebit {

	private String name;
	private long debitAmount;
	
	public TeamDebit(String name, long debitAmount) {		
		this.name = name;
		this.debitAmount = debitAmount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(long debitAmount) {
		this.debitAmount = debitAmount;
	}
	
}
