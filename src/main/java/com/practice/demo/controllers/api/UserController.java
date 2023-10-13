package com.practice.demo.controllers.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.models.User;
import com.practice.demo.repositories.UserFakeDB;
import com.practice.demo.services.UserService;

@RestController()
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/home", produces = "application/json")
	public ResponseEntity<List<User>> getUserHome(@RequestParam(name = "city", defaultValue = "") Optional<String> city) {
		return city.get().equals("") ? ResponseEntity.ok(UserFakeDB.getUsers())
				: ResponseEntity.ok(UserFakeDB.getUserWithCity(city.get()));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<User> addUser(@RequestBody(required = true) User user) {
		return ResponseEntity.ok(service.addUser(user));
	}
	
	@PostMapping(value = "/addMulti")
	public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users) {
	    List<User> savedUsers = service.addUsers(users);
	    return ResponseEntity.ok(savedUsers);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUser(@PathVariable(value = "id", required = false) Optional<Integer> id) {
		User user = UserFakeDB.getUserWithID(id.get());

		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "user not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}

	@GetMapping("/get/{id}/{name}")
	public ResponseEntity<?> getUser(@PathVariable Map<String, String> pathVars) {
		Integer id = Integer.parseInt(pathVars.get("id"));
		String name = pathVars.get("name");

		User user = UserFakeDB.getUserWithName(id, name);

		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "user not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}

	// if added [, headers = "Content=Json"] then path will only be only found if
	// headers match
	@GetMapping(value = "/securePass/{id}")
	public ResponseEntity<?> getSecurePassword(@PathVariable("id") Integer id,
			@RequestHeader(name = "Content", defaultValue = "Json") String content,
			@RequestHeader Map<String, String> headers) {

		if (!headers.get("auth").equals("allowed"))
			return new ResponseEntity<>("Not Allowed", HttpStatus.NOT_ACCEPTABLE);

		String password = UserFakeDB.getUserWithID(id).getPassword();

		if (content.equals("Json")) {
			Map<String, String> response = new HashMap<>();
			response.put("password", password);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.ok(password);
		}
	}

}
