package com.rsdesenvolvimento.accounts.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends EntidadeBase {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @Column(name = "customer_id")
  private Long customerId;
  private String name;
  private String email;
  @Column(name = "mobile_number")
  private String mobileNumber;
}
