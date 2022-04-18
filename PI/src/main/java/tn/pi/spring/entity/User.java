package tn.pi.spring.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "User")
public class User {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;	
	@Column(name="nom")
	private String nom;	
	@Column(name="Description")
	private String Description;	
	@Column(name="nbrEmployee")
	private Long nbrEmployee;
	@Column(name="dateCreation")
	private Date dateCreation;
	@Column(name="Tel")
	private Long Tel;
	@Column(name="Localisation")
	private String Localisation;
	@Column(name="enfantMax")
	private Long enfantMax;
	@Column(name="logo")
	private String logo;
	@Column(name="mail")
	private String mail;
	@Column(name="passwd")
	private String passwd;
	@Column(name="Prenom")
	private String Prenom;
	@Column(name="photo")
	private String photo;
	@Column(name="nbrEnfant")
	private Long nbrEnfant;
	
	@Enumerated(EnumType.STRING)
	private Roles roles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private Set<Bus> Bus;
}
