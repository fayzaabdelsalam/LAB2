package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountRequest;
import com.example.demo.model.AccountResponse;
import com.example.demo.services.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {
	
@Autowired
private AccountService accountService;

@CrossOrigin(origins="*", allowedHeaders="*")
@PostMapping
public AccountResponse getAccount(@RequestBody AccountRequest accountRequest) 
{
	AccountResponse response;
	response=accountService.getAccount(accountRequest);
	return response;
}

}
