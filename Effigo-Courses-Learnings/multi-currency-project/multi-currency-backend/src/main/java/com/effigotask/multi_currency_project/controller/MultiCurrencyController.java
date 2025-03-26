package com.effigotask.multi_currency_project.controller;

import com.effigotask.multi_currency_project.entity.MultiCurrency;
import com.effigotask.multi_currency_project.service.MultiCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/multi-currency")
public class MultiCurrencyController {

    @Autowired
    private MultiCurrencyService multiCurrencyService;

    @PostMapping("/add")
    public ResponseEntity<MultiCurrency> addMultiCurrency(@RequestBody MultiCurrency multiCurrency) {
        MultiCurrency savedData = multiCurrencyService.addMultiCurrency(multiCurrency);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping("/all")
    public List<MultiCurrency> getAllMultiCurrency() {
        return multiCurrencyService.getAllMultiCurrency();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMultiCurrencies(@RequestBody List<String> ids) {
        multiCurrencyService.deleteMultiCurrenciesByIds(ids);
        return ResponseEntity.ok("Selected records deleted successfully.");
    }

    @PostMapping("/add-list")
    public ResponseEntity<List<MultiCurrency>> addMultiCurrencyList(@RequestBody List<MultiCurrency> multiCurrencyList) {
        List<MultiCurrency> savedData = multiCurrencyService.addMultiCurrencyList(multiCurrencyList);
        return ResponseEntity.ok(savedData);
    }
}