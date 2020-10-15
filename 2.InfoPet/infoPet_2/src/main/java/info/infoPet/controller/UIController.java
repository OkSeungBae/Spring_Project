package info.infoPet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import info.infoPet.model.FullData;
import info.infoPet.model.User;
import info.infoPet.service.FullDataService;
import info.infoPet.service.UserService;
import info.infoPet.repository.UserRepository;

@Controller
public class UIController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	   FullDataService fullDataService;
	
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
	
	@RequestMapping(value = "/signup")
	public ResponseEntity<?> findUser(@RequestBody User reqUser) {
		
		System.out.println("signup");
		
		User user  = userService.findByUserEmailOrName(reqUser.getEmail(), reqUser.getName());
		
		if(user != null) { // 아이디(이메일) 이미 존재
			return new ResponseEntity<>("{}",HttpStatus.FAILED_DEPENDENCY );
		}
		else { // 아이디 생성
			userService.save(reqUser);
			return new ResponseEntity(reqUser, HttpStatus.CREATED);
		}
	}
	
	 @RequestMapping(value = "/search")
	   public ModelAndView findFulldata(@RequestBody FullData fullData) {
	      
	      List<FullData> findFullDataList = fullDataService.findByName(fullData.getName());
	      for(FullData findData : findFullDataList) {
	         System.out.println("찾음 :: " + findData.getManageid());
	      }
	      
	      ModelAndView mv = new ModelAndView();
	      mv.addObject("findDataList", "test");
	      mv.setViewName("test");
	      return mv;
	   }
	
	@RequestMapping(value = "/loginrequest")
	   public ResponseEntity<?> loginreqUser(@RequestBody User reqUser) {
	    
		User user = userService.findByUserEmailAndPassword(reqUser.getEmail(), reqUser.getPassword());
	      
	      if(user != null) { // 아이디, 패스워드 일치 
	    	  return new ResponseEntity<>("{}", HttpStatus.OK);
	      }
	      else { // 로그인 정보 불일치
	    	  return new ResponseEntity<>("{}",HttpStatus.FAILED_DEPENDENCY );
	      }
	      
	   }
	
}
