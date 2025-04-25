package com.rsdesenvolvimento.accounts.controladores;

import com.rsdesenvolvimento.accounts.constants.AccountsConstants;
import com.rsdesenvolvimento.accounts.dto.AccountsContactInfoDto;
import com.rsdesenvolvimento.accounts.dto.CustomerDto;
import com.rsdesenvolvimento.accounts.dto.ResponseDto;
import com.rsdesenvolvimento.accounts.services.AccountServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {

  private final AccountServiceImpl accountService;
  private final AccountsContactInfoDto accountsContactInfoDto;

  @Value("${build.version}")
  private String buildVersion;

  @PostConstruct
  public void init() {
    System.out.println("AccountsController iniciado com configs: " + this.accountsContactInfoDto);
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

  @PutMapping("/update")
  public ResponseEntity<ResponseDto> updateAccountClient(@RequestBody CustomerDto customerDto) {
    boolean isUpdated = this.accountService.updateAccount(customerDto);
    if (isUpdated) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> deleteAccountClient(@RequestParam String mobileNumber) {
    this.accountService.deleteAccount(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
  }

  @GetMapping("/build-info")
  public ResponseEntity<String> buscarInformacaoes() {
    return ResponseEntity.status(HttpStatus.OK).body(this.buildVersion);
  }

  @GetMapping("/contact-info")
  public ResponseEntity<AccountsContactInfoDto> contactInfo() {
    return ResponseEntity.status(HttpStatus.OK).body(this.accountsContactInfoDto);
  }
}
