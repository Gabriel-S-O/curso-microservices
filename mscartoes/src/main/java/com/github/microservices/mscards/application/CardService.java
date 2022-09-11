package com.github.microservices.mscards.application;

import com.github.microservices.mscards.domain.Card;
import com.github.microservices.mscards.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public Card save(Card card){
        return repository.save(card);
    }

    @Transactional
    public List<Card>getCardsRentLessEqual(Long rent){
        var rentToBigDecimal = BigDecimal.valueOf(rent);
        return repository.findByRentLessThanEqual(rentToBigDecimal);
    }

}
