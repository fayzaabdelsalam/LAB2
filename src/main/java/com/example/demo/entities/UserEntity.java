package com.example.demo.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

		@Entity
		@Table(name="customer", uniqueConstraints = { @UniqueConstraint(columnNames = {"email"}) })
		public class UserEntity {
		@Id
		@GeneratedValue
		private Integer id;
		@Column(name="NID")
		private String nationalId;
		@Column(name="passport")
		private String passport;
		@Column(name="customer_name")
		private String name;
		@Column(name="birthdate")
		private Date birthdate;
		@Column(name="address")
		private String address;
		@Column(name="marital_status")
		private String maritalStatus;
		@Column(name="nationality")
		private String nationality;
		@Column(name="HR_letter")
		private Boolean hrLetter;
		@Column(name="mobile_no")
		private String mobileNo;
		@Column(name="email",unique=true)
		private String email;
		@Column(name="pass")
		private String password;
		@OneToMany(mappedBy="customer")
		private Set<AccountEntity> accounts;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNationalId() {
			return nationalId;
		}
		public void setNationalId(String nationalId) {
			this.nationalId = nationalId;
		}
		public String getPassport() {
			return passport;
		}
		public void setPassport(String passport) {
			this.passport = passport;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getBirthdate() {
			return birthdate;
		}
		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public Boolean getHrLetter() {
			return hrLetter;
		}
		public void setHrLetter(Boolean hrLetter) {
			this.hrLetter = hrLetter;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Set<AccountEntity> getAccounts() {
			return accounts;
		}
		public void setAccounts(Set<AccountEntity> accounts) {
			this.accounts = accounts;
		}
		
}