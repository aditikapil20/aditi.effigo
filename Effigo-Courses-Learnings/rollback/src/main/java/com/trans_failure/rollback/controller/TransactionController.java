package com.trans_failure.rollback.controller;

import com.trans_failure.rollback.entity.MultiCurrency;
import com.trans_failure.rollback.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/multi-currency")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTransaction(@RequestBody MultiCurrency multiCurrency) {
        try {
            transactionService.performTransaction(multiCurrency);
            return ResponseEntity.ok("Transaction successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}