package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("Home Controller");
	}

	@GetMapping("/")
	public String homePage() {
		System.out.println("Home page request");
		return "home";
	}
}
