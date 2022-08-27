package com.github.microservices.mscartoes.application.representation;

import com.github.microservices.mscartoes.application.ClienteCartaoService;
import com.github.microservices.mscartoes.domain.BandeiraCartao;
import com.github.microservices.mscartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartoesPorClienteResponse {

    private String nomeDoCartao;
    private String bandeira;
    private BigDecimal limite;


    public static CartoesPorClienteResponse fromModel(ClienteCartao model){
        return new CartoesPorClienteResponse(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getCartao().getLimiteBasico()
        );
    }
}
