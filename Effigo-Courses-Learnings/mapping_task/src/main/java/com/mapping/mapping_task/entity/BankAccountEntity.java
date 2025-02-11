package com.mapping.mapping_task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;  // Changed to accountId for clarity

    private String accountHolderName;
    private String accountNumber;
    private String accountType; // e.g., Savings, Current, FD, RD
    private double balance;

    // One bank account belongs to one user
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference  // Prevents infinite recursion
    private UserEntity userEntity;

    // One bank account can have many transactions
    @OneToMany(mappedBy = "bankAccountEntity")
    @JsonManagedReference
    private List<TransactionEntity> transactions;
}


