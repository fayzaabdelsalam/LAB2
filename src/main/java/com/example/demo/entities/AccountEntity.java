package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account_entity")
public class AccountEntity {
	
	@Id
	@GeneratedValue
	@Column(name="account_no")
	private Integer accountNo;
	@Column(name="internet_banking")
	private Boolean internetBanking;
	@Column(name="balance")
	private Double balance;
	@Column(name="currency")
	private String currency;
	@Column(name="account_type")
	private String accountType;
	@Column(name="min_deposit")
	private Integer minDeposit;
	@Column(name="opening_fees")
	private Double openingFees;
	@Column(name="customer_ID")
	private Integer customerID;

	@ManyToOne
	@JoinColumn(name="customer_ID", referencedColumnName = "ID" , insertable = false ,
	updatable = false , nullable = false)
	private UserEntity customer;
	@OneToMany(mappedBy="accountEntity")
	private Set<TransactionEntity> transactions;
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public Boolean getInternetBanking() {
		return internetBanking;
	}
	public void setInternetBanking(Boolean internetBanking) {
		this.internetBanking = internetBanking;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getMinDeposit() {
		return minDeposit;
	}
	public void setMinDeposit(Integer minDeposit) {
		this.minDeposit = minDeposit;
	}
	public Double getOpeningFees() {
		return openingFees;
	}
	public void setOpeningFees(Double openingFees) {
		this.openingFees = openingFees;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public UserEntity getCustomer() {
		return customer;
	}
	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}
	public Set<TransactionEntity> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<TransactionEntity> transactions) {
		this.transactions = transactions;
	}

}
