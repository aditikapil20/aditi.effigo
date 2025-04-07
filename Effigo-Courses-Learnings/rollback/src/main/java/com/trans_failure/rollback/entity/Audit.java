package com.trans_failure.rollback.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit")
@Getter
@Setter
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long auditId;

    @Column(name = "multi_currency_id", length = 50)
    @JsonProperty("multi_currency_id")
    private String multiCurrencyId;

    @Column(name = "from_currency_id", length = 50)
    @JsonProperty("from_currency_id")
    private String fromCurrencyId;

    @Column(name = "to_currency_id", length = 50)
    @JsonProperty("to_currency_id")
    private String toCurrencyId;

    @Column(name = "conversion_rate", precision = 26, scale = 6)
    @JsonProperty("conversion_rate")
    private BigDecimal conversionRate;

    @Column(name = "from_date")
    @JsonProperty("from_date")
    private LocalDateTime fromDate;

    @Column(name = "to_date")
    @JsonProperty("to_date")
    private LocalDateTime toDate;

    @Column(name = "created_date")
    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @Column(name = "client_id", length = 50)
    @JsonProperty("client_id")
    private String clientId;

    @Column(name = "status", length = 10)
    @JsonProperty("status")
    private String status; // SUCCESS or FAILED

    @Column(name = "created_by", length = 50)
    @JsonProperty("created_by")
    private String createdBy;
}
