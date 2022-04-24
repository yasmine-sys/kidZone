package tn.pi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.pi.spring.Iservice.IuserManagement;
import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;

@RestController
@Api(tags = "User management")
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

	@Autowired
	IuserManagement userService;
	
	@GetMapping("/findByEmail/{email}")
	@ResponseBody
	public User findByEmail(@PathVariable("email") String email){
		return userService.findByEmail(email);
	}
	
	// http://localhost:8089/SpringMVC/evenement/retrieve-evenement/8
	@GetMapping("/getUsers")
	@ResponseBody
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
		
	}
		
		// http://localhost:8089/SpringMVC/evenement/add-evenement
	@DeleteMapping("/deleteUser/{email}")
	@ResponseBody
	public void deleteUser(@PathVariable("email") String email){
		userService.deleteUser(email);
		
	}

		// http://localhost:8089/SpringMVC/evenement/remove-evenement/{evenement-id}
	@PutMapping("/updateUser")
	@ResponseBody
	public void updateUser(@RequestBody User user) {
	userService.updateUser(user);
	}

		// http://localhost:8089/SpringMVC/evenement/modify-evenement
	@GetMapping("/findByFirstNameContains/{firstName}")
	@ResponseBody
	public List<User> findByFirstNameContains(@PathVariable("firstName") String firstName){
		return userService.findByFirstNameContains(firstName);
	}
		
}
