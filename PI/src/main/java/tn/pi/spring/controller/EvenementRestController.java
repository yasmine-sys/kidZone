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

import tn.pi.entity.Evenement;
import tn.pi.spring.Iservice.Ievenement;


@RestController
@RequestMapping("/evenement")
public class EvenementRestController {

	@Autowired
	Ievenement evenementService;

	// http://localhost:8089/SpringMVC/evenement/retrieve-all-evenements
	@GetMapping("/retrieve-all-evenements")
	@ResponseBody
	public List<Evenement> getevenements() {
		System.out.println("ggggg");
		
		List<Evenement> list = evenementService.retrieveAllEvenement();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/evenement/retrieve-evenement/8
	@GetMapping("/retrieve-evenement/{evenement-id}")
	@ResponseBody
	public Evenement retrieveEvenement(@PathVariable("evenement-id") Long evenementId) {
	
		return evenementService.retrieveEvenement(evenementId);
	}

	// http://localhost:8089/SpringMVC/evenement/add-evenement
	@PostMapping("/add-evenement")
	@ResponseBody
	public Evenement addEvenement(@RequestBody Evenement e) {
		Evenement evenement = evenementService.addEvenement(e);
		return evenement;
	}

	// http://localhost:8089/SpringMVC/evenement/remove-evenement/{evenement-id}
	@DeleteMapping("/remove-evenement/{evenement-id}")
	@ResponseBody
	public void removeevenement(@PathVariable("evenement-id") Long evenementId) {
		evenementService.deleteEvenement(evenementId);
	}

	// http://localhost:8089/SpringMVC/evenement/modify-evenement
	@PutMapping("/modify-evenement")
	@ResponseBody
	public Evenement modifyevenement(@RequestBody Evenement evenement) {
		return evenementService.updateEvenement(evenement);
	}

}
