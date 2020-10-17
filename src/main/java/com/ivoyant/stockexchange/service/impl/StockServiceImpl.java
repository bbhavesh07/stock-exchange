package com.ivoyant.stockexchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivoyant.stockexchange.exception.OrderNotFoundException;
import com.ivoyant.stockexchange.model.StockOrder;
import com.ivoyant.stockexchange.repository.StockOrderRepository;
import com.ivoyant.stockexchange.service.StockService;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockOrderRepository stockOrderRepo;
	@Override
	public StockOrder addStockOrder(StockOrder stockOrder) {
		return stockOrderRepo.save(stockOrder);
	}

	@Override
	public Iterable<StockOrder> getAllStockOrders() {
		return stockOrderRepo.findAll();
	}

	@Override
	public StockOrder getStockOrderById(Long id) {
		return stockOrderRepo.findById(id).orElseThrow(OrderNotFoundException::new);
	}

	@Override
	public StockOrder updateStockOrder(Long id, StockOrder order) {

		StockOrder orderToUpdate = stockOrderRepo.findById(id).orElseThrow(OrderNotFoundException::new);
		orderToUpdate.setStockName(order.getStockName());
		orderToUpdate.setOrderType(order.getOrderType());
		orderToUpdate.setPrice(order.getPrice());
		orderToUpdate.setQuantity(order.getQuantity());
		orderToUpdate.setTime(order.getTime());
		return stockOrderRepo.save(orderToUpdate);
	}

	@Override
	public String deleteStockOrderById(Long id) {
		stockOrderRepo.delete(stockOrderRepo.findById(id).orElseThrow(OrderNotFoundException::new));
		return "{meassage: Order deleted successfully!}";	}

}
