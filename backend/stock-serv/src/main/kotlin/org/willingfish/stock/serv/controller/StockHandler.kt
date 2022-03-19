package org.willingfish.stock.serv.controller

import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.willingfish.stock.serv.service.StockService

@Component
class StockHandler(private val stockService:StockService) {
    suspend fun listPeople(request: ServerRequest): ServerResponse {
        val stocks = stockService.getAll();
        return ok().bodyAndAwait(stocks.asFlow())
    }
}