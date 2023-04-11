package com.ab.services;

import java.util.List;

import com.ab.entities.User;
import com.ab.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {

		List<User> existingUser = userRepository.findByEmail(user.getEmail());
		if (!existingUser.isEmpty()) {
			throw new RuntimeException("User already exists");
		}

		User newUser = new User();

		newUser.setUsername(user.getUsername());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());

		System.out.println(newUser.toString());

		return userRepository.save(newUser);
	}

	public User loginUser(User user) {

		User existingUser = userRepository.findByUsername(user.getUsername());

		if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("Invalid email or password");
		}

		return existingUser;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
