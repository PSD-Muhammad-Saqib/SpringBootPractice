package com.practice.demo.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.demo.models.User;
import com.practice.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User addUser(User user) {
		return createUser(user);
	}

	public User addUser(User user, String role) {
		user.setUserRole(role);
		return createUser(user);
	}

	private User createUser(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public List<User> addUsers(List<User> users) {
		return userRepository.saveAllAndFlush(users);
	}
}
