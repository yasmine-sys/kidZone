package tn.pi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.spring.Iservice.Ichauffeur;
import tn.pi.spring.entity.Chauffeur;

@RestController
<<<<<<< Updated upstream
=======
@CrossOrigin(origins = "*")
>>>>>>> Stashed changes
@RequestMapping("/chauffeur")
public class ChauffeurRestController {
	@Autowired
	Ichauffeur chauffeurService;

	// http://localhost:8089/SpringMVC/chauffeur/retrieve-all-chauffeurs
	@GetMapping("/retrieve-all-chauffeurs")
	@ResponseBody
	public List<Chauffeur> getChauffeurs() {
		/*System.out.println("ggggg");
		
		List<Chauffeur> list = chauffeurService.retrieveAllChauffeur();
		System.out.println(list);
		return list;*/
		return chauffeurService.retrieveAllChauffeur();
	}

	// http://localhost:8089/SpringMVC/chauffeur/retrieve-chauffeur/8
	@GetMapping("/retrieve-chauffeur/{chauffeur-id}")
	@ResponseBody
	public Chauffeur retrieveChauffeur(@PathVariable("chauffeur-id") Long chauffeurId) {
	
		return chauffeurService.retrieveChauffeur(chauffeurId);
	}

	// http://localhost:8089/SpringMVC/chauffeur/add-chauffeur
	@PostMapping("/add-chauffeur")
	@ResponseBody
	public Chauffeur addChauffeur(@RequestBody Chauffeur c) {
		Chauffeur chauffeur = chauffeurService.addChauffeur(c);
		return chauffeur;
	}

	// http://localhost:8089/SpringMVC/chauffeur/remove-chauffeur/{chauffeur-id}
	@DeleteMapping("/remove-chauffeur/{chauffeur-id}")
	@ResponseBody
	public void removeChauffeur(@PathVariable("chauffeur-id") Long chauffeurId) {
		chauffeurService.deleteChauffeur(chauffeurId);
	}

	// http://localhost:8089/SpringMVC/chauffeur/modify-chauffeur
	@PutMapping("/modify-chauffeur")
	@ResponseBody
	public Chauffeur modifyChauffeur(@RequestBody Chauffeur chauffeur) {
		return chauffeurService.updateChauffeur(chauffeur);
}
}
