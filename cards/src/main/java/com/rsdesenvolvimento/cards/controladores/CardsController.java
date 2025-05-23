package com.rsdesenvolvimento.cards.controladores;

import com.rsdesenvolvimento.cards.core.constants.CardsConstants;
import com.rsdesenvolvimento.cards.core.modelo.dtos.ResponseDto;
import com.rsdesenvolvimento.cards.modelo.dtos.CardsDto;
import com.rsdesenvolvimento.cards.services.CardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsController {
  private final CardService service;

  /**
   * @param service
   */
  public CardsController(CardService service) {
    this.service = service;
  }


  @PostMapping()
  public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam String mobileNumber) {
    this.service.createCard(mobileNumber);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
  }

  @GetMapping()
  public ResponseEntity<CardsDto> fetchCardsDetails(@RequestParam String mobileNumber) {
    CardsDto cardsDto = this.service.fetchCard(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDto> updateCardsDetails(@Valid @RequestBody CardsDto cardsDto) {
    this.service.updateCards(cardsDto);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(CardsConstants.MESSAGE_200, CardsConstants.MESSAGE_200));
  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> delete(@RequestParam String mobileNumber) {
    this.service.deleteCard(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
  }

}
