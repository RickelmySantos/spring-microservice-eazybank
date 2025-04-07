package com.rsdesenvolvimento.loans.services;

import com.rsdesenvolvimento.loans.modelos.dtos.LoansDto;

public interface LoansServiceInter {

  void createLoan(String mobileNumber);

  LoansDto fetchLoandDetails(String mobileNumber);

  boolean updateLoan(LoansDto loansDto);

  boolean delete(String mobileNumber);
}
