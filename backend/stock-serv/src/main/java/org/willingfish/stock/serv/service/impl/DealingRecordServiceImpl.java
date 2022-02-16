package org.willingfish.stock.serv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.willingfish.stock.common.pojo.Money;
import org.willingfish.stock.common.pojo.Stock;
import org.willingfish.stock.serv.entity.DealingRecordEntity;
import org.willingfish.stock.serv.pojo.DealingRecord;
import org.willingfish.stock.serv.repository.DealingRecordRepository;
import org.willingfish.stock.serv.repository.StockRepository;
import org.willingfish.stock.serv.service.DealingRecordService;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DealingRecordServiceImpl implements DealingRecordService {
    @Autowired
    DealingRecordRepository dealingRecordRepository;
    @Autowired
    StockRepository stockRepository;

    @Override
    @Transactional
    public List<DealingRecord> findAllDealingRecord() {
        List<DealingRecordEntity> recordEntities = dealingRecordRepository.findAll();
        return recordEntities.stream().map(entity2Pojo).collect(Collectors.toList());
    }

    Function<DealingRecordEntity,DealingRecord> entity2Pojo = e->{
            Stock stock = Stock.builder().code(e.getStockCode())
                    .build();
            BigDecimal incomePrice = new BigDecimal(e.getIncomePrice());
            long coefficient = (long) (incomePrice.floatValue()*Math.pow(10,incomePrice.scale()));
            Money incomePriceMoney = Money.builder()
                    .coefficient(coefficient)
                    .exponent(0-incomePrice.scale())
                    .build();

            DealingRecord dealingRecord = DealingRecord.builder()
                    .stock(stock)
                    .incomePrice(incomePriceMoney)
                    .incomeTime(e.getIncomeTime())
                    .build();
            return dealingRecord;
    };

}
