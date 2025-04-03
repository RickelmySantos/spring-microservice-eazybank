package com.rsdesenvolvimento.accounts.repositorios;

import com.rsdesenvolvimento.accounts.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
