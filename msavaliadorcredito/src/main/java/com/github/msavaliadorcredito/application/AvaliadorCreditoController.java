package com.github.msavaliadorcredito.application;

import com.github.msavaliadorcredito.application.exceptions.ClientDataNotFoundException;
import com.github.msavaliadorcredito.application.exceptions.MicrosservicesCommuncationErrorException;
import com.github.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliacoes-credito")
@RequiredArgsConstructor
@Slf4j
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status(){
        log.info("----------Obtaining credit-evaluation microsservice status!----------");
        return "Credit Evaluation, Ok!";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf){
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (ClientDataNotFoundException exception) {
            return ResponseEntity.notFound().build();
        } catch (MicrosservicesCommuncationErrorException exception) {
            return ResponseEntity.status(HttpStatus.resolve(exception.getStatus())).body(exception.getMessage());
        }
    }
}
