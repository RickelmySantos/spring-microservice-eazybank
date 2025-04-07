package com.rsdesenvolvimento.loans.core.auditoria;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditoria")
public class Auditoria implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("LOANS_MS");
  }
}
