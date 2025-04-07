package com.rsdesenvolvimento.loans.services;

import com.rsdesenvolvimento.loans.core.constants.LoansConstants;
import com.rsdesenvolvimento.loans.core.exceptions.LoanAlreadyExistsException;
import com.rsdesenvolvimento.loans.core.exceptions.ResourceNotFoundException;
import com.rsdesenvolvimento.loans.modelos.dtos.LoansDto;
import com.rsdesenvolvimento.loans.modelos.entidades.Loans;
import com.rsdesenvolvimento.loans.modelos.mappers.LoansMapper;
import com.rsdesenvolvimento.loans.repositorios.LoansRepository;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class LoansService implements LoansServiceInter {

  private final LoansRepository repository;
  private final LoansMapper mapper;

  /**
   * @param repository
   * @param mapper
   */
  public LoansService(LoansRepository repository, LoansMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public void createLoan(String mobileNumber) {

    Optional<Loans> optionalLoans = this.repository.findByMobileNumber(mobileNumber);

    if (optionalLoans.isPresent()) {
      throw new LoanAlreadyExistsException("Loan already exists for this mobile number");
    }
    this.repository.save(this.createNewLoan(mobileNumber));
  }

  private Loans createNewLoan(String mobileNumber) {
    Loans newLoan = new Loans();
    long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
    newLoan.setLoanNumber(Long.toString(randomLoanNumber));
    newLoan.setMobileNumber(mobileNumber);
    newLoan.setLoanType(LoansConstants.HOME_LOAN);
    newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
    newLoan.setAmountPaid(0);
    newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
    return newLoan;
  }

  @Override
  public LoansDto fetchLoandDetails(String mobileNumber) {
    Loans loans = this.repository.findByLoanNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Loan not found" + mobileNumber));

    return this.mapper.paraDto(loans);
  }

  @Override
  public boolean updateLoan(LoansDto loansDto) {
    Loans loans = this.repository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
        () -> new ResourceNotFoundException("Loan not found" + loansDto.getLoanNumber()));

    this.mapper.mapToEntity(loansDto, loans);
    this.repository.save(loans);
    return true;
  }

  @Override
  public boolean delete(String mobileNumber) {
    Loans loans = this.repository.findByLoanNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Loan not found" + mobileNumber));
    this.repository.delete(loans);
    return true;
  }


}
