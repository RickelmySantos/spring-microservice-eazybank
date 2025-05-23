package com.rsdesenvolvimento.loans.controladores;

import com.rsdesenvolvimento.loans.core.constants.LoansConstants;
import com.rsdesenvolvimento.loans.core.modelos.dto.ResponseDto;
import com.rsdesenvolvimento.loans.modelos.dtos.LoansDto;
import com.rsdesenvolvimento.loans.services.LoansService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoansController {

  private final LoansService service;

  public LoansController(LoansService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<ResponseDto> createLoans(@Valid @RequestParam String mobileNumber) {
    this.service.createLoan(mobileNumber);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
  }

  @GetMapping
  public ResponseEntity<LoansDto> fetchLoansDetails(@RequestParam String mobileNumber) {
    LoansDto loansDto = this.service.fetchLoandDetails(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(loansDto);
  }

  @PutMapping
  public ResponseEntity<ResponseDto> updateLoansDetails(@Valid @RequestParam LoansDto loansDto) {
    this.service.updateLoan(loansDto);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(LoansConstants.MESSAGE_200, LoansConstants.MESSAGE_200));
  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> delete(@RequestParam String mobileNumber) {
    this.service.delete(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
  }
}
