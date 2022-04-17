package tn.esprit.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "event")
public class EventEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvent;
	private String titre;
	private String description;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private float prix;

	@Column(columnDefinition = "integer default 10", name = "nbrPlaces")
	private int nbrPlaces;
	@Column(columnDefinition = "integer default 10", name = "nbrPlacesDisponible")
	private int nbrPlacesDisponible;

	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "event") private
	 * Set<payment> Payment;
	 */
	@JsonIgnore
	  @OneToMany(mappedBy="event")
	   private  List<ReservationEntity> reservations;
	 

		public List<ReservationEntity> getReservations() {
			return reservations;
		}

		public void setReservations(List<ReservationEntity> reservations) {
			this.reservations = reservations;
		}
	public EventEntity(String titre, String description, LocalDateTime dateDebut, LocalDateTime dateFin, float prix,
			int nbrPlaces, int nbrPlacesDisponible) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.nbrPlaces = nbrPlaces;
		this.nbrPlacesDisponible = nbrPlacesDisponible;
	}

	public EventEntity(Long idEvent, String titre, String description, LocalDateTime dateDebut, LocalDateTime dateFin,
			float prix, int nbrPlaces, int nbrPlacesDisponible) {
		super();
		this.idEvent = idEvent;
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.nbrPlaces = nbrPlaces;
		this.nbrPlacesDisponible = nbrPlacesDisponible;
	}

	public EventEntity() {
		super();
	}

	@Override
	public String toString() {
		return "EventEntity [idEvent=" + idEvent + ", titre=" + titre + ", description=" + description + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + ", nbrPlaces=" + nbrPlaces
				+ ", nbrPlacesDisponible=" + nbrPlacesDisponible + "]";
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}

	public int getNbrPlacesDisponible() {
		return nbrPlacesDisponible;
	}

	public void setNbrPlacesDisponible(int nbrPlacesDisponible) {
		this.nbrPlacesDisponible = nbrPlacesDisponible;
	}

	// Getters and setters
	/*
	 * public int getId_event() { return id_event; }
	 * 
	 * public void setId_event(int id_event) { this.id_event = id_event; }
	 * 
	 * public String getTitre() { return titre; }
	 * 
	 * public void setTitre(String titre) { this.titre = titre; }
	 * 
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; }
	 * 
	 * public LocalDateTime getDateDebut() { return dateDebut; }
	 * 
	 * public void setDateDebut(LocalDateTime dateDebut) { this.dateDebut =
	 * dateDebut; }
	 * 
	 * public LocalDateTime getDateFin() { return dateFin; }
	 * 
	 * public void setDateFin(LocalDateTime dateFin) { this.dateFin = dateFin; }
	 * 
	 * public float getPrix() { return prix; }
	 * 
	 * public void setPrix(float prix) { this.prix = prix; }
	 * 
	 * public Set<publicite> getPub() { return Pub; }
	 * 
	 * public void setPub(Set<publicite> pub) { Pub = pub; }
	 * 
	 * public Set<payment> getPayment() { return Payment; }
	 * 
	 * public void setPayment(Set<payment> payment) { this.Payment = payment; }
	 * 
	 * 
	 * 
	 * public int getPlaces() { return places; }
	 * 
	 * public void setPlaces(int places) { this.places = places; }
	 * 
	 * public String getAlert() { return alert; }
	 * 
	 * public void setAlert(String alert) { this.alert = alert; }
	 * 
	 * public int getRemaining() { return remaining; }
	 * 
	 * public void setRemaining(int remaining) { this.remaining = remaining; }
	 * 
	 * public event() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * public event(int id_event, String titre, String description, LocalDateTime
	 * dateDebut, LocalDateTime dateFin, float prix, Set<publicite> pub,
	 * Set<com.example.waves.entities.payment> payment, int places) { super();
	 * this.id_event = id_event; this.titre = titre; this.description = description;
	 * this.dateDebut = dateDebut; this.dateFin = dateFin; this.prix = prix; Pub =
	 * pub; this.Payment = payment; this.places = places; }
	 * 
	 * public event(String titre, String description, LocalDateTime dateDebut,
	 * LocalDateTime dateFin, float prix, int places, int remaining) { super();
	 * 
	 * this.titre = titre; this.description = description; this.dateDebut =
	 * dateDebut; this.dateFin = dateFin; this.prix = prix; this.places = places;
	 * this.remaining = remaining; }
	 * 
	 * public event(String titre, String description, LocalDateTime dateDebut,
	 * LocalDateTime dateFin, float prix, int places, int remaining , int etat) {
	 * super();
	 * 
	 * this.titre = titre; this.description = description; this.dateDebut =
	 * dateDebut; this.dateFin = dateFin; this.prix = prix; this.places = places;
	 * this.remaining = remaining; this.etat= etat; } public event(Integer iD_EVENT,
	 * String titre, String description, LocalDateTime dateDebut, LocalDateTime
	 * dateFin, float prix, int places) { super(); this.id_event = iD_EVENT;
	 * this.titre = titre; this.description = description; this.dateDebut =
	 * dateDebut; this.dateFin = dateFin; this.prix = prix; this.places = places; }
	 * 
	 * }
	 */
}
