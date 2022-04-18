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
import tn.pi.spring.entity.Trajet;
import tn.pi.spring.iservice.Itrajet;

@RestController
@RequestMapping("/trajet")
public class TrajetRestController {
	@Autowired
	Itrajet trajetService;

	// http://localhost:8089/SpringMVC/trajet/retrieve-all-trajets
	@GetMapping("/retrieve-all-trajets")
	@ResponseBody
	public List<Trajet> getTrajets() {
		System.out.println("ggggg");
		
		List<Trajet> list = trajetService.retrieveAllTrajet();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/trajet/retrieve-trajet/8
	@GetMapping("/retrieve-trajet/{trajet-id}")
	@ResponseBody
	public Trajet retrieveTrajet(@PathVariable("trajet-id") Long trajetId) {
	
		return trajetService.retrieveTrajet(trajetId);
	}

	// http://localhost:8089/SpringMVC/trajet/add-trajet
	@PostMapping("/add-trajet")
	@ResponseBody
	public Trajet addTrajet(@RequestBody Trajet t) {
		Trajet trajet = trajetService.addTrajet(t);
		return trajet;
	}

	// http://localhost:8089/SpringMVC/trajet/remove-trajet/{trajet-id}
	@DeleteMapping("/remove-trajet/{trajet-id}")
	@ResponseBody
	public void removeTrajet(@PathVariable("trajet-id") Long trajetId) {
		trajetService.deleteTrajet(trajetId);
	}

	// http://localhost:8089/SpringMVC/trajet/modify-trajet
	@PutMapping("/modify-trajet")
	@ResponseBody
	public Trajet modifyTrajet(@RequestBody Trajet trajet) {
		return trajetService.updateTrajet(trajet);
}
}