package tn.pi.spring.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "Trajet")
public class Trajet {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idTrajet")
	private Long idTrajet;
	@Column(name="point_depart")
	private String point_depart;
	@Column(name="point_arivee")
	private String point_arivee;
	@Column(name="longeur_trajet")
	private Long longeur_trajet;
	@Column(name="duree_trajet")
	private String duree_trajet;
	@Column(name="heure_depart")
	private String heure_depart;
	
	/*@ManyToMany(mappedBy="trajets", cascade = CascadeType.ALL)
	private Set<Bus> bus;*/
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Bus> buus;
	
}
