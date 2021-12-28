package com.Indrajeet.service;

import java.util.List;
import java.util.Optional;

import com.Indrajeet.models.Product;


public interface ProductService {

	public List<Product> findAll();
	public List<Product> findByCategory(String category);
}
