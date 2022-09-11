package com.github.microservices.mscards.infra.repository;

import com.github.microservices.mscards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    
    public List<ClientCard> findByCpf(String cpf);
}
