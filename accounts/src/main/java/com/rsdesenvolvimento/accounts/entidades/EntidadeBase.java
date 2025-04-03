package com.rsdesenvolvimento.accounts.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class EntidadeBase {

  @Column(updatable = false)
  private LocalDateTime createdAt;
  @Column(updatable = false)
  private String createdBy;
  @Column(insertable = false)
  private LocalDateTime updateAt;
  @Column(insertable = false)
  private String updateBy;
}
