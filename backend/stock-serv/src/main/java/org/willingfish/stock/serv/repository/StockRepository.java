package org.willingfish.stock.serv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.willingfish.stock.serv.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,String> {
}
