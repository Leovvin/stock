package org.willingfish.stock.serv.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.willingfish.stock.common.pojo.Stock
import org.willingfish.stock.serv.controller.HelloController
import org.willingfish.stock.serv.pojo.DealingRecord
import org.willingfish.stock.serv.service.DealingService
import org.willingfish.stock.serv.service.StockService
import reactor.core.publisher.Flux

@Component
class HelloControllerImpl: HelloController {

    @Autowired
    lateinit var dealingService: DealingService
    @Autowired
    lateinit var stockService: StockService;

    override fun hello():String {
        return "hello" ;
    }

    override fun dealings(): Flux<DealingRecord> {
        return dealingService.findAllDealingRecord()
    }

    override fun stock(): Flux<Stock> {
        return stockService.getAll()
    }
}