package tn.esprit.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.ReservationEntity;
import tn.esprit.spring.interfaces.IEnfantService;
import tn.esprit.spring.interfaces.IEventService;
import tn.esprit.spring.interfaces.IReservationService;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservation")
public class ReservationRestController {
	@Autowired
	IEventService eventService;
	@Autowired
	IEnfantService enfantService;
	@Autowired
	IReservationService reservationService;
	
	/*@PostMapping("/ajouterEnfant")
	@ResponseBody
	public Long ajouter(@RequestBody EnfantEntity e) {
		reservationService.ajouter(e);
		return e.getIdEnfant();
	}*/

	// URL : http://localhost:8081/SpringMVC/servlet/findEnfantByEvent/1
    @GetMapping("/findEnfantByEvent/{idEv}")
    @ResponseBody
	public List<EnfantEntity> findAllEnfantByEventJPQL(@PathVariable("idEv") Long idEvent) {

		return reservationService.findAllEnfantByEventJPQL(idEvent);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByMission/1
    @GetMapping("/getAllEventByEnfant/{idEnf}")
    @ResponseBody
	public List<EventEntity> getAllEventByEnfant(@PathVariable("idEnf") Long idEnfant) {

		return reservationService.getAllEventByEnfant(idEnfant);
	}
    
   /* @PostMapping("/reserver/{iduser}/{idevent}/{date}")
	@ResponseBody
	public void ajouterReservation(@PathVariable("iduser") Long userId, @PathVariable("idevent") Long eventId,@PathVariable("date") Date date) {
    	reservationService.ajouterReservation(userId, eventId, date);
}*/
    /*@PostMapping("/reserver/{iduser}/{idevent}/{date}")
	@ResponseBody
	public void ajouterReservation(@PathVariable("iduser") Long userId, @PathVariable("idevent") Long eventId,@PathVariable("date") Date date) {
    	reservationService.ajouterReservation(userId, eventId, date);
    
    }*/
    
 // http://localhost:8089/SpringMVC/stock/addReservation
 	@PostMapping("/addReservation")
 	@ResponseBody
 	public ReservationEntity addReservationEntity(@RequestBody ReservationEntity s) {
 		ReservationEntity rev = reservationService.addReservation(s);
 		return rev;
 	}

 	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
 	@DeleteMapping("/removeRes/{resId}")
 	@ResponseBody
 	public void removeReservation(@PathVariable("resId") Long ss) {
 		reservationService.deleteReservation(ss);
 	}
 	
 // http://localhost:8089/SpringMVC/stock/retrieveall
 	@GetMapping("/retrieveallRes")
 	@ResponseBody
 	public List<ReservationEntity> getRes() {
 		List<ReservationEntity> list = reservationService.retrieveAllReservationEntities();
 		System.out.println(list);
 		return list;
 	}
 	
     
}
