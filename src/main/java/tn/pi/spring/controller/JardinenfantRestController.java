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

import tn.pi.entity.Jardinenfant;
import tn.pi.spring.Iservice.IJardinenfant;

@RestController
@RequestMapping("/Jardinenfant")
public class JardinenfantRestController {
	@Autowired
	IJardinenfant JardinenfantService;


	// http://localhost:8089/SpringMVC/Menu/retrieve-all-Menu
	@GetMapping("/retrieve-all-Jardinenfant")
	@ResponseBody
	public List<Jardinenfant> geJardinenfant() {
		/*System.out.println("ggggg");
		List<Jardinenfant> list = JardinenfantService.retrieveAllJardinenfant();
		System.out.println(list);
		*/
		return JardinenfantService.retrieveAllJardinenfant();
	}

	// http://localhost:8089/SpringMVC/Menu/retrieve-Menu/8
	@GetMapping("/retrieve-Menu/{Menu-id}")
	@ResponseBody
	public Jardinenfant retrieveJardinenfant(@PathVariable("Menu-id") Long JardinenfantId) {
	
		return JardinenfantService.retrieveJardinenfant(JardinenfantId);
	}

	// http://localhost:8089/SpringMVC/Jardinenfant/add-Jardinenfant
	@PostMapping("/add-Jardinenfant")
	@ResponseBody
	public Jardinenfant addJardinenfant(@RequestBody Jardinenfant e) {
		Jardinenfant Jardinenfant = JardinenfantService.addJardinenfant(e);
		return Jardinenfant;
	}

	// http://localhost:8089/SpringMVC/Menu/remove-Menu/{Menu-id}
	@DeleteMapping("/remove-Jardinenfant/{Jardinenfant-id}")
	@ResponseBody
	public void removeJardinenfant(@PathVariable("Jardinenfant-id") Long JardinenfantId) {
		JardinenfantService.deleteJardinenfant(JardinenfantId);
	}

	// http://localhost:8089/SpringMVC/Menu/modify-Menu
	@PutMapping("/modify-Jardinenfant")
	@ResponseBody
	public Jardinenfant modifyJardinenfant(@RequestBody Jardinenfant Jardinenfant) {
		return JardinenfantService.updateJardinenfant(Jardinenfant);
	}
}
