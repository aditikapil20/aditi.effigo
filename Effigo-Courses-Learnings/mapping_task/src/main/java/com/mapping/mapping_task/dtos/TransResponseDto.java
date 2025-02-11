package com.mapping.mapping_task.dtos;

import com.mapping.mapping_task.entity.TransactionEntity;
import com.mapping.mapping_task.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransResponseDto {

    private String transactionId;
    private String transactionType; // e.g., Credit or Debit
    private double transactionAmount;

    private TransactionEntity transactionEntity;
    public TransResponseDto(TransactionEntity transactionEntity)
    {
        this.transactionEntity = transactionEntity;
    }

}
