package org.willingfish.stock.serv.service

import org.springframework.stereotype.Service
import org.willingfish.stock.common.pojo.Stock
import reactor.core.publisher.Flux

@Service
interface StockService {

    fun getAll(): Flux<Stock>
}