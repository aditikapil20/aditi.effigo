package com.mapping.mapping_task.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransRequestDto {

    private String transactionId;
    private String transactionType; // e.g., Credit or Debit
    private double transactionAmount;
}
