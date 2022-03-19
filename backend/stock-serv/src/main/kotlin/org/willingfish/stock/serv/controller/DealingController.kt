package org.willingfish.stock.serv.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.willingfish.stock.serv.pojo.DealingRecord
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/dealing")
interface DealingController {

    @GetMapping("/dealings")
    fun dealings(): Flux<DealingRecord>
}