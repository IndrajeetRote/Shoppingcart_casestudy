package com.Indrajeet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Indrajeet.models.Cart;
import com.Indrajeet.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> findAll() {
		
		return this.cartRepository.findAll();
	}

	@Override
	public List<Cart> findByUsername(String username){
		return this.cartRepository.findByUsername(username);
	}
}
