package cs.spring.controllers.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
		
	public HelloRestController(){
	}
	
	@GetMapping("/")
    public String welcome(Principal pPrincipal) {
        return "Welcome " + (pPrincipal != null ? pPrincipal.getName() : "User");
    }
	
	@GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
