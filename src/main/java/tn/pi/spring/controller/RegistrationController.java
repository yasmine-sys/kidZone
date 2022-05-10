package tn.pi.spring.controller;

import java.util.HashMap;
import java.util.Map;

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
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	

	private final RegistrationService registrationService;
	
	@PostMapping
	public Map<String, String> register(@RequestBody RegistrationRequest request) {
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("token", registrationService.register(request));
		return temp;
	}
	
	 @GetMapping(path = "/confirm")
	    public String confirm(@RequestParam("token") String token) {
	        return registrationService.confirmToken(token);
	    }
	 
	 @GetMapping("/forgetpassword/{email}")
	    public Map<String, String>  forgetpassword(@PathVariable("email") String email) {
		 Map<String, String> temp = new HashMap<String, String>();
		 temp.put("token", registrationService.forgetpassword(email));
	        return temp;
	    }
	    
	    
	    // http://localhost:8089/SpringMVC/registration/reset
	    @GetMapping("/reset/{token}/{email}/{password}")
	    public Map<String, String> reset(@PathVariable("token") String token,@PathVariable("email") String email,@PathVariable("password") String password) {
	    	Map<String, String> temp = new HashMap<String, String>();
	    	 temp.put("token", registrationService.resetPassword(token,email,password));
		        return temp;
	    	
	    }
}
