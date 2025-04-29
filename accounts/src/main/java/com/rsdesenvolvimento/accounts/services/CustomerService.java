package com.rsdesenvolvimento.accounts.services;

import com.rsdesenvolvimento.accounts.dto.CustomerDetailsDto;

public interface CustomerService {

  CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
