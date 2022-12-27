package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TransactionResponse;
import com.example.demo.services.TransactionService;

@RestController
@RequestMapping("transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
@GetMapping
public List<TransactionResponse> gettransactions()
{
	List<TransactionResponse> response = new ArrayList<>();
	response = transactionService.getTransactions();
	return response;
}
}
