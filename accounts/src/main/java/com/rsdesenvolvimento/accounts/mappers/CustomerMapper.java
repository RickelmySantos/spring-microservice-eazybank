package com.rsdesenvolvimento.accounts.mappers;

import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.entidades.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


  CustomerDto paraDto(Customer customer);

  Customer paraEntidade(CustomerDto customerDto);

  void atualizarEntidade(CustomerDto customerDto, @MappingTarget Customer customer);
}
