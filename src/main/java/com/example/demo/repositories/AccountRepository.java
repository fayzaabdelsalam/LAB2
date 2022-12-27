package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Integer>{
	
	Optional<AccountEntity> findByCustomerID(Integer id);
	Optional<AccountEntity> findByAccountNo(Integer accountNo);	

}
