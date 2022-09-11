package com.github.microservices.mscards.infra.repository;

import com.github.microservices.mscards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByRentLessThanEqual(BigDecimal rent);
}
