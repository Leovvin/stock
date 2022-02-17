package org.willingfish.stock.serv.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.willingfish.stock.serv.entity.StockEntity
import org.willingfish.stock.serv.repository.StockRepository
import org.willingfish.stock.serv.service.StockService

@Service
class StockServiceImpl: StockService {
    @Autowired
    lateinit var stockRepository: StockRepository


    override fun getAll(): List<StockEntity> {

        return stockRepository.findAll()
    }
}