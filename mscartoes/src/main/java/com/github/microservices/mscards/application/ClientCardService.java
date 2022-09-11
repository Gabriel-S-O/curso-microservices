package com.github.microservices.mscards.application;

import com.github.microservices.mscards.domain.ClientCard;
import com.github.microservices.mscards.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository repository;

    @Transactional
    public ClientCard save(ClientCard clientCard){
        return repository.save(clientCard);
    }

    @Transactional
    public List<ClientCard> getCardsByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
