package org.willingfish.stock.serv.controller.impl

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.willingfish.stock.common.pojo.Stock
import org.willingfish.stock.serv.controller.HelloController
import org.willingfish.stock.serv.pojo.DealingRecord
import org.willingfish.stock.serv.service.DealingService
import org.willingfish.stock.serv.service.StockService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class HelloControllerImpl: HelloController {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)
    @Autowired
    lateinit var dealingService: DealingService
    @Autowired
    lateinit var stockService: StockService

    override fun hello(): Mono<String> {
        log.info("visit hello")
        return  Mono.just("hello")
    }

    override fun dealings(): Flux<DealingRecord> {
        return dealingService.findAllDealingRecord()
    }

    override fun stock(): Flux<Stock> {
        return stockService.getAll()
    }
}