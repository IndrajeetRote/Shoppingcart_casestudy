package com.Indrajeet.order.service;

import java.util.List;

import com.Indrajeet.order.models.Order;
public interface OrderService {

	public List<Order> findAll();
	public List<Order> findByUsername(String username);
}

