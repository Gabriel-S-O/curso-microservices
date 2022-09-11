package com.github.microservices.mscards.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;

    @Column
    private BigDecimal rent;

    @Column
    private BigDecimal basicLimit;

    public Card(String name, CardFlag cardFlag, BigDecimal rent, BigDecimal basicLimit) {
        this.name = name;
        this.cardFlag = cardFlag;
        this.rent = rent;
        this.basicLimit = basicLimit;
    }
}
