package com.rsdesenvolvimento.cards.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardReadyExistsException extends RuntimeException {

  public CardReadyExistsException(String message) {
    super(message);
  }

}
