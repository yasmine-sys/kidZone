package tn.pi.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="Prenom")
	private String Prenom;

	@Column(name="nom")
	private String nom;
	
	@Column(name="Description")
	private String Description;

	@Column(name="logo")
	private String logo;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="passwd")
	private String passwd;

	@Enumerated (EnumType.STRING) 
	private RoleName role;

	public User(Long id, String prenom, String nom, String description, String logo, String mail, String passwd,
			RoleName role) {
		super();
		this.id = id;
		Prenom = prenom;
		this.nom = nom;
		Description = description;
		this.logo = logo;
		this.mail = mail;
		this.passwd = passwd;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
