package com.github.msavaliadorcredito.application;

import com.github.msavaliadorcredito.application.exceptions.ClientDataNotFoundException;
import com.github.msavaliadorcredito.application.exceptions.MicrosservicesCommuncationErrorException;
import com.github.msavaliadorcredito.domain.model.CartaoCliente;
import com.github.msavaliadorcredito.domain.model.DadosCliente;
import com.github.msavaliadorcredito.domain.model.SituacaoCliente;
import com.github.msavaliadorcredito.infra.clients.CartaoResourceClient;
import com.github.msavaliadorcredito.infra.clients.ClienteResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;
    private final CartaoResourceClient cartoesClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) throws ClientDataNotFoundException, MicrosservicesCommuncationErrorException{
        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> dadosCartoesClienteResponse = cartoesClient.getCartoesByCpf(cpf);

            return SituacaoCliente
                    .builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(dadosCartoesClienteResponse.getBody())
                    .build();
        }catch (FeignException.FeignClientException exception){
            int status = exception.status();
            if(status == HttpStatus.NOT_FOUND.value()){
                throw new ClientDataNotFoundException();
            }
            throw new MicrosservicesCommuncationErrorException(status, exception.getMessage());
        }
    }
}
