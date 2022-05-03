package tn.pi.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.lowagie.text.DocumentException;

import tn.pi.spring.Iservice.IinscriBus;
import tn.pi.spring.entity.InscriBus;
import tn.pi.spring.service.InscriBusPdf;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inscriBus")
public class InscriBusRestController {
	@Autowired
	IinscriBus inscriBusService;

	// http://localhost:8085/SpringMVC/inscriBus/retrieve-all-inscriBus
	@GetMapping("/retrieve-all-inscriBus")
	@ResponseBody
	public List<InscriBus> getInscriBuss() {
		/*System.out.println("ggggg");
		
		List<InscriBus> list = inscriBusService.retrieveAllInscriBus();
		System.out.println(list);
		return list;*/
		return inscriBusService.retrieveAllInscriBus();
	}

	// http://localhost:8085/SpringMVC/inscriBus/retrieve-inscriBus/8
	@GetMapping("/retrieve-inscriBus/{inscriBus-id}")
	@ResponseBody
	public InscriBus retrieveInscriBus(@PathVariable("inscriBus-id") Long inscriBusId) {
	
		return inscriBusService.retrieveInscriBus(inscriBusId);
	}

	// http://localhost:8085/SpringMVC/inscriBus/add-inscriBus
	@PostMapping("/add-inscriBus")
	@ResponseBody
	public InscriBus addInscriBus(@RequestBody InscriBus i) {
		InscriBus inscriBus = inscriBusService.addInscriBus(i);
		return inscriBus;
	}

	// http://localhost:8085/SpringMVC/inscriBus/remove-inscriBus/{inscriBus-id}
	@DeleteMapping("/remove-inscriBus/{inscriBusid}")
	@ResponseBody
	public void removeInscriBus(@PathVariable("inscriBusid") Long inscriBusId) {
		inscriBusService.deleteInscriBus(inscriBusId);
	}

	// http://localhost:8085/SpringMVC/inscriBus/modify-inscriBus
	@PutMapping("/modify-inscriBus")
	@ResponseBody
	public InscriBus modifyInscriBus(@RequestBody InscriBus inscriBus) {
		return inscriBusService.updateInscriBus(inscriBus);
	}
	
	//affichage de la liste des enfants inscrits d'un bus
	//http://localhost:8085/SpringMVC/inscriBus/getEnfantsByBus/{idBus}
	@GetMapping("/getEnfantsByBus/{idBus}")
	@ResponseBody
	public List<InscriBus> getEnfantsByBus(@PathVariable("idBus") Long idBus){
		return inscriBusService.getEnfantsByBus(idBus);
		}

	//nombre des enfants inscrits
	// http://localhost:8085/SpringMVC/inscriBus/getNombreEnfantsInscriJPQL
	@GetMapping("/getNombreEnfantsInscriJPQL")
	@ResponseBody
	public int getNombreEnfantsInscriJPQL() {
		return inscriBusService.getNombreEnfantsInscriJPQL();
		}
	
	//nombre des enfants inscrits
	// http://localhost:8085/SpringMVC/inscriBus/getNombreEnfantsInscriByBusJPQL{idBus}
	@GetMapping("/getNombreEnfantsInscriByBusJPQL/{idBus}")
	@ResponseBody
	public int getNombreEnfantsInscriByBusJPQL(@PathVariable("idBus") Long idBus) {
		return inscriBusService.getNombreEnfantsInscriByBusJPQL(idBus);
			}
	//pdf des inscriptions
	// http://localhost:8085/SpringMVC/inscriBus/pdf
	@GetMapping("/pdf")
	public void InscriptionsBusPdf(HttpServletResponse response) throws DocumentException, IOException {
	    response.setContentType("application/pdf");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Inscriptions_Bus"+ ".pdf";
	    response.setHeader(headerKey, headerValue);
	     
	    List<InscriBus> listInscri = inscriBusService.retrieveAllInscriBus();
	     
	    InscriBusPdf exporter = new InscriBusPdf(listInscri);
	    exporter.export(response);
	     
	    
	}

}
