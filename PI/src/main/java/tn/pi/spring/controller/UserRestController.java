package tn.pi.spring.controller;

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
import tn.pi.spring.iservice.Iuser;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	Iuser userService;

	// http://localhost:8089/SpringMVC/user/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers() {
		System.out.println("ggggg");
		
		List<User> list = userService.retrieveAllUser();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/user/retrieve-user/8
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") Long userId) {
	
		return userService.retrieveUser(userId);
	}

	// http://localhost:8089/SpringMVC/user/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
		User user = userService.addUser(u);
		return user;
	}

	// http://localhost:8089/SpringMVC/user/remove-user/{user-id}
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") Long userId) {
		userService.deleteUser(userId);
	}

	// http://localhost:8089/SpringMVC/user/modify-user
	@PutMapping("/modify-user")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
		return userService.updateUser(user);
}
}
