package com.example.product.servicess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.excep.NotFoundException;
import com.example.product.repo.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Long productId) throws Exception {
		return productRepository.findById(productId)
				.orElseThrow(() -> new NotFoundException("Product not found with ID: " + productId));
	}

}
