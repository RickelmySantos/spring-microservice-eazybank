package com.rsdesenvolvimento.accounts.services;

import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.mappers.AccountsMapper;
import com.rsdesenvolvimento.accounts.repositorios.AccountsRepository;
import com.rsdesenvolvimento.accounts.repositorios.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountsService {

  private final AccountsRepository accountsRepository;
  private final CustomerRepository customerRepository;
  private final AccountsMapper accountMapper;

  public AccountServiceImpl(AccountsRepository accountsRepository,
      CustomerRepository customerRepository, AccountsMapper accountMapper) {
    this.accountsRepository = accountsRepository;
    this.customerRepository = customerRepository;
    this.accountMapper = accountMapper;
  }

  @Override
  public void createAccount(CustomerDto customerDto) {


  }


}
