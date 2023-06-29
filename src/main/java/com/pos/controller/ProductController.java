package com.pos.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@GetMapping("product")
	    public String form() {
	       
		  System.out.print("Product");
	        return "index";
	    }
//	@PostMapping("login")
//    public String login() {
//       
//	  System.out.print("Product");
//        return "login";
//    }
	@GetMapping("login")
	  public String login(Model model) {
	    return "login";
	  }
	  @GetMapping("register")
	  public String register(Model model) {
		    return "register";
		  }
	  @GetMapping("two-columns-sidebar")
	  public String twocolumn(Model model) {
		    return "two-columns-sidebar";
		  }
	  @GetMapping("mini-column-sidebar")
	  public String onecolumn(Model model) {
		    return "mini-column-sidebar";
		  }
	  @GetMapping("mini-plus-one-columns-sidebar")
	  public String minicolumn(Model model) {
		    return "mini-plus-one-columns-sidebar";
		  }
	@GetMapping("tables")
	  public String home2(Model model) {
	    return "tables";
	  }
	@GetMapping("modals")
	  public String modal(Model model) {
	    return "modals";
	  }
	  @PostMapping("login")
	  public String login(Model model, @RequestParam String email, @RequestParam String password) {
	   // User user = userRepository.findByUsernameAndPassword(username, password);
	    if (password == "123") {
	    	System.out.print(email+"haha");
	      // Successfully logged in, redirect to home page.
	      return "home";
	    } else {
	    	System.out.print(email+password);
	      // Login failed, redisplay login page with error message.
	      model.addAttribute("error", "Invalid username or password.");
	      return "login";
	    }
	  }
}
