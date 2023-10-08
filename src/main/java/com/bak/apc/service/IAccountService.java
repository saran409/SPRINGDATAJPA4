package com.bak.apc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bak.apc.entity.Account;

 

@Service
public interface IAccountService {
	
	public int saveAccount(Account e);
	public Account getAccountById(int searchId);
    public List<Account> getAllAccounts();
    public List<Account> findByBalanceBetween(int startBalance, int endBalance);
	public List<Account> getAccountByBranchLocation(String location);
	public Account updateAccount(int searchId,int newBalance);
	
    


	
	
	
 
	

}
