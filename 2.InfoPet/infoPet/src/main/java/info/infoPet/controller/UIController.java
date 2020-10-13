package info.infoPet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
	
	@RequestMapping(value = "/")
	public String loginPage() {
		return "/login";
	}
	
	@RequestMapping(value ="/index")
	public String indexPage() {
		return "/index";
	}
	
	@RequestMapping(value ="/register")
	public String registerPage() {
		return "/register";
	}
}
