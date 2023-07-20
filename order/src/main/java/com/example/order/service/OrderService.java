package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.entity.Order;
import com.example.order.excep.NotFoundException;
import com.example.order.repo.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate; // Used for communication with other services

	@Autowired
	public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
	}

	public Order placeOrder(Long userId, Long productId, int quantity) {
		// Fetch user and product information from User Service and Product Service
		User user = fetchUser(userId);
		Product product = fetchProduct(productId);

		// Perform order processing logic
		// ...

		// Update product quantity and save the order
		product.setQuantity(product.getQuantity() - quantity);
		orderRepository.save(order);

		return order;
	}

	private User fetchUser(Long userId) {
		ResponseEntity<User> response = restTemplate.getForEntity("http://user-service/users/" + userId, User.class);
		if (response.getStatusCode() == HttpStatusCode.OK) {
			return response.getBody();
		} else {
			throw new NotFoundException("User not found with ID: " + userId);
		}
	}

	private Product fetchProduct(Long productId) {
		ResponseEntity<Product> response = restTemplate.getForEntity("http://product-service/products/" + productId,
				Product.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new NotFoundException("Product not found with ID: " + productId);
		}
	}

	// Other methods as needed
}
