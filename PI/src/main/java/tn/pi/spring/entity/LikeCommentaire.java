package tn.pi.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class LikeCommentaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Like_id;
	@Column
	private boolean isLiked;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="com_id")
	private Commentaire com;
	@Enumerated(EnumType.STRING)
	private Emoji interactionType;
	public int getLike_id() {
		return Like_id;
	}
	public void setLike_id(int like_id) {
		Like_id = like_id;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public Commentaire getComm() {
		return com;
	}
	public void setComm(Commentaire com) {
		this.com = com;
	}
	public Emoji getInteractionType() {
		return interactionType;
	}
	public void setInteractionType( Emoji interactionType) {
		this.interactionType = interactionType;
	}
	public LikeCommentaire(int like_id, boolean isLiked, User user, Commentaire com, Emoji interactionType) {
		super();
		Like_id = like_id;
		this.isLiked = isLiked;
		this.user = user;
		this.com = com;
		this.interactionType = interactionType;
	}
	public LikeCommentaire() {
		super();
		
	}
	
	

}

