package com.rsdesenvolvimento.accounts.services;

import com.rsdesenvolvimento.accounts.constants.AccountsConstants;
import com.rsdesenvolvimento.accounts.dto.AccountsDto;
import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.entidades.Accounts;
import com.rsdesenvolvimento.accounts.entidades.Customer;
import com.rsdesenvolvimento.accounts.exception.CustomerAlreadyExistsException;
import com.rsdesenvolvimento.accounts.exception.ResourceNotFoundException;
import com.rsdesenvolvimento.accounts.mappers.AccountsMapper;
import com.rsdesenvolvimento.accounts.mappers.CustomerMapper;
import com.rsdesenvolvimento.accounts.repositorios.AccountsRepository;
import com.rsdesenvolvimento.accounts.repositorios.CustomerRepository;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountsService {

  private final AccountsRepository accountsRepository;
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;
  private final AccountsMapper accountsMapper;

  public AccountServiceImpl(AccountsRepository accountsRepository,
      CustomerRepository customerRepository, CustomerMapper customerMapper,
      AccountsMapper accountsMapper) {
    this.accountsRepository = accountsRepository;
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
    this.accountsMapper = accountsMapper;
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
    Customer savedCustomer = this.customerRepository.save(customer);
    this.accountsRepository.save(this.createAccount(savedCustomer));
  }

  @Override
  public CustomerDto getAccountByMobileNumber(String mobileNumber) {

    Customer customer = this.customerRepository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Customer not found with this mobile number" + mobileNumber));
    Accounts account = this.accountsRepository.findByCustomerId(customer.getCustomerId())
        .orElseThrow(() -> new ResourceNotFoundException(
            "Account not found with this customer id" + customer.getCustomerId()));
    CustomerDto customerDto = this.customerMapper.paraDto(customer);
    customerDto.setAccountsDto(this.accountsMapper.paraDto(account));
    // System.out.println("Account Number: " + account.getAccountNumber());
    return customerDto;

  }

  @Override
  public boolean updateAccount(CustomerDto customerDto) {
    boolean isUpdated = false;

    Customer existingCustomer =
        this.customerRepository.findByMobileNumber(customerDto.getMobileNumber())
            .orElseThrow(() -> new ResourceNotFoundException(
                "Customer not found with this mobile number: " + customerDto.getMobileNumber()));
    this.customerMapper.atualizarEntidade(customerDto, existingCustomer);
    this.customerRepository.save(existingCustomer);

    AccountsDto accountsDto = customerDto.getAccountsDto();
    if (accountsDto != null) {
      Accounts existingAccounts = this.accountsRepository.findById(accountsDto.getAccountNumber())
          .orElseThrow(() -> new ResourceNotFoundException(
              "Account not found with this account number" + accountsDto.getAccountNumber()));
      existingAccounts.setAccountType(accountsDto.getAccountType());
      existingAccounts.setBranchAddress(accountsDto.getBranchAddress());

      this.accountsRepository.save(existingAccounts);
      isUpdated = true;
    }
    return isUpdated;

  }

  @Override
  public void deleteAccount(String mobileNumber) {
    Customer customer = this.customerRepository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Customer not found with this mobile number: " + mobileNumber));
    this.accountsRepository.deleteByCustomerId(customer.getCustomerId());
    this.customerRepository.deleteById(customer.getCustomerId());
  }



  private Accounts createAccount(Customer customer) {
    Accounts account = new Accounts();
    account.setCustomerId(customer.getCustomerId());
    long randomNumber = 1000000000L + new Random().nextInt(900000000);
    account.setAccountNumber(randomNumber);
    account.setAccountType(AccountsConstants.SAVINGS);
    account.setBranchAddress(AccountsConstants.ADDRESS);

    return account;
  }



}
