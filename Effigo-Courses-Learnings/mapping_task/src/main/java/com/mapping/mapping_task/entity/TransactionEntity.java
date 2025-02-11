package com.mapping.mapping_task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction_details")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;  // Changed to transactionId for clarity

    private String transactionType; // e.g., Credit or Debit
    private double transactionAmount;

    // many transaction is linked to one bank account
    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    @JsonBackReference // child side pr lgta hai
    private BankAccountEntity bankAccountEntity;

}


