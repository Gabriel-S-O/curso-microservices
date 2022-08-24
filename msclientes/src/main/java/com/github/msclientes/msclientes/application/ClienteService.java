package com.github.msclientes.msclientes.application;

import com.github.msclientes.msclientes.domain.Cliente;
import com.github.msclientes.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    /**
     * Isso é o que a anotação
     * @RequiredArgsConstructor
     * está fazendo.
     */
//    public ClienteService(ClienteRepository repository){
//        this.repository = repository;
//    }
}
