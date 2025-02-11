package com.mapping.mapping_task.service;

import com.mapping.mapping_task.dtos.BankRequestDto;
import com.mapping.mapping_task.dtos.BankResponseDto;
import com.mapping.mapping_task.entity.BankAccountEntity;
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

    // ✅ Create or Update Bank Account
    public BankResponseDto saveBankAccount(BankRequestDto bankRequestDto) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setAccountId(bankRequestDto.getAccountId());
        bankAccountEntity.setAccountHolderName(bankRequestDto.getAccountHolderName());
        bankAccountEntity.setAccountNumber(bankRequestDto.getAccountNumber());
        bankAccountEntity.setAccountType(bankRequestDto.getAccountType());
        bankAccountEntity.setBalance(bankRequestDto.getBalance());

        BankAccountEntity savedBankAccount = bankAccountRepository.save(bankAccountEntity);
        return new BankResponseDto(savedBankAccount.getAccountId(),
                savedBankAccount.getAccountHolderName(),
                savedBankAccount.getAccountNumber(),
                savedBankAccount.getAccountType(),
                savedBankAccount.getBalance(),
                savedBankAccount);
    }

    // ✅ Get Bank Account by ID
    public Optional<BankResponseDto> getBankAccountById(String accountId) {
        return bankAccountRepository.findById(accountId)
                .map(bankAccountEntity -> new BankResponseDto(
                        bankAccountEntity.getAccountId(),
                        bankAccountEntity.getAccountHolderName(),
                        bankAccountEntity.getAccountNumber(),
                        bankAccountEntity.getAccountType(),
                        bankAccountEntity.getBalance(),
                        bankAccountEntity));
    }

    // ✅ Get All Bank Accounts
    public List<BankResponseDto> getAllBankAccounts() {
        List<BankAccountEntity> bankAccounts = bankAccountRepository.findAll();
        return bankAccounts.stream()
                .map(bankAccountEntity -> new BankResponseDto(
                        bankAccountEntity.getAccountId(),
                        bankAccountEntity.getAccountHolderName(),
                        bankAccountEntity.getAccountNumber(),
                        bankAccountEntity.getAccountType(),
                        bankAccountEntity.getBalance(),
                        bankAccountEntity))
                .collect(Collectors.toList());
    }

    // ✅ Delete Bank Account by ID
    public void deleteBankAccountById(String accountId) {
        if (bankAccountRepository.existsById(accountId)) {
            bankAccountRepository.deleteById(accountId);
        } else {
            throw new RuntimeException("Bank Account with ID " + accountId + " not found.");
        }
    }
}
