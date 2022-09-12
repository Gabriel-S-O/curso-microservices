package com.github.mscreditevaluation.infra.clients;

import com.github.mscreditevaluation.domain.model.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> getCardsByCpf(@RequestParam("cpf") String cpf);
}
