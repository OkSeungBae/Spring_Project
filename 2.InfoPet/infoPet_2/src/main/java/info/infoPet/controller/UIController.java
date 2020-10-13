package info.infoPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import info.infoPet.model.User;
import info.infoPet.service.UserService;
import info.infoPet.repository.UserRepository;

@Controller
public class UIController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		return mv;
	}
	
	@RequestMapping(value ="/index")
	public ModelAndView indexPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	
	@RequestMapping(value ="/register")
	public ModelAndView registerPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register");
		return mv;
	}
	
	//http://localhost:8080/infoPet/signup
		@PostMapping("/signup")
		public ResponseEntity<User> insert(@RequestBody User user){
			userService.save(user);
			return new ResponseEntity(user,HttpStatus.CREATED);	
		}
	
}
