package tn.esprit.spring.entity;

import javax.persistence.*;

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
	@Temporal(TemporalType.DATE)
	private Date dateN;
	private String sexe;
	private String image;
	private int age;
	private String etatSante;
	private String interets;
	@Override
	public String toString() {
		return "EnfantEntity [idEnfant=" + idEnfant + ", nom=" + nom + ", prenom=" + prenom + ", dateN=" + dateN
				+ ", sexe=" + sexe + ", image=" + image + ", age=" + age + ", etatSante=" + etatSante + ", interets="
				+ interets + "]";
	}


	  @JsonIgnore
	  //@JsonBackReference
	  @OneToMany(mappedBy="enfant") 
	  private List<ReservationEntity> reservations;
	  

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

	public EnfantEntity(Long idEnfant, String nom, String prenom, Date dateN, String sexe, String image, int age,
			String etatSante, String interets) {
		super();
		this.idEnfant = idEnfant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
		this.sexe = sexe;
		this.image = image;
		this.age = age;
		this.etatSante = etatSante;
		this.interets = interets;
	}

	public EnfantEntity(String nom, String prenom, Date dateN, String sexe, String image, int age, String etatSante,
			String interets) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
		this.sexe = sexe;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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


	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(fetch = FetchType.EAGER) private Set<User> parents;
	 * 
	 * @JsonIgnore
	 * 
	 * @ManyToOne private KinderGarten kindergarde; //@OneToMany(mappedBy="child")
	 * //private List<FolderMedical>folders;
	 * 
	 * @JsonIgnore
	 * 
	 * @OneToOne(mappedBy="child") private FolderMedical folders; public Child() {
	 * 
	 * super(); // TODO Auto-generated constructor stub }
	 */
	/*
	 * public Child(int id, String name, String sexe, String image, List<User>
	 * users, KinderGarten kindergarde, List<FolderMedical> folders) { super();
	 * this.id = id; this.name = name; this.sexe = sexe; this.image = image;
	 * this.users = users; this.kindergarde = kindergarde; this.folders = folders; }
	 */
	/*
	 * public Child(int idchild, String name, String sexe, String image) { super();
	 * this.id = idchild; this.name = name; this.sexe = sexe; this.image = image; }
	 * public int getId() { return id; } public void setId(int id) { this.id = id; }
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getSexe() { return sexe; } public void
	 * setSexe(String sexe) { this.sexe = sexe; } public String getImage() { return
	 * image; } public void setImage(String image) { this.image = image; }
	 * 
	 * public Set<User> getParents() { return parents; } public void
	 * setParents(Set<User> parents) { this.parents = parents; } public KinderGarten
	 * getKindergarde() { return kindergarde; } public void
	 * setKindergarde(KinderGarten kindergarde) { this.kindergarde = kindergarde; }
	 * /* public List<FolderMedical> getFolders() { return folders; } public void
	 * setFolders(List<FolderMedical> folders) { this.folders = folders; }
	 */
	/*
	 * public static long getSerialversionuid() { return serialVersionUID; }
	 * 
	 * public Date getDateN() { return dateN; } public void setDateN(Date dateN) {
	 * this.dateN = dateN; }
	 * 
	 * public int getAge() { return age; } public void setAge(int age) { this.age =
	 * age; }
	 * 
	 * @Override public String toString() { return "Child [id=" + id + ", name=" +
	 * name + ", dateN=" + dateN + ", sexe=" + sexe + ", image=" + image + "]"; }
	 * public FolderMedical getFolders() { return folders; } public void
	 * setFolders(FolderMedical folders) { this.folders = folders; } public
	 * Child(int id, String name, Date dateN, String sexe, String image, int age,
	 * Set<User> parents, KinderGarten kindergarde, FolderMedical folders) {
	 * super(); this.id = id; this.name = name; this.dateN = dateN; this.sexe =
	 * sexe; this.image = image; this.age = age; this.parents = parents;
	 * this.kindergarde = kindergarde; this.folders = folders; } public Child(int
	 * id, String name, Date dateN, String sexe, String image) { super(); this.id =
	 * id; this.name = name; this.dateN = dateN; this.sexe = sexe; this.image =
	 * image; }
	 * 
	 * public Child( String name, Date dateN, String sexe, String image) { super();
	 * 
	 * this.name = name; this.dateN = dateN; this.sexe = sexe; this.image = image; }
	 */
}

