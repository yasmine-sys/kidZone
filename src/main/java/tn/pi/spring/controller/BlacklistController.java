package tn.pi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.pi.spring.Iservice.IBlacklistService;
import tn.pi.spring.entity.Blacklist;

@RestController
@Api(tags = "Blacklist management")
@RequestMapping("/blacklist")
@CrossOrigin(origins = "http://localhost:4200")
public class BlacklistController {
	
	@Autowired
	IBlacklistService blacklistService;
	// http://localhost:8089/SpringMVC/blacklist/addUserToBlacklist/
	@PostMapping("/addUserToBlacklist")
	@ResponseBody
	public void addUserToBlacklist(@RequestBody String email){
		blacklistService.addUserToBlacklist(email);
	}
	
	
	// http://localhost:8089/SpringMVC/blacklist/deleteUserFromBlacklist/
	@DeleteMapping("/deleteUserFromBlacklist/{id}")
	@ResponseBody
	public void deleteUserFromBlacklist(@PathVariable("id") Long id){
		blacklistService.deleteUserFromBlacklist(id);
	}
	
	// http://localhost:8089/SpringMVC/blacklist/getAllBlacklist
	@GetMapping("/getAllBlacklist")
	@ResponseBody
	public List<Blacklist> getAllBlacklist(){
		return blacklistService.getAllBlacklist();
	}

}
