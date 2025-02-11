package com.mapping.mapping_task.service;

import com.mapping.mapping_task.dtos.TransRequestDto;
import com.mapping.mapping_task.dtos.TransResponseDto;
import com.mapping.mapping_task.entity.TransactionEntity;
import com.mapping.mapping_task.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Create or Update Transaction
    public TransResponseDto saveTransaction(TransRequestDto transRequestDto) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransactionId(transRequestDto.getTransactionId());
        transactionEntity.setTransactionType(transRequestDto.getTransactionType());
        transactionEntity.setTransactionAmount(transRequestDto.getTransactionAmount());

        TransactionEntity savedTransaction = transactionRepository.save(transactionEntity);
        return new TransResponseDto(savedTransaction.getTransactionId(),
                savedTransaction.getTransactionType(),
                savedTransaction.getTransactionAmount(),
                savedTransaction);
    }

    // Get Transaction by ID
    public Optional<TransResponseDto> getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId)
                .map(transactionEntity -> new TransResponseDto(transactionEntity.getTransactionId(),
                        transactionEntity.getTransactionType(),
                        transactionEntity.getTransactionAmount(),
                        transactionEntity));
    }

    // Get All Transactions
    public List<TransResponseDto> getAllTransactions() {
        List<TransactionEntity> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> new TransResponseDto(transaction.getTransactionId(),
                        transaction.getTransactionType(),
                        transaction.getTransactionAmount(),
                        transaction))
                .collect(Collectors.toList());
    }

    public void deleteTransactionById(String transactionId) {
        if (transactionRepository.existsById(transactionId)) {
            transactionRepository.deleteById(transactionId);
        } else {
            throw new RuntimeException("Transaction with ID " + transactionId + " not found.");
        }
    }
}
