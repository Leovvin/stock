package org.willingfish.stock.serv.pojo

import com.fasterxml.jackson.annotation.JsonFormat
import org.willingfish.stock.common.pojo.Money
import org.willingfish.stock.common.pojo.Stock
import java.time.LocalDate

data class DealingRecord(
        val id: Long?,
        val stock: Stock?=null,
        val incomePrice:Money?=null,
        val outcomePrice:Money?=null,
        @JsonFormat(pattern = "yyyy/MM/dd") val incomeTime:LocalDate?=null,
        @JsonFormat(pattern = "yyyy/MM/dd") val outcomeTime:LocalDate?=null
        )
