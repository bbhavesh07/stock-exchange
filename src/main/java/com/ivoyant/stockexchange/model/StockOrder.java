package com.ivoyant.stockexchange.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StockOrder {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	private String stockName;

	@Enumerated(EnumType.STRING)
	private OrderType orderType;
	private int quantity;
	private double price;
	private Timestamp time;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String name) {
		this.stockName = name;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType type) {
		this.orderType = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
