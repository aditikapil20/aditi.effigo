package com.mapping.mapping_task.controller;

import com.mapping.mapping_task.dtos.BankRequestDto;
import com.mapping.mapping_task.dtos.BankResponseDto;
import com.mapping.mapping_task.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    // ✅ Create or Update Bank Account
    @PostMapping("/create-account")
    public ResponseEntity<BankResponseDto> createBankAccount(@RequestBody BankRequestDto bankRequestDto) {
        BankResponseDto savedBankAccount = bankAccountService.saveBankAccount(bankRequestDto);
        return new ResponseEntity<>(savedBankAccount, HttpStatus.CREATED);
    }

    // ✅ Get Bank Account by ID
    @GetMapping("/{accountId}")
    public ResponseEntity<BankResponseDto> getBankAccountById(@PathVariable String accountId) {
        Optional<BankResponseDto> bankAccount = bankAccountService.getBankAccountById(accountId);
        return bankAccount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Get All Bank Accounts
    @GetMapping("/get-all")
    public ResponseEntity<List<BankResponseDto>> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.getAllBankAccounts());
    }

    // ✅ Delete Bank Account by ID
    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<String> deleteBankAccountById(@PathVariable String accountId) {
        bankAccountService.deleteBankAccountById(accountId);
        return ResponseEntity.ok("Bank Account with ID " + accountId + " has been deleted successfully.");
    }
}
