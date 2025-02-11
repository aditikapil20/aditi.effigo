package com.mapping.mapping_task.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


//@Data
@Entity
@Table(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;  // Changed to userId for clarity

    private String name;
    private int age;

    // One user has one bank account
    @OneToOne(mappedBy = "userEntity")
    @JsonManagedReference  // Prevents infinite recursion  (parent side)
    private BankAccountEntity bankAccountEntity;

    public UserEntity() {
    }

    public UserEntity(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BankAccountEntity getBankAccountEntity() {
        return bankAccountEntity;
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }
}

