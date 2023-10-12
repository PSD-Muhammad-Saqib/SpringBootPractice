package com.practice.demo.repositories;

import java.util.Arrays;
import java.util.List;

import com.practice.demo.models.User;

public class UserFakeDB {

	public static List<User> getUsers(){
		return Arrays.asList(
				new User(1, "Muhammad", "Saqib", "Gujrat"),
				new User(2, "Saif", "ur Rehman", "Gujrat"),
				new User(3, "Saira", "Saad", "Gujranwala")
			);
	}
	
	public static User getUserWithID(Integer id) {
		return getUsers().stream()
				.filter((u) -> u.getId().equals(id))
				.findFirst()
	            .orElse(null);
	}
	
	public static User getUserWithName(Integer id, String name) {
		return getUsers().stream()
				.filter((u) -> (u.getId().equals(id) && u.getUsername().equals(name)))
				.findFirst()
	            .orElse(null);
	}
	
	public static List<User> getUserWithCity(String city) {
		return getUsers().stream()
				.filter((u) -> (u.getCity().equals(city))).toList();
	}
}
