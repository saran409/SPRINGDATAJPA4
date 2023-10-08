package com.bak.apc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bak.apc.entity.Account;
import com.bak.apc.service.IAccountService;

@RestController
@RequestMapping("/accapp")
public class AccountController {
	
	@Autowired
	IAccountService service;

	public AccountController() {
		System.out.println("inside contructor ");
	}

	@PostMapping("/register/account")
	public int saveAccount(@RequestBody Account e)
	{
		 int notification =  service.saveAccount(e);
		 return notification;
	}
	@GetMapping("/accounts")  /// www.localhost:9211/accapp/accounts
	public ResponseEntity<List<Account>> getAccount()
	{
		System.out.println("inside controller getEmployees()");
		List<Account> temp =  service.getAllAccounts();
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable int id)
	{
		return service.getAccountById(id);
	}
	
	
	
	@PutMapping("/upaccount")
	public ResponseEntity<Account> updateAccountSalary(@RequestParam int accid,@RequestParam int bal)
	{
		Account updatedAccount = service.updateAccount(accid, bal);
		Account e = new Account();
		if(updatedAccount != null)
		{
			return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Account>(e, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/account/location")   
	public ResponseEntity<List<Account>> getAccounts(@RequestParam String loc)
	{
		System.out.println("inside controller getAccountsBy Location()");
		List<Account> temp = service.getAccountByBranchLocation(loc);
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);
	}

	@GetMapping("/account/balance")  ///  
	public ResponseEntity<List<Account>> getAccountsOnBalance(@RequestParam int stbal, @RequestParam int edbal)
	{
		System.out.println("inside controller getAccountsBy  Balance()");
		List<Account> temp = service. findByBalanceBetween(stbal, edbal);
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);
	}
}
