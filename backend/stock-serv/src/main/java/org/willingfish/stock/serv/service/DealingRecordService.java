package org.willingfish.stock.serv.service;

import org.willingfish.stock.serv.pojo.DealingRecord;

import java.util.List;

public interface DealingRecordService {

    List<DealingRecord> findAllDealingRecord();
}
