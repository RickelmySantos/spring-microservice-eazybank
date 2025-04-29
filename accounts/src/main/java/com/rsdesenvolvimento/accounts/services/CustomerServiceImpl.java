package com.rsdesenvolvimento.accounts.services;

import com.rsdesenvolvimento.accounts.dto.CardsDto;
import com.rsdesenvolvimento.accounts.dto.CustomerDetailsDto;
import com.rsdesenvolvimento.accounts.dto.LoansDto;
import com.rsdesenvolvimento.accounts.entidades.Accounts;
import com.rsdesenvolvimento.accounts.entidades.Customer;
import com.rsdesenvolvimento.accounts.exception.ResourceNotFoundException;
import com.rsdesenvolvimento.accounts.mappers.AccountsMapper;
import com.rsdesenvolvimento.accounts.mappers.CustomerMapper;
import com.rsdesenvolvimento.accounts.repositorios.AccountsRepository;
import com.rsdesenvolvimento.accounts.repositorios.CustomerRepository;
import com.rsdesenvolvimento.accounts.services.client.CardsFeignClient;
import com.rsdesenvolvimento.accounts.services.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private AccountsRepository accountsRepository;
  private CustomerRepository customerRepository;
  private CardsFeignClient cardsFeignClient;
  private LoansFeignClient loansFeignClient;
  private CustomerMapper customerMapper;
  private AccountsMapper accountsMapper;


  @Override
  public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
    Customer customer = this.customerRepository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Customer not found with mobile number: " + mobileNumber));

    Accounts accounts = this.accountsRepository.findByCustomerId(customer.getCustomerId())
        .orElseThrow(() -> new ResourceNotFoundException(
            "Account not found for customer with mobile number: " + mobileNumber));
    CustomerDetailsDto customerDetailsDto =
        this.customerMapper.paraDto(customer, new CustomerDetailsDto());
    customerDetailsDto.setAccountsDto(this.accountsMapper.paraDto(accounts));

    ResponseEntity<LoansDto> loansDtoResponseEntity =
        this.loansFeignClient.fetchLoansDetails(mobileNumber);

    customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

    ResponseEntity<CardsDto> cardsDtoResponseEntity =
        this.cardsFeignClient.fetchCardsDetails(mobileNumber);

    customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

    return customerDetailsDto;

  }


}
