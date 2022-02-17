package org.willingfish.stock.serv.entity

import java.time.LocalDate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "DEALING_RECORD")
data class DealingRecordEntity(
        @Id @Column(name="DEALING_RECORD_ID")val id:Long?,
        val stockCode:String?,
        val incomePrice:String,
        val outcomePrice:String,
        val incomeTime:LocalDate,
        val outcomeTime: LocalDate,
        val createTime: Date,
        val updateTime: Date
)