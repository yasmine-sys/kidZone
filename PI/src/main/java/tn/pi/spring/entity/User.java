package tn.pi.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name="id")
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="Description")
	private String Description;
	
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
	
	

}
