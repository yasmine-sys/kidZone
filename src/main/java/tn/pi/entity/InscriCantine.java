package tn.pi.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "InscriCantine")
public class InscriCantine implements Serializable {


	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idinscri")
	private Long idinscri;
	@Column(name="DateInscriCantine")
	private Date dateinscri;
	@Enumerated(EnumType.STRING)
	private Abonnement abonnement;
	@Column(name="Prix")
	private Long prix;
	
	@ManyToOne
    Enfant Enfant;
	
	@JsonIgnore
	@ManyToOne
	Cantine cantines;
}
