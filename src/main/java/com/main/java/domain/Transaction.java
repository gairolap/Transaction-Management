package com.main.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "TRANTIMESTAMP")
	private Long tranTimestamp;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Double amount, Long tranTimestamp) {
		this.amount = amount;
		this.tranTimestamp = tranTimestamp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTranTimestamp() {
		return tranTimestamp;
	}

	public void setTranTimestamp(Long tranTimestamp) {
		this.tranTimestamp = tranTimestamp;
	}

	@Override
	public String toString() {
		return "amount =" + amount + "tranTimestamp =" + tranTimestamp;
	}
}