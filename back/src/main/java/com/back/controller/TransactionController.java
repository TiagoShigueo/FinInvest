package com.back.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.model.Transaction;
import com.back.repository.TransactionRepository;

@CrossOrigin
@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<Transaction> transaction(@RequestBody @Validated Transaction transaction) {
        transactionRepository.save(transaction);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") int id,
            @RequestBody @Validated Transaction transaction) {
        Optional<Transaction> op = transactionRepository.findById(Integer.valueOf(id));
        if (op.isPresent()) {
            transaction.setIdTransaction(Long.valueOf(id));
            transactionRepository.save(transaction);
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") int id) {
        Optional<Transaction> op = transactionRepository.findById(id);
        if (op.isPresent()) {
            transactionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
