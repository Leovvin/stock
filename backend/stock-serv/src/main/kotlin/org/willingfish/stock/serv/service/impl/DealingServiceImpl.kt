package org.willingfish.stock.serv.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.willingfish.stock.common.pojo.Money
import org.willingfish.stock.common.pojo.Stock
import org.willingfish.stock.serv.pojo.DealingRecord
import org.willingfish.stock.serv.service.DealingService
import java.math.BigDecimal
import kotlin.math.pow

@Component
class DealingServiceImpl: DealingService {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    val rowMapper:RowMapper<DealingRecord> = RowMapper{
        rs, rowNum -> DealingRecord(
            rs.getLong(1),
            Stock(rs.getString(2),rs.getString(3)),
            stringToMoney(rs.getString(4)),
            stringToMoney(rs.getString(5)),
            rs.getDate(6)?.toLocalDate(),
            rs.getDate(7)?.toLocalDate()
        )
    }

    @Transactional
    override fun findAllDealingRecord(): List<DealingRecord> {
        return jdbcTemplate.query("select dr.DEALING_RECORD_ID,dr.STOCK_CODE,s.NAME,dr.INCOME_PRICE,dr.OUTCOME_PRICE,dr.INCOME_TIME,dr.OUTCOME_TIME from dealing_record dr left join stock s on dr.STOCK_CODE = s.STOCK_CODE", rowMapper)
    }

    fun stringToMoney(price:String?): Money? {
        if (price == null){
            return null
        }
        var bigDecimal = BigDecimal(price)
        bigDecimal = bigDecimal.setScale(2);
        val cof:Long = (bigDecimal.toFloat()* 10.0.pow(bigDecimal.scale())).toLong()
        val exp:Int = 0-bigDecimal.scale()
        return Money(cof,exp)
    }


}