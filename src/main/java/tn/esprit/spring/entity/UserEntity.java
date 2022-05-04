package tn.esprit.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser ;
	private String nomU ; 
	private String prenomU ;
	private long tel;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance ;
	@Enumerated(EnumType.STRING)
	Role role ;
	private String adresse;
	
	@JsonIgnore
	  //@JsonBackReference
	  @OneToMany(mappedBy="user") 
	  private List<EnfantEntity> enfant;
	
	public List<EnfantEntity> getEnfant() {
		return enfant;
	}
	public void setEnfant(List<EnfantEntity> enfant) {
		this.enfant = enfant;
	}
	
	public UserEntity() {
		super();
	}
	public UserEntity(String nomU, String prenomU, long tel, Date dateNaissance, Role role, String adresse) {
		super();
		this.nomU = nomU;
		this.prenomU = prenomU;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.adresse = adresse;
	}
	public UserEntity(Long idUser, String nomU, String prenomU, long tel, Date dateNaissance, Role role,
			String adresse) {
		super();
		this.idUser = idUser;
		this.nomU = nomU;
		this.prenomU = prenomU;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", nomU=" + nomU + ", prenomU=" + prenomU + ", tel=" + tel
				+ ", dateNaissance=" + dateNaissance + ", role=" + role + ", adresse=" + adresse + "]";
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNomU() {
		return nomU;
	}
	public void setNomU(String nomU) {
		this.nomU = nomU;
	}
	public String getPrenomU() {
		return prenomU;
	}
	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
