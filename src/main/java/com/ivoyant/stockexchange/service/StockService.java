package com.ivoyant.stockexchange.service;

import com.ivoyant.stockexchange.model.StockOrder;

public interface StockService {
	StockOrder addStockOrder(StockOrder StockOrder);
	Iterable<StockOrder> getAllStockOrders();
	StockOrder getStockOrderById(Long id);
	StockOrder updateStockOrder(Long id, StockOrder StockOrder);
	String deleteStockOrderById(Long id);
}
