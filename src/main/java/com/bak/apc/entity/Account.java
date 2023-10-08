package com.bak.apc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_Table")
public class Account {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int balance;
	private String branchLocation;
	private int mobilePin;
	private String accountType;
	
	 
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(int balance, String branchLocation, int mobilePin, String accountType) {
		super();
		this.balance = balance;
		this.branchLocation = branchLocation;
		this.mobilePin = mobilePin;
		this.accountType = accountType;
	}
	
	
	public Account(int id, int balance, String branchLocation, int mobilePin, String accountType) {
		super();
		this.id = id;
		this.balance = balance;
		this.branchLocation = branchLocation;
		this.mobilePin = mobilePin;
		this.accountType = accountType;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getBranchLocation() {
		return branchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	public int getMobilePin() {
		return mobilePin;
	}
	public void setMobilePin(int mobilePin) {
		this.mobilePin = mobilePin;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
