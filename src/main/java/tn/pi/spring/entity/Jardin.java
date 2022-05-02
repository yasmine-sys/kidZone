package tn.pi.spring.entity;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.annotation.JsonIgnore;

@EnableWebMvc
@Entity

public class Jardin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long JardinId;

	 private Date dateCreation; 
	 private String nom;
	 private String localisation;
	 private String description;
	 private String email;
	 private String password;
	 private Long nbremployee;
	 private Long nbrenfant;
	 private Long enfantmax;
	 private Long telephone;
	public Jardin() {
		
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="jardin") 
	private List<Cout> couts;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Jardin(Date dateCreation, String nom, String localisation, String description, String email, String password,
			Long nbremployee, Long nbrenfant, Long enfantmax, Long telephone, List<Cout> couts) {
		super();
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.localisation = localisation;
		this.description = description;
		this.email = email;
		this.password = password;
		this.nbremployee = nbremployee;
		this.nbrenfant = nbrenfant;
		this.enfantmax = enfantmax;
		this.telephone = telephone;
		this.couts = couts;
	}

	public long getJardinId() {
		return JardinId;
	}

	public void setJardinId(long jardinId) {
		JardinId = jardinId;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getNbremployee() {
		return nbremployee;
	}

	public void setNbremployee(Long nbremployee) {
		this.nbremployee = nbremployee;
	}

	public Long getNbrenfant() {
		return nbrenfant;
	}

	public void setNbrenfant(Long nbrenfant) {
		this.nbrenfant = nbrenfant;
	}

	public Long getEnfantmax() {
		return enfantmax;
	}

	public void setEnfantmax(Long enfantmax) {
		this.enfantmax = enfantmax;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public List<Cout> getCouts() {
		return couts;
	}

	public void setCouts(List<Cout> couts) {
		this.couts = couts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	



}