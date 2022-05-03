package tn.esprit.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.interfaces.IRatingEventService;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.IRatingEventRepository;

@Service
public class RatingEventService implements IRatingEventService{
	@Autowired
	IRatingEventRepository ratEventrep;
	@Autowired
	EventRepository eventrepo;
	@Override
	public String addRatingEvent(int idEvent, int ratingValue) {
		Rating rat = new Rating();
		System.out.println("---------------------"+idEvent+"--------"+ratingValue);
		//User user = userrepo.findById(idUser).orElse(null);
		EventEntity event =eventrepo.findById((long) idEvent).orElse(null);
		rat.setEventRat(event);
		//rat.setUserRat(user);
		List<Rating> ratEvent= ratEventrep.findRatingEventByEvent(idEvent);
		if(ratEvent.size()!=0) {
			rat.setRatId(ratEvent.get(0).getRatId());
			rat.setRatingValue(ratingValue);
			ratEvent.get(0).setRatingValue(ratingValue);			
			updateRatingEvent(ratEvent.get(0)); 
			return "Rating is updating successfully";
		}

		rat.setRatingValue(ratingValue);
		ratEventrep.save(rat);
		
		return "Rating is done successfully";
	}

	@Override
	public String updateRatingEvent(Rating ratEvent) {
		ratEventrep.save(ratEvent);
		return "successful update";
	}

	@Override
	public float getAvgRat() {
		return ratEventrep.getAvgOfValueRating();
	}

	@Override
	public float getValueRatingByEventAndUser(int idEvent) {
		List<Rating> ratEvent= ratEventrep.findRatingEventByEvent(idEvent);
		if(ratEvent.size()!=0) return ratEvent.get(0).getRatingValue();
		
		return getAvgRat();
	}

}
