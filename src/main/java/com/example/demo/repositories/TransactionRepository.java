package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.TransactionEntity;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer>{

}
