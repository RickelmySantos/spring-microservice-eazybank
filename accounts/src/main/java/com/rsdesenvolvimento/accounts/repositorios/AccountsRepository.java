package com.rsdesenvolvimento.accounts.repositorios;

import com.rsdesenvolvimento.accounts.entidades.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
