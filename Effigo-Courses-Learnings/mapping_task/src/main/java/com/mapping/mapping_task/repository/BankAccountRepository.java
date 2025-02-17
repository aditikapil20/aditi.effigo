package com.mapping.mapping_task.repository;

import com.mapping.mapping_task.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, String> {
    // <Entity class, Primary key datatype(wrapper class)>
    // JPA repository interacts with the database and handles CRUD operations.

    // Custom query: To fetch accounts by account type

}

