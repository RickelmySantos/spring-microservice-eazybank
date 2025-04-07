package com.rsdesenvolvimento.cards.core.audit;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditoriaImpl")
public class Auditoria implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("CARDS_MS");
  }
}
