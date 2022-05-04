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

import tn.pi.entity.Reclamation;
import tn.pi.spring.Iservice.Ireclamation;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationRestController {
	@Autowired
	Ireclamation reclamationService;

	// http://localhost:8089/SpringMVC/Reclamation/retrieve-all-Reclamations
	@GetMapping("/retrieve-all-Reclamations")
	@ResponseBody
	public List<Reclamation> geReclamations() {
		System.out.println("ggggg");
		
		List<Reclamation> list = reclamationService.retrieveAllReclamation();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/Reclamation/retrieve-Reclamation/8
	@GetMapping("/retrieve-Reclamation/{Reclamation-id}")
	@ResponseBody
	public Reclamation retrieveReclamation(@PathVariable("Reclamation-id") Long ReclamationId) {
	
		return reclamationService.retrieveReclamation(ReclamationId);
	}

	// http://localhost:8089/SpringMVC/Reclamation/add-Reclamation
	@PostMapping("/add-Reclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation e) {
		Reclamation Reclamation = reclamationService.addReclamation(e);
		return Reclamation;
	}

	// http://localhost:8089/SpringMVC/Reclamation/remove-Reclamation/{Reclamation-id}
	@DeleteMapping("/remove-Reclamation/{Reclamation-id}")
	@ResponseBody
	public void removeReclamation(@PathVariable("Reclamation-id") Long ReclamationId) {
		reclamationService.deleteReclamation(ReclamationId);
	}

	// http://localhost:8089/SpringMVC/Reclamation/modify-Reclamation
	@PutMapping("/modify-Reclamation")
	@ResponseBody
	public Reclamation modifyReclamation(@RequestBody Reclamation Reclamation) {
		return reclamationService.updateReclamation(Reclamation);
	}
}
