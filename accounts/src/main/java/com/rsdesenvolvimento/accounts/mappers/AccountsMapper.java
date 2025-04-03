package com.rsdesenvolvimento.accounts.mappers;

import com.rsdesenvolvimento.accounts.dto.AccountsDto;
import com.rsdesenvolvimento.accounts.entidades.Accounts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountsMapper {

  AccountsDto paraDto(Accounts accounts);

  Accounts paraEntidade(AccountsDto accountsDto);
}
