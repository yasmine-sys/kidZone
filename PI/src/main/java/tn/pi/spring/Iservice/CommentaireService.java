package tn.pi.spring.Iservice;

import java.util.List;
import java.util.Optional;


import tn.pi.spring.entity.Commentaire;

import tn.pi.spring.entity.LikeCommentaire;



public interface CommentaireService {
	
	List<Commentaire>retrievAllCommentaires();
	//Commentaire addCommentaire(Commentaire c);
	public Commentaire AddComments(Commentaire com,int user_id,int pub_id);
	void deleteCommentaire(int com_id);
	Commentaire updateCommentaire(Commentaire c);
	Commentaire retrieveCommentaire(int com_id);
	Optional<Commentaire> findById(int com_id);
	public void AddLikesComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddloveComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddHahaComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddSadComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddAngryComments(LikeCommentaire like_com,int user_id,int com_id);
	 public void rate(final int id, final Integer buttonState);
	//List<Publication> findPublication(int id);

}
