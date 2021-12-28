package com.Indrajeet.service;

import java.util.List;

import com.Indrajeet.models.Cart;
public interface CartService {

	public List<Cart> findAll();
	public List<Cart> findByUsername(String username);
}
