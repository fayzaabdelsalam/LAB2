package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.TransactionEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.model.AccountRequest;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.Response;
import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	public UserResponse getUser(UserRequest userRequest) {
		
		UserResponse response = new UserResponse();
		UserEntity userEntity;
		AccountEntity accountEntity;
		Optional<AccountEntity> accountEntityWrapper = accountRepository.findByAccountNo(userRequest.getAccountNo());
		if (accountEntityWrapper.isPresent())
		{
		accountEntity = accountEntityWrapper.get();
		Optional<UserEntity> userEntityWrapper = userRepository.findById(accountEntity.getCustomerID());
		if (userEntityWrapper.isPresent()) 
		{
			userEntity = userEntityWrapper.get();
			BeanUtils.copyProperties(userEntity, response);
		}
		}
		return response;
	}

	public Response register (UserRequest userRequest) 
	{
		UserEntity userEntity;
		Response res = new Response();
		Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(userRequest.getEmail());
		if (userEntityWrapper.isPresent()) 
		{
			userEntity = userEntityWrapper.get();	
			AccountEntity accountEntity;
			Optional<AccountEntity> accountEntityWrapper = accountRepository.findById(userRequest.getAccountNo());
	
				if (accountEntityWrapper.isPresent()) 
				{
					accountEntity = accountEntityWrapper.get();
					Boolean hasInternetBanking = accountEntity.getInternetBanking();
					if (Boolean.TRUE.equals((hasInternetBanking)))
							{
								res.setStatus("1");
								res.setMessage("existing user");
								return res;
							}
					else if (Objects.equals(userRequest.getAccountNo(), accountEntity.getAccountNo()) &&
							Objects.equals(userRequest.getEmail(), userEntity.getEmail()) &&
//							Objects.equals(userRequest.getBirthdate(), userEntity.getBirthdate()) &&
							Objects.equals(userRequest.getMobileNo(), userEntity.getMobileNo()))
						{
							if (Objects.equals(userRequest.getPassword(), userRequest.getMatchingPassword())) 
							{
								userEntity.setPassword(userRequest.getPassword());
								accountEntity.setInternetBanking(true);
								userRepository.saveAndFlush(userEntity);
								accountRepository.saveAndFlush(accountEntity);
								res.setStatus("2");
								res.setMessage("Registered successfully");
								return res;
							} 
							else
							{
								res.setStatus("3");
								res.setMessage("passwords don't match");
								return res;
							}
						}
					else
					{
						res.setStatus("4");
						res.setMessage("Please enter valid KYC information");
					}
				}
				else
				{
							res.setStatus("0");
							res.setMessage("Unregistered account");
							return res;
				}
				
		}
		else
		{
			res.setStatus("5");
			res.setMessage("please sign up with the registered email");
			return res;
		}
		return res;
}
		
	public Response login (UserRequest userRequest)
	{
		Response res = new Response();
		Optional<AccountEntity> accountEntityWrapper = accountRepository.findByAccountNo(userRequest.getAccountNo());
		if (accountEntityWrapper.isPresent()) 
		{
			AccountEntity accountEntity =  accountEntityWrapper.get();
			
			Optional<UserEntity> userEntityWrapper = userRepository.findById(accountEntity.getCustomerID());
			UserEntity userEntity = new UserEntity();
			if (userEntityWrapper.isPresent()) 
			{
				userEntity = userEntityWrapper.get();
			}
				if (Objects.equals(userRequest.getPassword(), userEntity.getPassword()))
					{
						res.setStatus("1");
						res.setMessage("login successfully");
							return res;
					}
				else
					{
						res.setStatus("0");
						res.setMessage("incorrect password");
							return res;
					}
		}
		else
		{
			res.setStatus("2");
			res.setMessage("create new account");
			return res;
		}
}
	public List<AccountResponse> manage(UserRequest userRequest)
	{
			UserEntity userEntity;
			AccountEntity accountEntity;
			Optional<AccountEntity> accountEntityWrapper = accountRepository.findByAccountNo(userRequest.getAccountNo());
			List<AccountResponse> allUserAccounts = new ArrayList<>();
			if (accountEntityWrapper.isPresent())
			{
			accountEntity = accountEntityWrapper.get();
			Optional<UserEntity> userEntityWrapper = userRepository.findById(accountEntity.getCustomerID());
			if (userEntityWrapper.isPresent()) 
			{
				userEntity = userEntityWrapper.get();
			List<AccountEntity> allaccountsEntity = accountRepository.findAll();
			for (AccountEntity e : allaccountsEntity)
			{
				AccountResponse accountResponse = new AccountResponse();
				BeanUtils.copyProperties(e, accountResponse);
				if(Objects.equals(userEntity.getId(), e.getCustomerID()))
				{
						allUserAccounts.add(accountResponse);
				}
			}
			return allUserAccounts;
			}
			}
			return allUserAccounts;
	}
	public Response payBills(TransactionRequest transactionRequest)
	{
		Response res = new Response();

		AccountEntity accountEntity = new AccountEntity();
		Optional<AccountEntity> accountEntityWrapper = accountRepository.findById(transactionRequest.getAccountNo());
		TransactionEntity transactionEntity = new TransactionEntity();
		if (accountEntityWrapper.isPresent()) 
		{
			accountEntity = accountEntityWrapper.get();
		}
		if (accountEntity.getBalance() >= transactionRequest.getAmount())
		{
			accountEntity.setBalance(accountEntity.getBalance()-transactionRequest.getAmount());
			accountRepository.saveAndFlush(accountEntity);
//			accountRepository.save(accountEntity);
			transactionEntity.setAccountNo(transactionRequest.getAccountNo());
			transactionEntity.setReceiverNo(transactionRequest.getReceiverNo());
			transactionEntity.setAmount(transactionRequest.getAmount());
			transactionEntity.setTransactionType("paybills");
			transactionEntity.setTransactionDate(transactionRequest.getTransactionDate());
			transactionRepository.saveAndFlush(transactionEntity);
//			transactionRepository.save(transactionEntity);
			res.setMessage("Successfully Paid");
			res.setStatus("1");
			return res;
		}
		
		else
		{
			res.setStatus("0");
			res.setMessage("Not Enough Balance");
			return res;
		}
	}
	public Response transfer (TransactionRequest transactionRequest)
	{
		Response res = new Response();
		AccountEntity accountEntity = new AccountEntity();
		TransactionEntity transactionEntity = new TransactionEntity();
		Optional<AccountEntity> accountEntityWrapper = accountRepository.findById(transactionRequest.getAccountNo());
		if (accountEntityWrapper.isPresent()) 
		{
			accountEntity = accountEntityWrapper.get();
		}
		if (accountEntity.getBalance() >= transactionRequest.getAmount())
		{
			accountEntity.setBalance(accountEntity.getBalance()-transactionRequest.getAmount());
			accountRepository.saveAndFlush(accountEntity);
//			accountRepository.save(accountEntity);
			transactionEntity.setAccountNo(transactionRequest.getAccountNo());
			transactionEntity.setReceiverNo(transactionRequest.getReceiverNo());
			transactionEntity.setAmount(transactionRequest.getAmount());
			transactionEntity.setTransactionType("transferred");
//			transactionEntity.setTransactionDate(transactionRequest.getTransactionDate());
			transactionRepository.saveAndFlush(transactionEntity);
//			transactionRepository.save(transactionEntity);
			accountEntityWrapper = accountRepository.findById(transactionRequest.getReceiverNo());
			if(accountEntityWrapper.isPresent())
			{
				AccountEntity receiverAccountEntity = accountEntityWrapper.get();
				if(Objects.equals(receiverAccountEntity.getCurrency(), accountEntity.getCurrency()))
				{
					receiverAccountEntity.setBalance(receiverAccountEntity.getBalance()+transactionRequest.getAmount());
					accountRepository.saveAndFlush(receiverAccountEntity);
					//accountRepository.save(receiverAccountEntity);
					res.setStatus("1");
					res.setMessage("Amount Transferred Successfully");
					return res;
				}
				else
				{
					if ("USD".equals(accountEntity.getCurrency()))
					{
						receiverAccountEntity.setBalance(receiverAccountEntity.getBalance()+transactionRequest.getAmount()*26);
						accountRepository.saveAndFlush(receiverAccountEntity);
//						accountRepository.save(receiverAccountEntity);
						res.setStatus("1");
						res.setMessage("Amount Transferred Successfully");
						return res;
					}
					else
					{
						receiverAccountEntity.setBalance(receiverAccountEntity.getBalance()+(transactionRequest.getAmount()/26));
						accountRepository.saveAndFlush(receiverAccountEntity);
//						accountRepository.save(receiverAccountEntity);
						res.setMessage("Amount Transferred Successfully");
						res.setStatus("1");
						return res;

					}
				}
			}	
			else 
			{
				res.setStatus("1");
				res.setMessage("Amount Transferred Successfully");
				return res;
			}
		}
		else
		{
			res.setMessage("Not Enough Balance");
			res.setStatus("0");
			return res;
		}
		
	}
	public List<TransactionResponse> transactionHistory(AccountRequest accountRequest)
	{
		AccountEntity accountEntity = new AccountEntity();
		Optional<AccountEntity> accountEntityWrapper = accountRepository.findById(accountRequest.getAccountNo());
		if (accountEntityWrapper.isPresent()) 
		{
			accountEntity = accountEntityWrapper.get();
		}
		List<TransactionResponse> allTransactions = new ArrayList<>();
		List<TransactionEntity> transactionEntity = transactionRepository.findAll();
		for (TransactionEntity e : transactionEntity)
		{
			TransactionResponse transactionResponse = new TransactionResponse();
			BeanUtils.copyProperties(e, transactionResponse);
			if(Objects.equals(accountEntity.getAccountNo(), e.getAccountNo()))
			{
			allTransactions.add(transactionResponse);
			}
		}
		return allTransactions;
	}
}