package com.rsdesenvolvimento.accounts.services;

import com.rsdesenvolvimento.accounts.dto.CustomerDto;

public interface AccountsService {
  void createAccount(CustomerDto customerDto);

  CustomerDto getAccountByMobileNumber(String mobileNumber);
}
