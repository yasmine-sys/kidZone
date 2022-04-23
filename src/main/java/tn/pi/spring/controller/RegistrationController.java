package tn.pi.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
