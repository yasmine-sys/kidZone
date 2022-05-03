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

import tn.pi.entity.Cantine;
import tn.pi.spring.Iservice.ICantine;

@RestController
@RequestMapping("/Cantine")
public class CantineRestController {
	@Autowired
	ICantine cantineService;

	// http://localhost:8089/SpringMVC/Cantine/retrieve-all-Cantine
	@GetMapping("/retrieve-all-cantines")
	@ResponseBody
	public List<Cantine> geCantine() {
		/*System.out.println("ggggg");
		
		List<Cantine> list = cantineService.retrieveAllCantine();
		System.out.println(list);
		*/
		return cantineService.retrieveAllCantine();
	}

	// http://localhost:8089/SpringMVC/Cantine/retrieve-Cantine/8
	@GetMapping("/retrieve-Menu/{Menu-id}")
	@ResponseBody
	public Cantine retrieveCantine(@PathVariable("Cantine-id") Long CantineId) {
	
		return cantineService.retrieveCantine(CantineId);
	}

	// http://localhost:8089/SpringMVC/Menu/add-Cantine
	@PostMapping("/add-cantine")
	@ResponseBody
	public Cantine addCantine(@RequestBody Cantine e) {
		Cantine Cantine = cantineService.addCantine(e);
		return Cantine;
	}

	// http://localhost:8089/SpringMVC/Menu/remove-Menu/{Menu-id}
	@DeleteMapping("/remove-Cantine/{Cantine-id}")
	@ResponseBody
	public void removeCantine(@PathVariable("Cantine-id") Long CantineId) {
		cantineService.deleteCantine(CantineId);
	}

	// http://localhost:8089/SpringMVC/Menu/modify-Menu
	@PutMapping("/modify-Cantine")
	@ResponseBody
	public Cantine modifyCantine(@RequestBody Cantine Cantine) {
		return cantineService.updateCantine(Cantine);
	}
}
