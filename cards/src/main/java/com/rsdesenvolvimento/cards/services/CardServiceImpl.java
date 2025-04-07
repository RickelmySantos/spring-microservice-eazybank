package com.rsdesenvolvimento.cards.services;

import com.rsdesenvolvimento.cards.core.constants.CardsConstants;
import com.rsdesenvolvimento.cards.core.exceptions.CardReadyExistsException;
import com.rsdesenvolvimento.cards.core.exceptions.ResourceNotFoundException;
import com.rsdesenvolvimento.cards.modelo.dtos.CardsDto;
import com.rsdesenvolvimento.cards.modelo.entidades.Cards;
import com.rsdesenvolvimento.cards.modelo.mappers.CardsMapper;
import com.rsdesenvolvimento.cards.repositorios.CardsRepository;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

  private final CardsRepository repository;
  private final CardsMapper mapper;


  /**
   * @param repository
   * @param mapper
   */
  public CardServiceImpl(CardsRepository repository, CardsMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public void createCard(String mobileNumber) {

    Optional<Cards> optionalCard = this.repository.findByMobileNumber(mobileNumber);
    if (optionalCard.isPresent()) {
      throw new CardReadyExistsException(
          "Card already registration with given mobileNumber" + mobileNumber);
    }
    this.repository.save(this.createNewCards(mobileNumber));

  }

  @Override
  public CardsDto fetchCard(String mobileNumber) {
    Cards cards = this.repository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Card not found with given mobileNumber" + mobileNumber));
    return this.mapper.paraDto(cards);
  }

  private Cards createNewCards(String mobileNumber) {
    Cards cards = new Cards();
    long randomNumberCard = 100000000000L + new Random().nextInt(900000000);

    cards.setCardNumber(Long.toString(randomNumberCard));
    cards.setMobileNumber(mobileNumber);
    cards.setCardType(CardsConstants.CREDIT_CARD);
    cards.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
    cards.setAmountUsed(0);
    cards.setAmountUsed(CardsConstants.NEW_CARD_LIMIT);

    return cards;
  }


  @Override
  public boolean updateCards(CardsDto cardsDto) {
    Cards cards = this.repository.findByCardNumber(cardsDto.getCardNumber())
        .orElseThrow(() -> new ResourceNotFoundException(
            "Card not found with given cardNumber" + cardsDto.getCardNumber()));
    this.mapper.mapToCards(cardsDto, cards);
    this.repository.save(cards);
    return true;
  }


  @Override
  public boolean deleteCard(String mobileNumber) {
    Cards cards = this.repository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Card not found with given mobileNumber" + mobileNumber));
    this.repository.deleteById(cards.getCardId());
    return true;
  }


}
