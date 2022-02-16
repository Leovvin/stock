package org.willingfish.stock.serv.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.willingfish.stock.serv.controller.DealingController;
import org.willingfish.stock.serv.pojo.DealingRecord;
import org.willingfish.stock.serv.service.DealingRecordService;

import java.util.List;

@RestController
public class DealingControllerImpl implements DealingController {
    @Autowired
    DealingRecordService dealingRecordService;
    @Override
    public List<DealingRecord> get() {

        return dealingRecordService.findAllDealingRecord();
    }
}
