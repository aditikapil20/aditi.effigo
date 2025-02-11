package com.mapping.mapping_task.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BankRequestDto {

    private String accountId;

    private String accountHolderName;
    private String accountNumber;
    private String accountType; // e.g., Savings, Current, FD, RD
    private double balance;
}
