package com.example.demo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountRequest;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.Response;
import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UsersService userService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "getuser")
	public UserResponse getuser(@RequestBody UserRequest userRequest) {
		UserResponse userResponse;
		userResponse = userService.getUser(userRequest);
		return userResponse;
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "login")
	public Response login(@RequestBody UserRequest userRequest) {
		Response response;
		response = userService.login(userRequest);
		return response;
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "manage")
	public List<AccountResponse> manage(@RequestBody UserRequest userRequest) {
		List<AccountResponse> accountResponse;
		accountResponse = userService.manage(userRequest);
		return accountResponse;

	}
	@CrossOrigin(origins="*" , allowedHeaders =  "*")
	@PostMapping(path = "register")
	public Response register(@RequestBody UserRequest request) {
		Response userResponse;
		userResponse = userService.register(request);
		return userResponse;
	}
	@CrossOrigin(origins="*" , allowedHeaders =  "*")
	@PostMapping(path = "paybills")
	public Response payBills(@RequestBody TransactionRequest transactionRequest) {
		Response response;
		response = userService.payBills(transactionRequest);
		return response;
	}
	
	@CrossOrigin(origins="*" , allowedHeaders =  "*")
	@PostMapping(path = "transfer")
	public Response transfer(@RequestBody TransactionRequest transactionRequest) {
		Response response;
		response = userService.transfer(transactionRequest);
		return response;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "transactionhistory")
	public List<TransactionResponse> transactionHistory(@RequestBody AccountRequest accountRequest) {
		List<TransactionResponse> transactionResponse;
		transactionResponse = userService.transactionHistory(accountRequest);
		return transactionResponse;
	}
}