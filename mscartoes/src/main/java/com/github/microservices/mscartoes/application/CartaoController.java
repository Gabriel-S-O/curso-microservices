package com.github.microservices.mscartoes.application;

import com.github.microservices.mscartoes.application.representation.CartaoSaveRequest;
import com.github.microservices.mscartoes.domain.Cartao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
@Slf4j
public class CartaoController {

    private final CartaoService service;

    @GetMapping
    public String status(){
        log.info("----------Obtaining card microsservice status!----------");
        return "Card, Ok!";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        service.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
