package com.practice.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.models.User;
import com.practice.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> addUsers(List<User> users) {
		return userRepository.saveAllAndFlush(users);
	}
}
