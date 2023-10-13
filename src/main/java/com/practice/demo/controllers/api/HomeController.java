package com.practice.demo.controllers.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping(value="/home", produces="application/json")
	public @ResponseBody String getHome() {
		return "Welcome to Home";
	}
	
}
