package org.willingfish.stock.serv.service

import org.springframework.stereotype.Service
import org.willingfish.stock.serv.pojo.DealingRecord
import reactor.core.publisher.Flux

@Service
interface DealingService {

    fun findAllDealingRecord():Flux<DealingRecord>
}