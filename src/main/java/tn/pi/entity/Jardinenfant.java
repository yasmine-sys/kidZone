package tn.pi.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "jardinenfant")
public class Jardinenfant implements Serializable {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idjardin")
	private Long idjardin;
	 private Date dateCreation; 
	 private String nom;
	 private String prenom;
	 private String localisation;
	 private String logo;
	 private String description;
	 private String mail;
	 private String passwd;
   private String photo;
	 private Long nbremployee;
	 private Long nbrenfant;
	 private Long enfantmax;
	 private Long tel;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="jardinenfant")
		private Set<Cantine> cantine;
}
