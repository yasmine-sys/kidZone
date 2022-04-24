package tn.pi.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.pi.spring.registration.RegistrationRequest;
import tn.pi.spring.registration.RegistrationService;

@RestController
@RequestMapping(path ="/registration")
@AllArgsConstructor
@CrossOrigin
public class RegistrationController {
	

	private final RegistrationService registrationService;
	
	@PostMapping
	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
	}
	
	 @GetMapping(path = "/confirm")
	    public String confirm(@RequestParam("token") String token) {
	        return registrationService.confirmToken(token);
	    }
	 
	 @GetMapping("/forgetpassword/{email}")
	    public String forgetpassword(@PathVariable("email") String email) {
	        return registrationService.forgetpassword(email);
	    }
	    
	    
	    // http://localhost:8089/SpringMVC/registration/reset
	    @GetMapping("/reset/{token}/{email}/{password}")
	    public String reset(@PathVariable("token") String token,@PathVariable("email") String email,@PathVariable("password") String password) {
	        return registrationService.resetPassword(token,email,password);
	    }
}
