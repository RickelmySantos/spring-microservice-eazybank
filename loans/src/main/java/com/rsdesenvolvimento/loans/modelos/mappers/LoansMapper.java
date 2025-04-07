package com.rsdesenvolvimento.loans.modelos.mappers;

import com.rsdesenvolvimento.loans.modelos.dtos.LoansDto;
import com.rsdesenvolvimento.loans.modelos.entidades.Loans;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoansMapper {

  LoansDto paraDto(Loans loans);

  Loans paraEntidade(LoansDto loansDto);

  Loans mapToEntity(LoansDto loansDto, @MappingTarget Loans loans);
}
