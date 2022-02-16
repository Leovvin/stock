package org.willingfish.stock.serv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.willingfish.stock.serv.pojo.DealingRecord;

import java.util.List;


public interface DealingController {

    @GetMapping("/dealings")
    List<DealingRecord> get();
}
