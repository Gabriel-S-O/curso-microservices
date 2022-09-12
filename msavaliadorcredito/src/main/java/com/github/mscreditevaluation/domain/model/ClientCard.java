package com.github.mscreditevaluation.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientCard {

    private String name;
    private String cardFlag;
    private BigDecimal approvedLimit;
}
