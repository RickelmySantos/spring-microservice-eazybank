package com.rsdesenvolvimento.accounts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

  private String name;
  private String email;
  private String mobileNumber;
  private AccountsDto accountsDto;
}
