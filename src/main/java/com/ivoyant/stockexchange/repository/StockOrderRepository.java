package com.ivoyant.stockexchange.repository;

import org.springframework.data.repository.CrudRepository;

import com.ivoyant.stockexchange.model.StockOrder;

public interface StockOrderRepository extends CrudRepository<StockOrder, Long>{

}
