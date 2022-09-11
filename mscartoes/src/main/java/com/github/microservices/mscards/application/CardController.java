package com.github.microservices.mscards.application;

import com.github.microservices.mscards.application.representation.CardSaveRequest;
import com.github.microservices.mscards.application.representation.CardsByClientResponse;
import com.github.microservices.mscards.domain.Card;
import com.github.microservices.mscards.domain.ClientCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status(){
        log.info("----------Obtaining card microsservice status!----------");
        return "Card, Ok!";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CardSaveRequest request){
        Card card = request.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "rent")
    public ResponseEntity getCardsByRent(@RequestParam("rent") Long rent){
        List<Card> cards = cardService.getCardsRentLessEqual(rent);
        if(cards.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponse>> getCardsByCpf(@RequestParam("cpf") String cpf){
        List<ClientCard> cards = clientCardService.getCardsByCpf(cpf);
        List<CardsByClientResponse> resultList = cards.stream()
                .map(CardsByClientResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
