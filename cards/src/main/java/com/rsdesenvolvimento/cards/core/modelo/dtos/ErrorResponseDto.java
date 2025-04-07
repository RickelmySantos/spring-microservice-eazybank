package com.rsdesenvolvimento.cards.core.modelo.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

  private String apiPath;
  private HttpStatus erroCode;
  private String erroMessage;
  private LocalDateTime erroTime;
}
