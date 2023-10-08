package com.bak.apc.service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bak.apc.entity.Account;
import com.bak.apc.repostory.IAccountRepostory;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	IAccountRepostory accRepository;
	
	// Animal a = new Dog();
	
	
	
	@Override
	public int saveAccount(Account e) {
		Account savedAccounts = accRepository.save(e);
		if(savedAccounts !=null)
		{
			return savedAccounts.getId();
		}
		else return 0;
	}

	@Override
	public Account getAccountById(int searchId) {
		 Account savedAccounts = accRepository.findById(searchId).get();
		 if(savedAccounts !=null)
			{
				return savedAccounts;
			}
			else return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> allSavedAccounts =  accRepository.findAll();
		if(allSavedAccounts != null || allSavedAccounts.size() != 0)
		{
			return allSavedAccounts;
		}
		else return null;
	}
	
	@Override
	public List<Account> findByBalanceBetween(int startBalance, int endBalance) {
		return accRepository.findByBalanceBetween(startBalance, endBalance);
	}
	
	@Override
	public List<Account>getAccountByBranchLocation(String location) {
		return accRepository.getEmployeeByBranchLocation(location);
	}
	
	@Override
	@Transactional
	public Account updateAccount(int searchId,int newBalance)
	{
		Account savedAccounts = getAccountById(searchId);
		if(savedAccounts !=null)
		{
			savedAccounts.setBalance(newBalance);
			return savedAccounts;
		}
		
		
		return null;
	}


}
