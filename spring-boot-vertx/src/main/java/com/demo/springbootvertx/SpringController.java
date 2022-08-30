package com.demo.springbootvertx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
	
    // @Autowired
    
	@RequestMapping("/")
	public String hello() {
		return "Hello World222!";
	}


}