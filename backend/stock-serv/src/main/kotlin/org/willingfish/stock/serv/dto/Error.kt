package org.willingfish.stock.serv.dto

data class Error(val traceId: String?,val details: List<ErrorDetail>)