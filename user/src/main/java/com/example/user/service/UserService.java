package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.excepti.NotFoundException;
import com.example.user.repo.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long userId) throws Exception {
		return userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
	}

	// Other methods as needed
}
