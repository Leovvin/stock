package org.willingfish.stock.serv.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.coRouter
import org.springframework.web.reactive.function.server.router
import org.willingfish.stock.serv.controller.StockHandler


@Configuration
class WebConfig:WebFluxConfigurer {

    @Bean
    fun routerFunctionA(stockHandler: StockHandler)= coRouter {
       GET("stock",stockHandler::listPeople)
    }

}