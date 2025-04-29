package com.rsdesenvolvimento.accounts.controladores;

import com.rsdesenvolvimento.accounts.dto.CustomerDetailsDto;
import com.rsdesenvolvimento.accounts.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/fetchCustomerDetails")
  public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
      @RequestParam String mobileNumber) {

    CustomerDetailsDto customerDetailsDto = this.customerService.fetchCustomerDetails(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
  }

}
