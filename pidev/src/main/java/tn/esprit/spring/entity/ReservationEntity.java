package tn.esprit.spring.entity;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "reservation")
public class ReservationEntity  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private static final long serialVersionUID = 1L;
	

	
	//idEvent est a la fois primary key et foreign key
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idEvent", referencedColumnName = "idEvent")
	private EventEntity event;
	
	//idEnfant est a la fois primary key et foreign key
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idEnfant", referencedColumnName = "idEnfant")
	private EnfantEntity enfant;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateReservation;
	private boolean isValide;
	

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

	public ReservationEntity( EventEntity event, EnfantEntity enfant, boolean isValide) {
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

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public ReservationEntity(EventEntity event, EnfantEntity enfant, Date dateReservation, boolean isValide) {
		super();
		this.event = event;
		this.enfant = enfant;
		this.dateReservation = dateReservation;
		this.isValide = isValide;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservationEntity(Long id, EventEntity event, EnfantEntity enfant, Date dateReservation, boolean isValide) {
		super();
		this.id = id;
		this.event = event;
		this.enfant = enfant;
		this.dateReservation = dateReservation;
		this.isValide = isValide;
	}

	@Override
	public String toString() {
		return "ReservationEntity [id=" + id + ", event=" + event + ", enfant=" + enfant + ", dateReservation="
				+ dateReservation + ", isValide=" + isValide + "]";
	}	
	
	
}
