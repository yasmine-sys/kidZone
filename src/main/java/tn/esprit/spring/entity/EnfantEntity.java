package tn.esprit.spring.entity;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "enfant")
public class EnfantEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnfant;
	private String nom;
	private String prenom;
	//@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateN;
	//private Date dateN;
	private String sexe;
	//private String image;
	private int age;
	private String etatSante;
	private String interets;
	@Override
	public String toString() {
		return "EnfantEntity [idEnfant=" + idEnfant + ", nom=" + nom + ", prenom=" + prenom + ", dateN=" + dateN
				+ ", sexe=" + sexe + ", age=" + age + ", etatSante=" + etatSante + ", interets="
				+ interets + "]";
	}


	  @JsonIgnore
	  //@JsonBackReference
	  @OneToMany(mappedBy="enfant") 
	  private List<ReservationEntity> reservations;
	  
	  @JsonIgnore
	  @ManyToOne
	  private UserEntity user;
	  
	  
	  public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}
	  
	 
	  public List<ReservationEntity> getReservations() {
			return reservations;
		}

		public void setReservations(List<ReservationEntity> reservations) {
			this.reservations = reservations;
		}
	public EnfantEntity() {
		super();
	}

	public EnfantEntity(Long idEnfant, String nom, String prenom, Date dateN, String sexe, int age,
			String etatSante, String interets) {
		super();
		this.idEnfant = idEnfant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
		this.sexe = sexe;
		//this.image = image;
		this.age = age;
		this.etatSante = etatSante;
		this.interets = interets;
	}

	public EnfantEntity(String nom, String prenom, Date dateN, String sexe, int age, String etatSante,
			String interets) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
		this.sexe = sexe;
		//this.image = image;
		this.age = age;
		this.etatSante = etatSante;
		this.interets = interets;
	}

	public Long getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(Long idEnfant) {
		this.idEnfant = idEnfant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/*public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}*/

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEtatSante() {
		return etatSante;
	}

	public void setEtatSante(String etatSante) {
		this.etatSante = etatSante;
	}

	public String getInterets() {
		return interets;
	}

	public void setInterets(String interets) {
		this.interets = interets;
	}

}

