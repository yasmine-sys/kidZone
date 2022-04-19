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

import tn.pi.entity.Enfant;
import tn.pi.spring.Iservice.Ienfant;

@RestController
@RequestMapping("/enfant")
public class EnfantRestController {
	@Autowired
	Ienfant enfantService;

	// http://localhost:8089/SpringMVC/enfant/retrieve-all-enfants
	@GetMapping("/retrieve-all-enfants")
	@ResponseBody
	public List<Enfant> getEnfants() {
		System.out.println("ggggg");
		
		List<Enfant> list = enfantService.retrieveAllEnfant();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/enfant/retrieve-enfant/8
	@GetMapping("/retrieve-enfant/{enfant-id}")
	@ResponseBody
	public Enfant retrieveEnfant(@PathVariable("enfant-id") Long enfantId) {
	
		return enfantService.retrieveEnfant(enfantId);
	}

	// http://localhost:8089/SpringMVC/enfant/add-enfant
	@PostMapping("/add-enfant")
	@ResponseBody
	public Enfant addEnfant(@RequestBody Enfant e) {
		Enfant enfant = enfantService.addEnfant(e);
		return enfant;
	}

	// http://localhost:8089/SpringMVC/enfant/remove-enfant/{enfant-id}
	@DeleteMapping("/remove-enfant/{enfant-id}")
	@ResponseBody
	public void removeEnfant(@PathVariable("enfant-id") Long enfantId) {
		enfantService.deleteEnfant(enfantId);
	}

	// http://localhost:8089/SpringMVC/enfant/modify-enfant
	@PutMapping("/modify-enfant")
	@ResponseBody
	public Enfant modifyEnfant(@RequestBody Enfant enfant) {
		return enfantService.updateEnfant(enfant);
	}
}
