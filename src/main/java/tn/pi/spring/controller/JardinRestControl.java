package tn.pi.spring.controller;

import java.util.List;


import java.util.stream.Collectors;

import javax.mail.MessagingException;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.ui.Model;

import tn.pi.spring.Iservice.CoutService;
import tn.pi.spring.Iservice.JardinService;
import tn.pi.spring.Iservice.ReclamationService;
import tn.pi.spring.entity.Cout;
import tn.pi.spring.entity.Jardin;
import tn.pi.spring.entity.Reclamation;



@CrossOrigin(origins = "http://localhost:4200")
@EnableWebMvc
@RestController
@RequestMapping("/Jardin")

public class JardinRestControl 
{

	@Autowired
	JardinService JardinService;
	@Autowired
	CoutService coutService;
	@Autowired 
	ReclamationService reclamationservice;
	// URL : http://localhost:8081/SpringMVC/Jardin/retrieve-all-Jardins
	@GetMapping("/retrieve-all-Jardins")
	public List<Jardin> retrieveAllJardins() 
	{
		List<Jardin> list = JardinService.retrievAllJardins();
		return list ;
	}

	@PostMapping("/add-Jardin")
	public Jardin addJardin(@RequestBody Jardin p) 
	{
		return JardinService.addJardin(p);
	}


	@PutMapping("/modify-Jardin")
	public Jardin modifyJardin(@RequestBody Jardin p) {
		return JardinService.updateJardin(p);
	}

	@DeleteMapping("/remove-Jardin/{jardin-id}")
	public void removeJardin(@PathVariable("jardin-id") Long jardin_id) 
	{
		JardinService.deleteJardin(jardin_id);
	}

	@GetMapping("/retrieve-Jardin/{jardin-id}")
	public Jardin retrieveJardin(@PathVariable("jardin-id") Long jardin_id) 
	{
		return JardinService.retrieveJardin(jardin_id);
	}
	@PutMapping("/modify-Jardinn/{Jardin-id}")
	public void updatejar(@PathVariable("Jardin-id")Long JardinId,@RequestBody Jardin p){
		JardinService.updatejar(JardinId, p);
		
	}
	
	
	@PostMapping("/affecter-cout/{Jardin-id}")
	public void affectercoutjardin( @RequestBody List<Cout> lc,@PathVariable("Jardin-id") Long JardinId) {
		coutService.affectercoutjardin(lc, JardinId);
	}
	
	
	@PostMapping("/envoie-reclamation")
	public void sendEmail(@RequestBody Reclamation reclamation) throws MessagingException { 
		reclamationservice.sendEmail(reclamation);
	}
	
	
	@GetMapping("/barChart")
	public String   getAllJardin(Model model) {	
		
	List<String> nomList=JardinService. getAllJardin().stream().map(x->x.getNom()).collect(Collectors.toList());
	List<Long> nbrenfantList = JardinService. getAllJardin().stream().map(x-> x.getNbrenfant()).collect(Collectors.toList());
	model.addAttribute("nom", nomList);
	model.addAttribute("nbrenfant", nbrenfantList);
	return "barChart";
	
	}
	
}

