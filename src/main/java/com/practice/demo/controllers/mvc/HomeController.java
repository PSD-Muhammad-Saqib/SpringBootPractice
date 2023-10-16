package com.practice.demo.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping(value = {"", "/"})
	public String getIndex() {
		System.out.println("redirecting Index................");
		return "index";
	}
	
	@GetMapping("/home")
	public String getHome() {
		System.out.println("redirecting Home................");
		return "home";
	}
}
