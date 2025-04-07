package com.rsdesenvolvimento.cards.services;

import com.rsdesenvolvimento.cards.modelo.dtos.CardsDto;

public interface CardService {

  void createCard(String mobileNumber);

  boolean updateCards(CardsDto cardsDto);

  CardsDto fetchCard(String mobileNumber);

  boolean deleteCard(String mobileNumber);
}
