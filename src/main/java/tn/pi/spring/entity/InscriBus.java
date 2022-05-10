package tn.pi.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "InscriBus")
public class InscriBus {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idInscriBus")
	private Long idInscriBus;
	@Temporal(TemporalType.DATE)
	private Date date_inscri_bus;
	@Column(name="prix")
	private float prix;
	@Enumerated(EnumType.STRING)
	private Abonnement abonnement;
	
	@JsonIgnore
	@ManyToOne
	Enfant enfants;
	
	@JsonIgnore
	@ManyToOne
	Bus buss;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Trajet trajet;


}
