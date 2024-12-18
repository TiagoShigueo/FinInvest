package com.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
