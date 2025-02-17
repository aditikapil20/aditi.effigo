package com.mapping.mapping_task.controller;

import com.mapping.mapping_task.dtos.TransRequestDto;
import com.mapping.mapping_task.dtos.TransResponseDto;
import com.mapping.mapping_task.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<TransResponseDto> createTransaction(@RequestBody TransRequestDto transRequestDto) {
        TransResponseDto savedTransaction = transactionService.saveTransaction(transRequestDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransResponseDto> getTransactionById(@PathVariable String transactionId) {
        Optional<TransResponseDto> transaction = transactionService.getTransactionById(transactionId);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/get-all-trans")
    public ResponseEntity<List<TransResponseDto>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @DeleteMapping("/delete/{transactionId}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable String transactionId) {
        transactionService.deleteTransactionById(transactionId);
        return ResponseEntity.ok("Transaction with ID " + transactionId + " has been deleted successfully.");
    }
}
