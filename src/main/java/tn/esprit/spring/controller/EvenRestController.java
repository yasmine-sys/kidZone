package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.interfaces.IEventService;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class EvenRestController {
	@Autowired
	IEventService eventService;

	// URL : http://localhost:8090/SpringMVC/servlet/retrieveallevents
	@GetMapping("/retrieveallevents")
	@ResponseBody
	public List<EventEntity> getAllEvents() {
		return eventService.getAllEvents();
	}

	// http://localhost:8081/SpringMVC/servlet/eventname
	@GetMapping("/eventname")
	@ResponseBody
	public List<String> getAllEventNamesJPQL() {
		return eventService.getAllEventNamesJPQL();
	}

	// http://localhost:8081/SpringMVC/servlet/deleteEventById/1
	@DeleteMapping("/deleteEventById/{idevent}")
	@ResponseBody
	public void deleteEventById(@PathVariable("idevent") Long idEvent) {
		eventService.deleteEventById(idEvent);

	}

	// http://localhost:8081/SpringMVC/servlet/NbreEvent
	@GetMapping("/NbreEvent")
	@ResponseBody
	public int getNombreEventJPQL() {
		return eventService.getNombreEventJPQL();
	}

	/*
	 * @PutMapping("/updateEvent/{idEvent}")
	 * 
	 * @ResponseBody public ResponseEntity<String> updateEvent(@ModelAttribute
	 * EventEntity e, @PathVariable("idEvent") int idEvent,
	 * 
	 * @RequestParam("file") MultipartFile file) { ieventservice.updateEvent(e,
	 * idEvent, file); return new
	 * ResponseEntity<String>("Event updated successfully", HttpStatus.OK);
	 * 
	 * }
	 */

	// http://localhost:8081/SpringMVC/servlet/retrievealleventsoftoday
	@GetMapping("/eventToday")
	@ResponseBody
	public List<EventEntity> getAllEventPourToday() {
		return eventService.getAllEventPourToday();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsordonnebydate
	@GetMapping("/alleventsordonnebydate")
	@ResponseBody
	public List<EventEntity> getAllEventOrdonneParDate() {
		return eventService.getAllEventOrdonneParDate();
	}
	
	// http://localhost:8089/SpringMVC/stock/addReservation
 	@PostMapping("/addEvent")
 	@ResponseBody
 	public EventEntity addEventEntity(@RequestBody EventEntity s) {
 		EventEntity rev = eventService.addEvent(s);
 		return rev;
 	}
 // http://localhost:8089/SpringMVC/stock/modify-stock
 	@PutMapping("/modifyRes")
 	@ResponseBody
 	public EventEntity updateEvent(@RequestBody EventEntity s) {
 		return eventService.updateEvent(s);
 	}
 	
 	@PostMapping(value = "/ajout/{idEvent}/{iduser}")

	public ResponseEntity<String> ajout(@ModelAttribute EventEntity event,
			@PathVariable("iduser") Long userId) {

		return eventService.ajoutByDirecteurJardin(event, userId);
	}

}
