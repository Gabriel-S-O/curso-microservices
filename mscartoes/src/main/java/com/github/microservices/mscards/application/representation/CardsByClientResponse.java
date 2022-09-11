package com.github.microservices.mscards.application.representation;

import com.github.microservices.mscards.domain.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CardsByClientResponse {

    private String cardName;
    private String flag;
    private BigDecimal limit;


    public static CardsByClientResponse fromModel(ClientCard model){
        return new CardsByClientResponse(
                model.getCard().getName(),
                model.getCard().getCardFlag().toString(),
                model.getCard().getBasicLimit()
        );
    }
}
