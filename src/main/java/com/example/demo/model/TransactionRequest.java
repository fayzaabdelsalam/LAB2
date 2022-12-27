package com.example.demo.model;

import java.sql.Date;

import org.springframework.lang.NonNull;

public class TransactionRequest {
	private Integer ID;
	@NonNull
	private Integer receiverNo;
	@NonNull
	private Double amount;
	@NonNull
	private String transactionType;
	private Date transactionDate;
	private Integer accountNo;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getReceiverNo() {
		return receiverNo;
	}
	public void setReceiverNo(Integer receiverNo) {
		this.receiverNo = receiverNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	
}
