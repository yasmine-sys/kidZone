package tn.esprit.spring.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "reservation")
public class ReservationEntity  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ReservationPK reservationPK;
	

	
	//idEvent est a la fois primary key et foreign key
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idEvent", referencedColumnName = "idEvent", insertable=false, updatable=false)
	private EventEntity event;
	
	//idEnfant est a la fois primary key et foreign key
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idEnfant", referencedColumnName = "idEnfant", insertable=false, updatable=false)
	private EnfantEntity enfant;

	private boolean isValide;
	
	
	public ReservationPK getReservationPK() {
		return reservationPK;
	}

	public void setReservationPK(ReservationPK reservationPK) {
		this.reservationPK = reservationPK;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public EnfantEntity getEnfant() {
		return enfant;
	}

	public void setEnfant(EnfantEntity enfant) {
		this.enfant = enfant;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public ReservationEntity(ReservationPK reservationPK, EventEntity event, EnfantEntity enfant, boolean isValide) {
		super();
		this.reservationPK = reservationPK;
		this.event = event;
		this.enfant = enfant;
		this.isValide = isValide;
	}

	public ReservationEntity(EventEntity event, EnfantEntity enfant, boolean isValide) {
		super();
		this.event = event;
		this.enfant = enfant;
		this.isValide = isValide;
	}

	public ReservationEntity(EventEntity event, EnfantEntity enfant) {
		super();
		this.event = event;
		this.enfant = enfant;
	}

	public ReservationEntity() {
		super();
	}	
	
}
