package org.willingfish.stock.serv.service.impl

import com.google.common.collect.Lists
import io.r2dbc.spi.Row
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.willingfish.stock.serv.entity.StockEntity
import org.willingfish.stock.serv.repository.StockRepository
import org.willingfish.stock.serv.service.StockService
import java.sql.ResultSet
import java.util.*
import java.util.function.Function
import kotlin.collections.ArrayList

@Service
class StockServiceImpl: StockService {
//    @Autowired
//    lateinit var stockRepository: StockRepository
    @Autowired
    lateinit var r2dbcTemplate:R2dbcEntityTemplate

    override fun getAll(): ArrayList<StockEntity> {
        val entity = r2dbcTemplate.databaseClient.sql("select * from stock").map(mapper()).all().blockFirst();
        return Lists.newArrayList(entity)
    }
    fun code(): (StockEntity,Row)->StockEntity{
        return {e,r->e.copy(r.get("STOCK_CODE").toString())}
    }

    fun mapper(row:Row):  StockEntity {
        val stockEntity = StockEntity();
        code().curried()(stockEntity)
        return stockEntity
    }

    fun <P1,P2,R> Function2<P1,P2,R>.curried()
            =fun (p1: P1) = fun (p2: P2) = this(p1,p2)
}

