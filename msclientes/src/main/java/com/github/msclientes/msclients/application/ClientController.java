package com.github.msclientes.msclients.application;

import com.github.msclientes.msclients.application.representation.ClientSaveRequest;
import com.github.msclientes.msclients.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j // log4j
public class ClientController {

    private final ClientService service;

    @GetMapping
    public String status(){
        log.info("----------Obtaining client microsservice status!----------");
        return "Client, Ok!";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request){
        Client client = request.toModel();
        service.save(client);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getClientData(@RequestParam("cpf") String cpf){
        Optional<Client> client = service.getByCpf(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}
