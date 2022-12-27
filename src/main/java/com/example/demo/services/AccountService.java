package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.AccountEntity;
import com.example.demo.model.AccountRequest;
import com.example.demo.model.AccountResponse;
import com.example.demo.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountResponse getAccount(AccountRequest accountRequest)
	{
		AccountResponse response = new AccountResponse();
		AccountEntity accountEntity = new AccountEntity();
		Optional<AccountEntity> accountEntityWrapper = accountRepository.findByAccountNo(accountRequest.getAccountNo());
		if(accountEntityWrapper.isPresent())
		{
			accountEntity=accountEntityWrapper.get();
		}
		BeanUtils.copyProperties(accountEntity, response);
		return response;
	}
}
