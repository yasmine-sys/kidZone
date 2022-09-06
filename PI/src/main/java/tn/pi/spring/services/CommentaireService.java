package tn.pi.spring.services;

import java.util.List;
<<<<<<< Updated upstream
import java.util.Optional;


import tn.pi.spring.entity.Commentaire;

import tn.pi.spring.entity.LikeCommentaire;

=======

import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;
>>>>>>> Stashed changes


public interface CommentaireService {
	
	List<Commentaire>retrievAllCommentaires();
<<<<<<< Updated upstream
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
	//List<Publication> findPublication(int id);
=======
	Commentaire addCommentaire(Commentaire c);
	void deleteCommentaire(Long id);
	Commentaire updateCommentaire(Commentaire c);
	Commentaire retrieveCommentaire(Long id);
	//List<Publication> findPublication(Long id);
>>>>>>> Stashed changes

}
