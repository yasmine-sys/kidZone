package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tn.esprit.spring.interfaces.IEnfantService;



@RestController
@CrossOrigin("*")
@RequestMapping("/enfant")
public class EnfantRestController {
	@Autowired
	IEnfantService enfantService;

	// http://localhost:8087/SpringMVC/servlet/retrieveallchildren
	@GetMapping("/retrieveallchildren")
	@ResponseBody
	public List<EnfantEntity> getchildren() {
		List<EnfantEntity> list = enfantService.retrieveAllChildren();
		return list;
	}

	// http://localhost:8080/SpringMVC/servlet/retrievechild/{childid}
	@GetMapping("/retrievechild/{childid}")
	@ResponseBody
	public EnfantEntity retrievechild(@PathVariable("childid") String childId) {
		return enfantService.retrieveChild(childId);
	}

			// http://localhost:8080/SpringMVC/servlet/addchild
			@PostMapping("/addchild")
			@ResponseBody
			public EnfantEntity addchild(@RequestBody EnfantEntity c) {
				EnfantEntity child = enfantService.addChild(c);
				return child;
				}
	// http://localhost:8080/SpringMVC/servlet/removechild/{childid}
	@DeleteMapping("/removechild/{childid}")
	@ResponseBody
	public void removechild(@PathVariable("childid") String childId) {
		enfantService.deleteChild(childId);
	}

	// http://localhost:8080/SpringMVC/servlet/modifychild
	@PutMapping("/modifychild")
	@ResponseBody
	public EnfantEntity modifychild(@RequestBody EnfantEntity child) {
		return enfantService.updateChild(child);
	}

}
