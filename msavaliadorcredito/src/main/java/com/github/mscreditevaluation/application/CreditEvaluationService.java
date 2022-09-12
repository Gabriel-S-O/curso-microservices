package com.github.mscreditevaluation.application;

import com.github.mscreditevaluation.application.exceptions.ClientDataNotFoundException;
import com.github.mscreditevaluation.application.exceptions.MicrosservicesCommuncationErrorException;
import com.github.mscreditevaluation.domain.model.ClientCard;
import com.github.mscreditevaluation.domain.model.ClientData;
import com.github.mscreditevaluation.domain.model.ClientSituation;
import com.github.mscreditevaluation.infra.clients.CardResourceClient;
import com.github.mscreditevaluation.infra.clients.ClientResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditEvaluationService {

    private final ClientResourceClient clientsResource;
    private final CardResourceClient cardsResource;

    private final int NOT_FOUND = HttpStatus.NOT_FOUND.value();

    public ClientSituation getClientSituation(String cpf) throws ClientDataNotFoundException, MicrosservicesCommuncationErrorException{
        try {
            ResponseEntity<ClientData> clientDataResponse = clientsResource.getClientData(cpf);
            ResponseEntity<List<ClientCard>> clientCardsDataResponse = cardsResource.getCardsByCpf(cpf);

            return ClientSituation
                    .builder()
                    .client(clientDataResponse.getBody())
                    .cards(clientCardsDataResponse.getBody())
                    .build();
        }catch (FeignException.FeignClientException exception){
            int status = exception.status();
            if(status == NOT_FOUND){
                throw new ClientDataNotFoundException();
            }
            throw new MicrosservicesCommuncationErrorException(status, exception.getMessage());
        }
    }
}
