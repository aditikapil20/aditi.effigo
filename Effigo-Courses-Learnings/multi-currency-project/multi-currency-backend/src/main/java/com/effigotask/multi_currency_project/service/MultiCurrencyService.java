package com.effigotask.multi_currency_project.service;

import com.effigotask.multi_currency_project.entity.MultiCurrency;
import com.effigotask.multi_currency_project.repository.MultiCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiCurrencyService {

    @Autowired
    private MultiCurrencyRepository multiCurrencyRepository;

    public List<MultiCurrency> getAllMultiCurrency() {
        return multiCurrencyRepository.findAll();
    }

    public void deleteMultiCurrenciesByIds(List<String> ids) {
        multiCurrencyRepository.deleteAllById(ids);
    }

    public MultiCurrency addMultiCurrency(MultiCurrency multiCurrency) {
        return multiCurrencyRepository.save(multiCurrency);
    }

    public List<MultiCurrency> addMultiCurrencyList(List<MultiCurrency> multiCurrencyList) {
        return multiCurrencyRepository.saveAll(multiCurrencyList);
    }
}