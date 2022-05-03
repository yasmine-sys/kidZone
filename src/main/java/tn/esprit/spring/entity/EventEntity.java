	package tn.esprit.spring.entity;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "event")
public class EventEntity implements Serializable {


	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "EventEntity [idEvent=" + idEvent + ", titre=" + titre + ", description=" + description + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + ", nbrPlaces=" + nbrPlaces
				+ ", nbrPlacesDisponible=" + nbrPlacesDisponible + ", reservations=" + reservations + ", rating="
				+ rating + "]";
	}

	/*public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}*/

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvent;
	private String titre;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;
	private float prix;
	/*@Lob
    @Column(length = Integer.MAX_VALUE)
    private byte[] image;*/
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
	@JsonIgnore
	  @OneToMany(mappedBy="eventRat")
	   private  List<Rating> rating;
	
	@JsonIgnore
	  @ManyToOne
	  private UserEntity user;
	

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

		public List<ReservationEntity> getReservations() {
			return reservations;
		}

		public void setReservations(List<ReservationEntity> reservations) {
			this.reservations = reservations;
		}
		

		/*@Override
		public String toString() {
			return "EventEntity [idEvent=" + idEvent + ", titre=" + titre + ", description=" + description + ", dateDebut="
					+ dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + ", image= "+ Arrays.toString(image) +", nbrPlaces="
					+ nbrPlaces + ", nbrPlacesDisponible=" + nbrPlacesDisponible + ", reservations=" + reservations
					+ ", rating=" + rating + "]";
		}*/
		

	public EventEntity(String titre, String description, Date dateDebut, Date dateFin, float prix,
			int nbrPlaces, int nbrPlacesDisponible) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.nbrPlaces = nbrPlaces;
		this.nbrPlacesDisponible = nbrPlacesDisponible;
		//this.image = image;
	}

	public EventEntity(Long idEvent, String titre, String description, Date dateDebut, Date dateFin,
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
		//this.image = image;
	}

	public EventEntity() {
		super();
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
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


}
