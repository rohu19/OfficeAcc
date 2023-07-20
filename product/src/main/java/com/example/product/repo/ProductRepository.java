package com.example.product.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
