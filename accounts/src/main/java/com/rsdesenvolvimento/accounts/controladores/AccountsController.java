package com.rsdesenvolvimento.accounts.controladores;

import com.rsdesenvolvimento.accounts.constants.AccountsConstants;
import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {


  @PostMapping()
  public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
  }
}
