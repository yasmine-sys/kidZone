package tn.pi.spring.entity;

import java.io.Serializable;
import java.sql.Date;
<<<<<<< Updated upstream
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
=======
import java.util.List;

>>>>>>> Stashed changes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

<<<<<<< Updated upstream
import com.fasterxml.jackson.annotation.JsonIgnore;

=======
>>>>>>> Stashed changes
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
	
<<<<<<< Updated upstream
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
=======
	@Column(name="nom")
	private String nom;
>>>>>>> Stashed changes
	
	@Column(name="Description")
	private String Description;
	
<<<<<<< Updated upstream
	@Column(name="adress")
	private String adress;
	
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="dateCreation")
	private LocalDateTime  dateCreation;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	


	//@OneToMany(mappedBy = "UserPubication")
	//private  List <Publication> Publications;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Publication> publication_id;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Commentaire> comments;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<LikePublication> like_publication;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<LikeCommentaire> like_comments;
	
	public List<Commentaire> getComments() {
		return comments;
	}
	public void setComments(List<Commentaire> comments) {
		this.comments = comments;
	}
	
	@JsonIgnore
	public List<Publication> getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(List<Publication> publication_id) {
		this.publication_id = publication_id;
	}
	
=======
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
	
//	@OneToMany(mappedBy = "UserPubication")
//	private  List <Publication> Publications;
>>>>>>> Stashed changes
	

}
