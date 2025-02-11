package com.mapping.mapping_task.dtos;

import com.mapping.mapping_task.entity.BankAccountEntity;
import com.mapping.mapping_task.entity.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BankResponseDto {

    private String accountId;

    private String accountHolderName;
    private String accountNumber;
    private String accountType; // e.g., Savings, Current, FD, RD
    private double balance;

    private BankAccountEntity bankAccountEntity;
    public BankResponseDto(BankAccountEntity bankAccountEntity)
    {
        this.bankAccountEntity = bankAccountEntity;
    }

}
