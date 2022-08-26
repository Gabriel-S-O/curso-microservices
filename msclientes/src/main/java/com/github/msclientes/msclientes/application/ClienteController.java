package com.github.msclientes.msclientes.application;

import com.github.msclientes.msclientes.application.representation.ClientSaveRequest;
import com.github.msclientes.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@Slf4j // log4j
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public String status(){
        log.info("----------Obtaining client microsservice status!----------");
        return "Client, Ok!";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request){
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        Optional<Cliente> cliente = service.getByCpf(cpf);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
