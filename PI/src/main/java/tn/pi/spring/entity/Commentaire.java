package tn.pi.spring.entity;

import java.io.Serializable;
import java.util.Date;
<<<<<<< Updated upstream
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
=======
//AUTHOR ABDESSALEM BENCHRIFA
import javax.persistence.CascadeType;
>>>>>>> Stashed changes
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
<<<<<<< Updated upstream
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
=======
>>>>>>> Stashed changes

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< Updated upstream

=======
@RequiredArgsConstructor
>>>>>>> Stashed changes
public class Commentaire implements Serializable {

	private static final long serialVersionUID = 1L;

<<<<<<< Updated upstream
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdAt",nullable=false,updatable=false)
	@CreatedDate
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	 @NotNull
	   
	    private Integer ratingPoints;
	@Column
	private String Comment_field;
	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Publication pub_id;
	@OneToMany(mappedBy="com",cascade=CascadeType.ALL)
	private List<LikeCommentaire> like_comments;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment_field() {
		return Comment_field;
	}
	public void setComment_field(String comment_field) {
		Comment_field = comment_field;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPub_id() {
		return pub_id;
	}
	public void setPub_id(Publication pub_id) {
		this.pub_id = pub_id;
	}
	public Commentaire(int id, String comment_field, User user, Publication pub_id) {
		super();
		this.id = id;
		Comment_field = comment_field;
		this.user = user;
		this.pub_id = pub_id;
	}
	
	public List<LikeCommentaire> getLike_comments() {
		return like_comments;
	}
	public void setLike_comments(List<LikeCommentaire> like_comments) {
		this.like_comments = like_comments;
	}
	public Commentaire(String comment_field, User user, Publication pub_id, List<LikeCommentaire> like_comments) {
		super();
		Comment_field = comment_field;
		this.user = user;
		this.pub_id = pub_id;
		this.like_comments = like_comments;
	}
	
	
	
	

}

	
=======
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long commentaireId;

	@NonNull private Date dateCreation;
	private Date dateDerniereModification;
	@NonNull private String contenuCommentaire;
	@NonNull private Integer ratingCommentaire;
	

	@ManyToOne(cascade=CascadeType.ALL)
	Publication publication;

}
>>>>>>> Stashed changes
