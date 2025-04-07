package com.rsdesenvolvimento.loans.modelos.entidades;

import com.rsdesenvolvimento.loans.core.modelos.EntidadeBase;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loans extends EntidadeBase {

  private Long loanId;

  private String mobileNumber;

  private String loanNumber;

  private String loanType;

  private int totalLoan;

  private int amountPaid;

  private int outstatindgAmount;
}
