package org.willingfish.stock.serv.service.impl

import io.r2dbc.spi.Row
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Service
import org.willingfish.stock.common.pojo.Stock
import org.willingfish.stock.serv.service.StockService
import reactor.core.publisher.Flux

@Service
class StockServiceImpl: StockService {

    @Autowired
    lateinit var r2dbcTemplate:R2dbcEntityTemplate

    override fun getAll(): Flux<Stock> {
        return r2dbcTemplate.databaseClient.sql("select * from stock").map(mapper()).all()
    }

    fun mapper(): (Row)-> Stock {
        return {r-> Stock(
                r.get("STOCK_CODE").toString(),
                r.get("NAME").toString()) }
    }

}

