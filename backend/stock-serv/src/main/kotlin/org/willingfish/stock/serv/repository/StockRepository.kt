package org.willingfish.stock.serv.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.willingfish.stock.serv.entity.StockEntity

interface StockRepository: JpaRepository<StockEntity,String>{
}