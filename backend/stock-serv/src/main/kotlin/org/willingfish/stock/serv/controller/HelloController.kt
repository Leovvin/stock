package org.willingfish.stock.serv.controller

import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.willingfish.stock.common.pojo.Stock
import org.willingfish.stock.serv.pojo.DealingRecord
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/hello")
interface HelloController {

    @GetMapping
    fun hello(): Mono<String>

    @GetMapping("/dealings")
    fun dealings():Flux<DealingRecord>

    @GetMapping("/stock")
    fun stock():Flux<Stock>
}