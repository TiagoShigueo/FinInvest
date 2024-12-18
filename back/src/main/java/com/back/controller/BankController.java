package com.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.model.Bank;
import com.back.repository.BankRepository;

@CrossOrigin
@RestController
@RequestMapping("bank")
public class BankController {
    @Autowired
    BankRepository bankRepository;

    public static List<Bank> banks = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks() {
        List<Bank> bankList = bankRepository.findAll();
        return ResponseEntity.ok(bankList);
    }
}
