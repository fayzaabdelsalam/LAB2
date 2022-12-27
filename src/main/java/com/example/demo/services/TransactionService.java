package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TransactionEntity;
import com.example.demo.model.TransactionResponse;
import com.example.demo.repositories.TransactionRepository;


@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<TransactionResponse> getTransactions()
	{
		List<TransactionResponse> responses = new ArrayList<>();
		List<TransactionEntity> entity = transactionRepository.findAll();
		for (TransactionEntity e : entity)
		{
			TransactionResponse response = new TransactionResponse();
			BeanUtils.copyProperties(e, response);
			responses.add(response);
		}
		return responses;
	}
}
