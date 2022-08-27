package com.github.microservices.mscartoes.application;

import com.github.microservices.mscartoes.domain.Cartao;
import com.github.microservices.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;

    @Transactional
    public Cartao save(Cartao cartao){
        return repository.save(cartao);
    }

    @Transactional
    public List<Cartao>getCartoesRendaMenorIgual(Long renda){
        var rendaToBigDecimal = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(rendaToBigDecimal);
    }

}
