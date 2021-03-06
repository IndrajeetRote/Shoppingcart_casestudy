package com.Indrajeet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Indrajeet.models.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product,Integer>{

	public List<Product> findByCategory(String category);

}
