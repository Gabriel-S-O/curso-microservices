package com.github.microservices.mscards.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column
    private BigDecimal limit;
}
