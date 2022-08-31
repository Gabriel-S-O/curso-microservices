package com.github.msavaliadorcredito.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliacoes-credito")
@Slf4j
public class AvaliadorCreditoController {

    @GetMapping
    public String status(){
        log.info("----------Obtaining credit-evaluation microsservice status!----------");
        return "Credit Evaluation, Ok!";
    }
}
