package org.willingfish.stock.serv.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.willingfish.stock.common.pojo.Money;
import org.willingfish.stock.common.pojo.Stock;

import java.time.LocalDate;

@Data
@Builder
public class DealingRecord {

    Stock stock;
    Money incomePrice;
    Money outcomePrice;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate incomeTime;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate outcomeTime;
}
