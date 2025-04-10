package com.rsdesenvolvimento.loans.core.modelos;

import com.rsdesenvolvimento.loans.core.auditoria.Auditoria;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(Auditoria.class)
public class EntidadeBase {

  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @CreatedBy
  @Column(updatable = false)
  private String createdBy;

  @LastModifiedDate
  @Column(insertable = false)
  private LocalDateTime updateAt;

  @LastModifiedDate
  @Column(insertable = false)
  private String updateBy;
}
