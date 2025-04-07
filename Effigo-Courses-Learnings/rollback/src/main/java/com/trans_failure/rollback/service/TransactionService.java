package com.trans_failure.rollback.service;

import com.trans_failure.rollback.entity.Audit;
import com.trans_failure.rollback.entity.MultiCurrency;
import com.trans_failure.rollback.repository.AuditRepository;
import com.trans_failure.rollback.repository.MultiCurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    private final MultiCurrencyRepository multiCurrencyRepository;
    private final AuditRepository auditRepository;

    public TransactionService(MultiCurrencyRepository multiCurrencyRepository, AuditRepository auditRepository) {
        this.multiCurrencyRepository = multiCurrencyRepository;
        this.auditRepository = auditRepository;
    }



    @Transactional
    public void performTransaction(MultiCurrency multiCurrency) {
        String status;

        try {
            if (multiCurrency.getClientId() != null) {
                MultiCurrency multiCurrency1 = new MultiCurrency();
                multiCurrency1.setMultiCurrencyId(multiCurrency.getMultiCurrencyId());
                multiCurrency1.setFromCurrencyId(multiCurrency.getFromCurrencyId());
                multiCurrency1.setToCurrencyId(multiCurrency.getToCurrencyId());
                multiCurrency1.setConversionRate(multiCurrency.getConversionRate());
                multiCurrency1.setFromDate(multiCurrency.getFromDate());
                multiCurrency1.setToDate(multiCurrency.getToDate());
                multiCurrency1.setCreatedDate(multiCurrency.getCreatedDate());
                multiCurrency1.setClientId(multiCurrency.getClientId());
                multiCurrency1.setCreatedBy(multiCurrency.getCreatedBy());
                multiCurrencyRepository.save(multiCurrency1);
            }

            else {
                throw new RuntimeException("Transaction Failed, client id is null");
            }
            status="SUCCESS";

        } catch (Exception e) {

            status="FAILED";
        }

        Audit audit = new Audit();
        audit.setMultiCurrencyId(multiCurrency.getMultiCurrencyId());
        audit.setFromCurrencyId(multiCurrency.getFromCurrencyId());
        audit.setToCurrencyId(multiCurrency.getToCurrencyId());
        audit.setConversionRate(multiCurrency.getConversionRate());
        audit.setFromDate(multiCurrency.getFromDate());
        audit.setToDate(multiCurrency.getToDate());
        audit.setCreatedDate(multiCurrency.getCreatedDate());
        audit.setClientId(multiCurrency.getClientId());
        audit.setCreatedBy(multiCurrency.getCreatedBy());
        audit.setStatus(status);

        auditRepository.save(audit);
    }

}



