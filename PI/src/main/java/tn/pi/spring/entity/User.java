package tn.pi.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="User")
public class User implements Serializable{
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	//@OneToMany(mappedBy = "UserPubication")
	//private  List <Publication> Publications;
	

}
