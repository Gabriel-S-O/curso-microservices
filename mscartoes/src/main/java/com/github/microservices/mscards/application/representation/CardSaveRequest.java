package com.github.microservices.mscards.application.representation;

import com.github.microservices.mscards.domain.CardFlag;
import com.github.microservices.mscards.domain.Card;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private CardFlag cardFlag;
    private BigDecimal rent;
    private BigDecimal limit;

    public Card toModel(){
        return new Card(name, cardFlag, rent, limit);
    }
}
