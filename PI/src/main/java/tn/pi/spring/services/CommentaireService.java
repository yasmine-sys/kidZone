package tn.pi.spring.services;

import java.util.List;
import java.util.Optional;

import tn.pi.spring.entity.Commentaire;



public interface CommentaireService {
	
	List<Commentaire>retrievAllCommentaires();
	Commentaire addCommentaire(Commentaire c);
	void deleteCommentaire(Long id);
	Commentaire updateCommentaire(Commentaire c);
	Commentaire retrieveCommentaire(Long id);
	Optional<Commentaire> findById(Long id);
	//List<Publication> findPublication(Long id);

}
