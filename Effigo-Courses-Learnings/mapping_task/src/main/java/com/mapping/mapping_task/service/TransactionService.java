package com.mapping.mapping_task.service;

import com.mapping.mapping_task.dtos.TransRequestDto;
import com.mapping.mapping_task.dtos.TransResponseDto;
import com.mapping.mapping_task.entity.TransactionEntity;
import com.mapping.mapping_task.mappers.TransactionMapper;
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

    @Autowired
    private TransactionMapper transactionMapper;

    public TransResponseDto saveTransaction(TransRequestDto transRequestDto) {
        TransactionEntity transactionEntity = transactionMapper.toEntity(transRequestDto);
        TransactionEntity savedTransaction = transactionRepository.save(transactionEntity);
        return transactionMapper.toDto(savedTransaction);
    }

    public Optional<TransResponseDto> getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId)
                .map(transactionMapper::toDto);
    }

    public List<TransResponseDto> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMapper::toDto)
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
