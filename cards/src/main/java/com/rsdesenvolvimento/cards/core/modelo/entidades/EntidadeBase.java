package com.rsdesenvolvimento.cards.core.modelo.entidades;

import com.rsdesenvolvimento.cards.core.audit.Auditoria;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@EntityListeners({ Auditoria.class })
@Getter
@Setter
@ToString
public class EntidadeBase {

  @Column(updatable = false)
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(updatable = false)
  @CreatedBy
  private String createBy;

  @Column(insertable = false)
  @LastModifiedDate
  private LocalDateTime updatedAT;

  @LastModifiedBy
  @Column(insertable = false)
  private String updateBy;
}
