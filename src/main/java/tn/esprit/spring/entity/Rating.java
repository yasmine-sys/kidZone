package tn.esprit.spring.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ratId;
	
	int ratingValue;
	
	@ManyToOne
	EventEntity eventRat;
	
	public int getRatId() {
		return ratId;
	}

	public void setRatId(int ratId) {
		this.ratId = ratId;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}


	public EventEntity getEventRat() {
		return eventRat;
	}

	public void setEventRat(EventEntity eventRat) {
		this.eventRat = eventRat;
	}

	public Rating(int ratingValue, EventEntity eventRat) {
		super();
		this.ratingValue = ratingValue;
		this.eventRat = eventRat;
	}

	public Rating(int ratId, int ratingValue, EventEntity eventRat) {
		super();
		this.ratId = ratId;
		this.ratingValue = ratingValue;
		this.eventRat = eventRat;
	}

	public Rating() {
		super();
	}

	public Rating(int ratingValue) {
		super();
		this.ratingValue = ratingValue;
	}
	
}
