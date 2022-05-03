package tn.esprit.spring.entity;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Embeddable
public class ReservationPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//private Long id;
	private Long idEnfant;

	private Long idEvent;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateReservation;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateReservation == null) ? 0 : dateReservation.hashCode());
		result = (int) (prime * result + idEnfant);
		result = (int) (prime * result + idEvent);
		return result;
	}
	@Override
	public String toString() {
		return "ReservationPK [idEnfant=" + idEnfant + ", idEvent=" + idEvent + ", dateReservation="
				+ dateReservation + "]";
	}

/*	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationPK other = (ReservationPK) obj;
		if (dateReservation == null) {
			if (other.dateReservation != null)
				return false;
		} else if (!dateReservation.equals(other.dateReservation))
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idEnfant != other.idEnfant)
			return false;
		return true;
	}

	public Long getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(Long idEnfant) {
		this.idEnfant = idEnfant;
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public ReservationPK(Date dateReservation) {
		super();
		this.dateReservation = dateReservation;
	}

	public ReservationPK() {
		super();
	}
}
