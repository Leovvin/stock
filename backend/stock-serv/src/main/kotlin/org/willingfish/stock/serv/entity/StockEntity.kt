package org.willingfish.stock.serv.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "STOCK")
data class StockEntity(
        @Id @Column(name="STOCK_CODE")val code:String?,
        val name:String?,
        val createTime:Date?,
        val updateTime:Date?
){
    constructor():this(null,null,null,null)
}
