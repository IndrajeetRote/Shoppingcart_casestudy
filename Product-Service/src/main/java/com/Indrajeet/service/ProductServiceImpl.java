package com.Indrajeet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Indrajeet.models.Product;
import com.Indrajeet.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		
		return this.productRepository.findAll();
	}

	@Override
	public List<Product> findByCategory(String category){
		return this.productRepository.findByCategory(category);
	}
}
