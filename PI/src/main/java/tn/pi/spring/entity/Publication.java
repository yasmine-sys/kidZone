package tn.pi.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Publication")

public class Publication implements Serializable  {
	private static final long serialVersionUID = 1L;
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
	private String title;
	@Column
	private String publication_txt;
	
	 private String imageUrl;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user", nullable=false)
	private User user;
/*	@Lob
	private byte[] pic; */
	@JsonIgnore
	@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	private List<LikePublication> likes;
	@JsonIgnore
	@OneToMany(mappedBy = "pub_id",cascade=CascadeType.ALL)
	private List<Commentaire> comments;
	
	
	
	public Publication(String publication_txt, User user, List<LikePublication> likes, List<Commentaire> comments) {
		super();
		this.publication_txt = publication_txt;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
	}


	public List<LikePublication> getLikes() {
		return likes;
	}


	public void setLikes(List<LikePublication> likes) {
		this.likes = likes;
	}


	public Publication(String publication_txt, User user, List<Commentaire> comments) {
		super();
		this.publication_txt = publication_txt;
		
		this.user = user;
		this.comments = comments;
	}


	public Publication(int id, String publication_txt, User user, List<Commentaire> comments) {
		super();
		this.id = id;
		this.publication_txt = publication_txt;
		this.user = user;
		this.comments = comments;
	}



	public Publication(int publication_id, String publication_txt, User user_id) {
		super();
		this.id = publication_id;
		this.publication_txt = publication_txt;
		
		this.user = user;
		
	}
	
	


	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPublication_txt() {
		return publication_txt;
	}
	public void setPublication_txt(String publication_txt) {
		this.publication_txt = publication_txt;
	}
	public List<Commentaire> getComments() {
		return comments;
	}



	public void setComments(List<Commentaire> comments) {
		this.comments = comments;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	/*public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
*/
	public Publication(int id, String publication_txt, User user, List<LikePublication> likes,
			List<Commentaire> comments) {
		super();
		this.id = id;
		this.publication_txt = publication_txt;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
	}



/*	public Publication(String publication_txt, User user, List<LikePublication> likes, List<Commentaire> comments) {
		super();
		this.publication_txt = publication_txt;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
	}

*/

	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	public Publication(int id, String title, String publication_txt, User user, List<LikePublication> likes,
			List<Commentaire> comments) {
		super();
		this.id = id;
		this.title = title;
		this.publication_txt = publication_txt;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
	}


	public Publication(String title, String publication_txt, User user, List<LikePublication> likes,
			List<Commentaire> comments) {
		super();
		this.title = title;
		this.publication_txt = publication_txt;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
	}
}




	




	

	

