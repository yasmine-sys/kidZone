package tn.pi.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "Chauffeur")
public class Chauffeur {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idChauffeur")
	private Long idChauffeur;	
	@Column(name="nomChauffeur")
	private String nomChauffeur;
	@Column(name="prenomChauffeur")
	private String prenomChauffeur;
	@Column(name="telChauffeur")
	private Long telChauffeur;
	
	
	@JsonIgnore
	@OneToOne(mappedBy="chauffeurs")
	private Bus bus;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="chauffeurs")
	private Set<Bus> Bus;*/

}
