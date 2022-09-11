package com.github.msclientes.msclients.application;

import com.github.msclientes.msclients.domain.Client;
import com.github.msclientes.msclients.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public Client save(Client client){
        return repository.save(client);
    }

    public Optional<Client> getByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
