package com.rsdesenvolvimento.accounts.services.client;

import com.rsdesenvolvimento.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsFeignClient {

  @GetMapping(value = "/api/fetch", consumes = "application/json")
  public ResponseEntity<CardsDto> fetchCardsDetails(@RequestParam String mobileNumber);
}
