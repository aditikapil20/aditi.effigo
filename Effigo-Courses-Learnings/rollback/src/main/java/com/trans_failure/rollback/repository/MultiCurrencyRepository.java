package com.trans_failure.rollback.repository;

import com.trans_failure.rollback.entity.MultiCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiCurrencyRepository extends JpaRepository<MultiCurrency, String> {
}

