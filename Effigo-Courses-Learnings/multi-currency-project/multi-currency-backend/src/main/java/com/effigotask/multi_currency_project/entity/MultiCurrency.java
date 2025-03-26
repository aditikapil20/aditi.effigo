package com.effigotask.multi_currency_project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "multi_currency", schema = "masters")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MultiCurrency {

    @Id
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

    @Column(name = "status")
    @JsonProperty("status")
    private Integer status;

    @Column(name = "created_by", length = 50)
    @JsonProperty("created_by")
    private String createdBy;
}