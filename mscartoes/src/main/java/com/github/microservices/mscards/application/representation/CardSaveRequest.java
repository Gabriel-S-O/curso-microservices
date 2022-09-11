package com.github.microservices.mscards.application.representation;

import com.github.microservices.mscards.domain.CardFlag;
import com.github.microservices.mscards.domain.Card;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String nome;
    private CardFlag bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Card toModel(){
        return new Card(nome, bandeira, renda, limite);
    }
}
