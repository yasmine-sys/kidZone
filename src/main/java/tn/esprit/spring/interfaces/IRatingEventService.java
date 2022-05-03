package tn.esprit.spring.interfaces;

import tn.esprit.spring.entity.Rating;

public interface IRatingEventService {
	public String addRatingEvent(int idEvent,int ratingValue);
	public String updateRatingEvent(Rating ratEvent);
	public float getAvgRat();
	public float getValueRatingByEventAndUser(int idEvent);
}
