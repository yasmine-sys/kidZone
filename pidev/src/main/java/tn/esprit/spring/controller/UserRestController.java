package tn.esprit.spring.controller;
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

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IEventService;
import tn.esprit.spring.interfaces.IUserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	IUserService userService;
	/*public List<UserEntity> getAllUserEntitys();
	void addUserEntity(UserEntity u);
	void deleteUserEntity(Long id);
	UserEntity updateUserEntity(UserEntity u);
	
	public UserEntity getUserEntityById(Long id);

	List<UserEntity> getParents(Role role);

	void affecterchildAparent(Long childId, Long parentId) ;
	List<EnfantEntity> getEnfant(Long id);*/
	
	// http://localhost:8080/SpringMVC/servlet/retrieveallusers
		@GetMapping("/retrieveallusers")
		@ResponseBody
		public List<UserEntity> getUsers() {
		List<UserEntity> list = userService.getAllUserEntitys();
		return list;
	}
		
		// http://localhost:8080/SpringMVC/servlet/retrieve-user/{user-id}
		@GetMapping("/retrieveuser/{userid}")
		@ResponseBody
		public UserEntity getUserEntityById(@PathVariable("userid") Long userId) {
		return userService.getUserEntityById(userId);
		}
		
		// http://localhost:8080/SpringMVC/servlet/add-user
		@PostMapping("/adduser")
		@ResponseBody
		public UserEntity addUser(@RequestBody UserEntity u) {
			UserEntity user = userService.addUserEntity(u);
		return user;
		}
		// http://localhost:8080/SpringMVC/servlet/remove-user/{user-id}
		@DeleteMapping("/removeuser/{userid}")
		@ResponseBody
		public void deleteUserEntity(@PathVariable("userid") Long userId) {
		userService.deleteUserEntity(userId);
		}

		// http://localhost:8080/SpringMVC/servlet/modify-user
		@PutMapping("/modifyuser")
		@ResponseBody
		public UserEntity modifyUser(@RequestBody UserEntity user) {
		return userService.updateUserEntity(user);
		}
		
		
		// http://localhost:8080/SpringMVC/servlet/affecterchildAparent
					@PutMapping("/affecterchildAparent/{parentId}/{childId}")
					@ResponseBody
					public void affecterchildAparent(@PathVariable("parentId") Long parentId,@PathVariable("childId") Long childId  ) 
					{
					 userService.affecterchildAparent(parentId,childId);
					}
		
		
		
		
					// http://localhost:8080/SpringMVC/servlet/retrievechildren/{id}
				/*	@GetMapping("/retrievechildren/{id}")
					@ResponseBody
					public List<Child> getchildren(@PathVariable("id") int id) {
					List<Child> list = userService.getChildren(id);
					return list;
				}*/
		
					// http://localhost:8080/SpringMVC/servlet/professall
				/*	@GetMapping("/professall")
					@ResponseBody
					public List<String> getprofession() {
					List<String> nbr = userService.getprofession();
					return nbr;
				}
		
					*/
		
		
		
		
}

