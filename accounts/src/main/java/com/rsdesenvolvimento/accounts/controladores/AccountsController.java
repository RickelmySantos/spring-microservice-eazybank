package com.rsdesenvolvimento.accounts.controladores;

import com.rsdesenvolvimento.accounts.constants.AccountsConstants;
import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.dto.ResponseDto;
import com.rsdesenvolvimento.accounts.services.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accounts")
public class AccountsController {

  private final AccountServiceImpl accountService;

  public AccountsController(AccountServiceImpl accountService) {
    this.accountService = accountService;
  }


  @PostMapping()
  public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
    this.accountService.createAccount(customerDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
  }

  @GetMapping("/fetch")
  public ResponseEntity<CustomerDto> getAccountClient(@RequestParam String mobileNumber) {
    CustomerDto customerDto = this.accountService.getAccountByMobileNumber(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(customerDto);
  }

}
