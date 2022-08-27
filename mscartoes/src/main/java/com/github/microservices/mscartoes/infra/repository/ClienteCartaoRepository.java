package com.github.microservices.mscartoes.infra.repository;

import com.github.microservices.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
    
    public List<ClienteCartao> findByCpf(String cpf);
}
