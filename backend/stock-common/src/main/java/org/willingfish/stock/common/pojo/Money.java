package org.willingfish.stock.common.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Money {
    Long coefficient;
    Integer exponent;
}
