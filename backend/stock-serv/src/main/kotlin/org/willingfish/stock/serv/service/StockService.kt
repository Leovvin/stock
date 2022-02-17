package org.willingfish.stock.serv.service

import org.springframework.stereotype.Service
import org.willingfish.stock.serv.entity.StockEntity

@Service
interface StockService {

    fun getAll(): List<StockEntity>
}