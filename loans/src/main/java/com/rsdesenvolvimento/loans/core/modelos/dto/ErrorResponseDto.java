package com.rsdesenvolvimento.loans.core.modelos.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

  private String apiPath;
  private HttpStatus erroCode;
  private String erroMessage;
  private LocalDateTime erroTime;

}
