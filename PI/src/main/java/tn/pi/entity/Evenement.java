package tn.pi.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table( name = "Evenement")
public class Evenement {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name="idEvenement")
	private Long idEvenement;
	
	@Column(name="nomEvenement")
	private String nomEvenement;
	
	@Column(name="participants")
	private int participants;
	
	@Column(name="adresseEvenement")
	private String adresseEvenement;
	
	@Column(name="prixEvenement")
	private float prixEvenement;
	
	@Column(name="datedebutEvenement")
	private Date datedebutEvenement;
	
	@Column(name="datefinEvenement")
	private Date datefinEvenement;
	
	@Column(name="trancheAge")
	private String trancheAge;
	
	

}
