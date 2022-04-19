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

import tn.pi.entity.InscriCantine;
import tn.pi.spring.Iservice.IInscriCantine;

@RestController
@RequestMapping("/InscriCantine")
public class InscriCantineRestController {
	@Autowired
	IInscriCantine InscriCantineService;

	// http://localhost:8089/SpringMVC/inscriCantine/retrieve-all-inscriCantine
	@GetMapping("/retrieve-all-inscriCantine")
	@ResponseBody
	public List<InscriCantine> getInscriCantine() {
		System.out.println("ggggg");
		
		List<InscriCantine> list = InscriCantineService.retrieveAllInscriCantine();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/inscriCantine/retrieve-inscriCantine/8
	@GetMapping("/retrieve-inscriCantine/{inscriCantine-id}")
	@ResponseBody
	public InscriCantine retrieveInscriCantine(@PathVariable("inscriCantine-id") Long InscriCantineId) {
	
		return InscriCantineService.retrieveInscriCantine(InscriCantineId);
	}

	// http://localhost:8089/SpringMVC/inscriCantine/add-inscriCantine
	@PostMapping("/add-inscriCantine")
	@ResponseBody
	public InscriCantine addInscriCantine(@RequestBody InscriCantine e) {
		InscriCantine InscriCantine = InscriCantineService.addInscriCantine(e);
		return InscriCantine;
	}

	// http://localhost:8089/SpringMVC/inscriCantine/remove-inscriCantine/{inscriCantine-id}
	@DeleteMapping("/remove-inscriCantine/{inscriCantine-id}")
	@ResponseBody
	public void removeInscriCantine(@PathVariable("inscriCantine-id") Long InscriCantineId) {
		InscriCantineService.deleteInscriCantine(InscriCantineId);
	}

	// http://localhost:8089/SpringMVC/inscriCantine/modify-inscriCantine
	@PutMapping("/modify-inscriCantine")
	@ResponseBody
	public InscriCantine modifyInscriCantine(@RequestBody InscriCantine InscriCantine) {
		return InscriCantineService.updateInscriCantine(InscriCantine);
	}
}
