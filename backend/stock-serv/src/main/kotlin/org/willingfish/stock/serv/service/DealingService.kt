package org.willingfish.stock.serv.service

import org.springframework.stereotype.Service
import org.willingfish.stock.serv.pojo.DealingRecord

@Service
interface DealingService {

    fun findAllDealingRecord():List<DealingRecord>
}