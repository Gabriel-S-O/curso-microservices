package com.github.mscreditevaluation.application;

import com.github.mscreditevaluation.application.exceptions.ClientDataNotFoundException;
import com.github.mscreditevaluation.application.exceptions.MicrosservicesCommuncationErrorException;
import com.github.mscreditevaluation.domain.model.ClientSituation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-evaluations")
@RequiredArgsConstructor
@Slf4j
public class CreditEvaluationController {

    private final CreditEvaluationService creditEvaluationService;

    @GetMapping
    public String status(){
        log.info("----------Obtaining credit-evaluation microsservice status!----------");
        return "Credit Evaluation, Ok!";
    }

    @GetMapping(value = "client-situation", params = "cpf")
    public ResponseEntity getClientSituation(@RequestParam("cpf") String cpf){
        try {
            ClientSituation clientSituation = creditEvaluationService.getClientSituation(cpf);
            return ResponseEntity.ok(clientSituation);
        } catch (ClientDataNotFoundException exception) {
            return ResponseEntity.notFound().build();
        } catch (MicrosservicesCommuncationErrorException exception) {
            return ResponseEntity.status(HttpStatus.resolve(exception.getStatus())).body(exception.getMessage());
        }
    }
}
