package tn.pi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.pi.spring.entity.User;
import tn.pi.spring.services.Iuser;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	Iuser userService;
	
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getusers() {
		System.out.println("ggggg");
		
		List<User> list = userService.retrieveAllUsers();
		System.out.println(list);
		return list;
	}
	
	// http://localhost:8089/SpringMVC/evenement/retrieve-evenement/8
		@GetMapping("/retrieve-user/{user-id}")
		@ResponseBody
		public User retrieveEvenement(@PathVariable("user-id") Long userId) {
		
			return userService.retrieveUser(userId);
		}
		
		// http://localhost:8089/SpringMVC/evenement/add-evenement
		@PostMapping("/add-user")
		@ResponseBody
		public User adduUser(@RequestBody User u) {
			User user = userService.addUser(u);
			return user;
		}

		// http://localhost:8089/SpringMVC/evenement/remove-evenement/{evenement-id}
		@DeleteMapping("/remove-user/{user-id}")
		@ResponseBody
		public void removeuser(@PathVariable("user-id") Long userId) {
			userService.deleteUser(userId);
		}

		// http://localhost:8089/SpringMVC/evenement/modify-evenement
		@PutMapping("/modify-user")
		@ResponseBody
		public User modifyuser(@RequestBody User user) {
			return userService.updateUser(user);
		}

}

