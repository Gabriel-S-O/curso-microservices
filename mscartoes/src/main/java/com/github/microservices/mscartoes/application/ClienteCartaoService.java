package com.github.microservices.mscartoes.application;

import com.github.microservices.mscartoes.domain.ClienteCartao;
import com.github.microservices.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    @Transactional
    public ClienteCartao save(ClienteCartao clienteCartao){
        return repository.save(clienteCartao);
    }

    @Transactional
    public List<ClienteCartao> getCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
