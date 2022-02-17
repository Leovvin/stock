package org.willingfish.stock.serv.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.willingfish.stock.serv.controller.HelloController
import org.willingfish.stock.serv.entity.StockEntity
import org.willingfish.stock.serv.pojo.DealingRecord
import org.willingfish.stock.serv.service.DealingService
import org.willingfish.stock.serv.service.StockService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

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
        return Mono.just(dealingService.findAllDealingRecord()).flatMapIterable { l->l.asIterable() }
    }

    override fun stock(): List<StockEntity> {
        return stockService.getAll()
    }
}