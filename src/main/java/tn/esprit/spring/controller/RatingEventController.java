package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.interfaces.IRatingEventService;
@RestController
@CrossOrigin("*")
@RequestMapping("/rating")
public class RatingEventController {
	@Autowired
	IRatingEventService ratEventServ;
	
	
	
	@PostMapping("/AddRating/{idEvent}/{valueRating}")
	public String addRatingEvent(@PathVariable("idEvent")int idEvent ,@PathVariable("valueRating") int ratingValue) 
	{
		System.out.println("---------------------"+idEvent+"--------"+ratingValue);
		return ratEventServ.addRatingEvent(idEvent, ratingValue);
	}
	@GetMapping("/rating/{idEvent}")
	public float getValueRatingByEventAndUser(@PathVariable("idEvent")int idEvent) {
		return ratEventServ.getValueRatingByEventAndUser(idEvent);
	}
	@PutMapping("/modifyrating")
	@ResponseBody
	public String updateRatingEvent(@RequestBody Rating ratEvent) {
		return ratEventServ.updateRatingEvent(ratEvent);
	}
}
