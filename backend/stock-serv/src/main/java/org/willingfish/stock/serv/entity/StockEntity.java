package org.willingfish.stock.serv.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class StockEntity extends BaseEntity{
    @Id
    String code;
    String name;
}
