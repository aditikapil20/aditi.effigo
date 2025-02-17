package com.mapping.mapping_task.service;

import com.mapping.mapping_task.dtos.BankRequestDto;
import com.mapping.mapping_task.dtos.BankResponseDto;
import com.mapping.mapping_task.entity.BankAccountEntity;
import com.mapping.mapping_task.mappers.BankAccountMapper;
import com.mapping.mapping_task.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    public BankResponseDto saveBankAccount(BankRequestDto bankRequestDto) {
        BankAccountEntity bankAccountEntity = bankAccountMapper.toEntity(bankRequestDto);
        BankAccountEntity savedBankAccount = bankAccountRepository.save(bankAccountEntity);
        return bankAccountMapper.toDto(savedBankAccount);
    }

    public Optional<BankResponseDto> getBankAccountById(String accountId) {
        return bankAccountRepository.findById(accountId)
                .map(bankAccountMapper::toDto);
    }

    public List<BankResponseDto> getAllBankAccounts() {
        return bankAccountRepository.findAll()
                .stream()
                .map(bankAccountMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteBankAccountById(String accountId) {
        if (bankAccountRepository.existsById(accountId)) {
            bankAccountRepository.deleteById(accountId);
        } else {
            throw new RuntimeException("Bank Account with ID " + accountId + " not found.");
        }
    }
}
