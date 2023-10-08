package com.bak.apc.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bak.apc.entity.Account;

@Repository
public interface IAccountRepostory extends JpaRepository<Account, Integer> {
	
	
	public List<Account> findByBalanceBetween(int startBalance, int endBalance);
	public List<Account> getEmployeeByBranchLocation(String location);

}
