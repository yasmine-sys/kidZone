package tn.pi.spring.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Enfant")
public class Enfant {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEnfant")
	private Long idEnfant;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="date_naissance")
	private Date date_naissance;
	@Column(name="sexe")
	private String sexe;
	@Column(name="ville")
	private String ville;
	
	
	/*@OneToMany (cascade = CascadeType.ALL, mappedBy = "bus")
	private Set<Bus> buss;*/
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="enfants")
	private Set<InscriBus> InscriBus;

}
