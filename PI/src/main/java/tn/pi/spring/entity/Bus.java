package tn.pi.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "Bus")
public class Bus {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idBus")
	private Long idBus;
	@Column(name="prix")
	private float prix;
	@Column(name="nombre_enfants_max")
	private int nombre_enfants_max;


	/*@ManyToOne
	Enfant enfant;*/
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	private Set<Trajet> trajets;*/
	
	@ManyToMany(mappedBy="buus", cascade = CascadeType.ALL)
	private Set<Trajet> trajets;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy="buss")
	private Set<InscriBus> InscriBus;
	
	@ManyToOne
	User users;
//chauffeur
	
}
