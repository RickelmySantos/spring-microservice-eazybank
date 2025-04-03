package com.rsdesenvolvimento.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

  private Long accontNumber;
  private String accountType;
  private String branchAddress;
}
