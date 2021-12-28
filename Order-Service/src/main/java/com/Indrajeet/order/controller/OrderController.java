package com.Indrajeet.order.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Indrajeet.order.models.Order;
import com.Indrajeet.order.repository.OrderRepository;
import com.Indrajeet.order.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	private final OrderRepository orderRepository;
	
	public OrderController(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	@Autowired
	public OrderService service;
	
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	@PostMapping("/order/create")
	public String createProduct(@RequestBody Order order) {
		Order insertedOrder = orderRepository.insert(order);
		return "Order Placed By "+ insertedOrder.getUsername();
	}
	
	@DeleteMapping("/delete/{orderId}")
	public void deleteCart(@PathVariable String orderId) {
		 orderRepository.deleteById(orderId);
		
	}
	@GetMapping("/order/{username}")
	public List<Order> getCartByUsername(@PathVariable String username){
		return service.findByUsername(username);
	}

	
	
	
}
