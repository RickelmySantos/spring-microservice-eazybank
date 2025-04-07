package com.rsdesenvolvimento.cards.modelo.mappers;

import com.rsdesenvolvimento.cards.modelo.dtos.CardsDto;
import com.rsdesenvolvimento.cards.modelo.entidades.Cards;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardsMapper {

  CardsDto paraDto(Cards cards);

  Cards paraEntidade(CardsDto cardsDto);

  Cards mapToCards(CardsDto cardsDto, @MappingTarget Cards cards);
}
