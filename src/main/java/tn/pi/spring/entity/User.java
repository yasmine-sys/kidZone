package tn.pi.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Long id;
	
	@Column(name="prenom", nullable=true,length = 64)
	private String prenom;

	@Column(name="nom",nullable=true,length = 64)
	private String nom;
	
	@Column(name="description", nullable=true,length = 64 )
	private String description;
	
	@Column(name="adress",nullable=true,length = 64 )
	private String adress;

	@Column(name="telephone",nullable=true,length = 64 )
	private String telephone;
	
	@Column(name="datecreation",nullable=true,length = 64 )
	private Date datecreation;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="passwd")
	private String passwd;

	@Enumerated (EnumType.STRING) 
	private RoleName role;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////Constucteur////////////////////////////////////////

	public User() {
		super();
		// TODO Auto-generated constructor stub
		
	
	}

	public User(Long id, String nom, String description, String adress, String telephone, Date datecreation,
			String mail, String passwd, RoleName role) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.adress = adress;
		this.telephone = telephone;
		this.datecreation = datecreation;
		this.mail = mail;
		this.passwd = passwd;
		this.role = role;
	}

	public User(Long id, String prenom, String nom, String adress, String telephone, String mail, String passwd,
			RoleName role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adress = adress;
		this.telephone = telephone;
		this.mail = mail;
		this.passwd = passwd;
		this.role = role;
	}

	public User(String prenom, String nom, String adress, String telephone, String mail, String passwd, RoleName role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adress = adress;
		this.telephone = telephone;
		this.mail = mail;
		this.passwd = passwd;
		this.role = role;
	}

	public User(String nom, String description, String adress, String telephone, Date datecreation, String mail,
			String passwd, RoleName role) {
		super();
		this.nom = nom;
		this.description = description;
		this.adress = adress;
		this.telephone = telephone;
		this.datecreation = datecreation;
		this.mail = mail;
		this.passwd = passwd;
		this.role = role;
	}
}
