package tn.pi.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.repository.CommentaireRepository;

@Service
@Slf4j
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Override
	public List<Commentaire> retrievAllCommentaires() {
		List<Commentaire> commentaires = null;
		try {
			log.info("In method retrievAllCommentaires : ");
			log.debug("Conenction à la base de données : ");
			commentaires = commentaireRepository.findAll();
			log.debug("Le nombre total de Stocks : " + commentaires.size());
			for (Commentaire commentaire : commentaires) 
			{
				log.debug(" Produit : " + commentaire.toString());
			}
			log.info("Out method retrievAllCommentaires without Errors");
		}
		catch (Exception e) {log.error("Error in retrievAllCommentaires : " + e);}
		return (commentaires);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Commentaire addCommentaire(Commentaire c) {
		return commentaireRepository.save(c);
	}

	@Override
	public Commentaire updateCommentaire(Commentaire c) {
		// TODO Auto-generated method stub
		//return null;
		return commentaireRepository.save(c);
	}

	@Override
	public Commentaire retrieveCommentaire(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return (commentaireRepository.findById(id).get());
	}

	@Override
	public void deleteCommentaire(Long id) {
		commentaireRepository.deleteById(id);		
	}

	@Override
	public Optional<Commentaire> findById(Long id) {
		 return commentaireRepository.findById(id);
	}

/*	@Override
	public List<Publication> findPublication(Long id) {
		return (List<Publication>) commentaireRepository.findPublication(id);
	}
	
*/	


}
