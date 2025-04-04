package com.rsdesenvolvimento.accounts.services;

import com.rsdesenvolvimento.accounts.constants.AccountsConstants;
import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.entidades.Accounts;
import com.rsdesenvolvimento.accounts.entidades.Customer;
import com.rsdesenvolvimento.accounts.exception.CustomerAlreadyExistsException;
import com.rsdesenvolvimento.accounts.mappers.CustomerMapper;
import com.rsdesenvolvimento.accounts.repositorios.AccountsRepository;
import com.rsdesenvolvimento.accounts.repositorios.CustomerRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountsService {

  private final AccountsRepository accountsRepository;
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public AccountServiceImpl(AccountsRepository accountsRepository,
      CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.accountsRepository = accountsRepository;
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public void createAccount(CustomerDto customerDto) {

    Customer customer = this.customerMapper.paraEntidade(customerDto);

    Optional<Customer> optionalCustomer =
        this.customerRepository.findByMobileNumber(customerDto.getMobileNumber());

    if (optionalCustomer.isPresent()) {
      throw new CustomerAlreadyExistsException(
          "Customer already exists with this mobile number" + customerDto.getMobileNumber());
    }
    customer.setCreatedAt(LocalDateTime.now());
    customer.setCreatedBy("anonymous");

    Customer savedCustomer = this.customerRepository.save(customer);
    this.accountsRepository.save(this.createAccount(savedCustomer));
  }


  private Accounts createAccount(Customer customer) {
    Accounts account = new Accounts();
    account.setCustomerId(customer.getCustomerId());
    long randomNumber = 1000000000L + new Random().nextInt(900000000);
    account.setAccountNumber(randomNumber);
    account.setAccountType(AccountsConstants.SAVINGS);
    account.setBranchAddress(AccountsConstants.ADDRESS);
    account.setCreatedAt(LocalDateTime.now());
    account.setCreatedBy("anonymous");

    return account;
  }

}
