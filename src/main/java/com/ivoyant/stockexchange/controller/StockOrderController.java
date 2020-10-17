package com.ivoyant.stockexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivoyant.stockexchange.model.StockOrder;
import com.ivoyant.stockexchange.service.StockService;

@RestController
@RequestMapping("/order")
public class StockOrderController {

	@Autowired
	private StockService stockService;
	
	@GetMapping
	public Iterable<StockOrder> getAllOrders(){
		return stockService.getAllStockOrders();
	}
	
	@GetMapping("{id}")
	public StockOrder getStockOrder(@PathVariable Long id) {
		return stockService.getStockOrderById(id);
	}
	
	@PostMapping
	public StockOrder addStockOrder(@RequestBody StockOrder order) {
		return stockService.addStockOrder(order);
	}
	
	@PutMapping("{id}")
	public StockOrder updateStockOrder(@PathVariable Long id, @RequestBody StockOrder order) {
		return stockService.updateStockOrder(id, order);
	}
	
	@DeleteMapping("{id}")
	public String deleteStockOrder(@PathVariable Long id) {
		return stockService.deleteStockOrderById(id);
	}
}
