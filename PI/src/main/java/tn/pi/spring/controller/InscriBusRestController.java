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

import tn.pi.spring.entity.InscriBus;
import tn.pi.spring.iservice.IinscriBus;

@RestController
@RequestMapping("/inscriBus")
public class InscriBusRestController {
	@Autowired
	IinscriBus inscriBusService;

	// http://localhost:8089/SpringMVC/inscriBus/retrieve-all-inscriBus
	@GetMapping("/retrieve-all-inscriBus")
	@ResponseBody
	public List<InscriBus> getInscriBuss() {
		System.out.println("ggggg");
		
		List<InscriBus> list = inscriBusService.retrieveAllInscriBus();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/inscriBus/retrieve-inscriBus/8
	@GetMapping("/retrieve-inscriBus/{inscriBus-id}")
	@ResponseBody
	public InscriBus retrieveInscriBus(@PathVariable("inscriBus-id") Long inscriBusId) {
	
		return inscriBusService.retrieveInscriBus(inscriBusId);
	}

	// http://localhost:8089/SpringMVC/inscriBus/add-inscriBus
	@PostMapping("/add-inscriBus")
	@ResponseBody
	public InscriBus addInscriBus(@RequestBody InscriBus i) {
		InscriBus inscriBus = inscriBusService.addInscriBus(i);
		return inscriBus;
	}

	// http://localhost:8089/SpringMVC/inscriBus/remove-inscriBus/{inscriBus-id}
	@DeleteMapping("/remove-inscriBus/{inscriBus-id}")
	@ResponseBody
	public void removeInscriBus(@PathVariable("inscriBus-id") Long inscriBusId) {
		inscriBusService.deleteInscriBus(inscriBusId);
	}

	// http://localhost:8089/SpringMVC/inscriBus/modify-inscriBus
	@PutMapping("/modify-inscriBus")
	@ResponseBody
	public InscriBus modifyInscriBus(@RequestBody InscriBus inscriBus) {
		return inscriBusService.updateInscriBus(inscriBus);
	}


}
