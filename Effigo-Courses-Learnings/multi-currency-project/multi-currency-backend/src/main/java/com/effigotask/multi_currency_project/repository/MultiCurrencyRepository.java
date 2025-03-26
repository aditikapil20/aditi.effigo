package com.effigotask.multi_currency_project.repository;

import com.effigotask.multi_currency_project.entity.MultiCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiCurrencyRepository extends JpaRepository<MultiCurrency, String> {
}
