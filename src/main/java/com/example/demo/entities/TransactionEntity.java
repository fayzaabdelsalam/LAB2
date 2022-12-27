package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction_entity")
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="receiver_no")
	private Integer receiverNo;
	@Column(name="amount")
	private Double amount;
	@Column(name="transaction_type")
	private String transactionType;
	@Column(name="transaction_date")
	private Date transactionDate;
	@Column(name="account_no")
	private Integer accountNo;
	@ManyToOne
	@JoinColumn(name="account_no", referencedColumnName = "account_no" , insertable = false ,
	updatable = false , nullable = false)
	private AccountEntity accountEntity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}
	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}
	
	
}
