package com.rsdesenvolvimento.accounts.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Accounts extends EntidadeBase {
  @Column(name = "customer_id")
  private Long customerId;
  @Id
  @Column(name = "account_number")
  private Long accountNumber;
  @Column(name = "account_type")
  private String accountType;
  @Column(name = "branch_address")
  private String branchAddress;
}
