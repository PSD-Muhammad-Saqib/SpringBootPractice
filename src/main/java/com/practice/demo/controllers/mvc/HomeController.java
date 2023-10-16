package com.practice.demo.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = {"", "/"})
	public String getIndex() {
		System.out.println("redirecting Index................");
		return "index";
	}

}
