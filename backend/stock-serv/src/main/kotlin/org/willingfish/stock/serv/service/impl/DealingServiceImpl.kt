package org.willingfish.stock.serv.service.impl

import io.r2dbc.spi.Row
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.willingfish.stock.common.pojo.Money
import org.willingfish.stock.common.pojo.Stock
import org.willingfish.stock.serv.pojo.DealingRecord
import org.willingfish.stock.serv.service.DealingService
import reactor.core.publisher.Flux
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.math.pow

@Component
class DealingServiceImpl: DealingService {

    @Autowired
    lateinit var r2dbcTemplate: R2dbcEntityTemplate

    @Transactional
    override fun findAllDealingRecord(): Flux<DealingRecord> {
        return r2dbcTemplate.databaseClient
                .sql("select dr.DEALING_RECORD_ID,dr.STOCK_CODE,s.NAME,dr.INCOME_PRICE,dr.OUTCOME_PRICE,dr.INCOME_TIME,dr.OUTCOME_TIME from dealing_record dr left join stock s on dr.STOCK_CODE = s.STOCK_CODE")
                .map(mapper()).all()
    }

    private fun mapper(): (Row)->DealingRecord{
        return {row->
            DealingRecord(
                    (row.get("DEALING_RECORD_ID") as? Int)?.toLong(),
                    Stock(row.get("STOCK_CODE").toString(),row.get("NAME").toString()),
                    stringToMoney(row.get("INCOME_PRICE")),
                    stringToMoney(row.get("OUTCOME_PRICE")),
                    (row.get("INCOME_TIME") as? LocalDateTime)?.toLocalDate(),
                    (row.get("OUTCOME_TIME") as? LocalDateTime)?.toLocalDate()
            )
        }
    }

    fun stringToMoney(price:Any?): Money? {
        if (price == null){
            return null
        }
        var bigDecimal = BigDecimal(price.toString())
        bigDecimal = bigDecimal.setScale(2);
        val cof:Long = (bigDecimal.toFloat()* 10.0.pow(bigDecimal.scale())).toLong()
        val exp:Int = 0-bigDecimal.scale()
        return Money(cof,exp)
    }


}