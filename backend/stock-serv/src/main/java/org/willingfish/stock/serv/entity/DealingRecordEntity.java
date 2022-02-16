package org.willingfish.stock.serv.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "DEALING_RECORD")
@Data
public class DealingRecordEntity extends BaseEntity {
    @Id @Column(name = "DEALING_RECORD_ID")
    Long id;
    String stockCode;
    String incomePrice;
    String outcomePrice;
    LocalDate incomeTime;
}
