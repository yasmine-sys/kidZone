package tn.pi.spring.services;

import java.util.List;
import java.util.Optional;


import tn.pi.spring.entity.Commentaire;

import tn.pi.spring.entity.LikeCommentaire;



public interface CommentaireService {
	
	List<Commentaire>retrievAllCommentaires();
	//Commentaire addCommentaire(Commentaire c);
	public Commentaire AddComments(int user_id,Commentaire com,int pub_id);
	void deleteCommentaire(Long id);
	Commentaire updateCommentaire(Commentaire c);
	Commentaire retrieveCommentaire(Long id);
	Optional<Commentaire> findById(Long id);
	public void AddLikesComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddloveComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddHahaComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddSadComments(LikeCommentaire like_com,int user_id,int com_id);
	public void AddAngryComments(LikeCommentaire like_com,int user_id,int com_id);
	//List<Publication> findPublication(Long id);

}
