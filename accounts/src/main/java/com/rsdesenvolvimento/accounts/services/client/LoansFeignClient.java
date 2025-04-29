package com.rsdesenvolvimento.accounts.services.client;

import com.rsdesenvolvimento.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans")
public interface LoansFeignClient {


  @GetMapping(value = "/api/fetch", consumes = "application/json")
  public ResponseEntity<LoansDto> fetchLoansDetails(@RequestParam String mobileNumber);
}
