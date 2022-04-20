package tn.pi.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Emoji;
import tn.pi.spring.entity.LikeCommentaire;
import tn.pi.spring.entity.User;
import tn.pi.spring.repository.CommentaireRepository;
import tn.pi.spring.repository.LikesCommentaireRepository;
import tn.pi.spring.repository.PublicationRepository;
import tn.pi.spring.repository.UserRepository;

@Service
@Slf4j
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Autowired
	LikesCommentaireRepository lcomments_rep;
	
	@Autowired
	CommentaireRepository com_rep;
	
	@Autowired
	PublicationRepository publicationRep;
	
	@Autowired
	UserRepository userRep;
	
	@Override
	public Commentaire AddComments(int user_id,Commentaire com,int pub_id) {
		// TODO Auto-generated method stub

		userRep.findById((long) user_id).map(user -> {
			com.setUser(user);
			return com_rep.save(com);
		}).get();
		return publicationRep.findById((long) pub_id).map(pub -> {
			com.setPub_id(pub);
			return com_rep.save(com);
		}).get();
	}

	
	
	
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

	/*@Override
	public Commentaire addCommentaire(Commentaire c) {
		return commentaireRepository.save(c);
	}
	*/

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
	
	
	@Override
	public void AddLikesComments(LikeCommentaire like_com,int user_id, int com_id) {
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.LikesComments(com_id, user_id)==0) {
				if (user2.getId()==user_id) {
					
					commentaireRepository.findById((long) com_id).map(c ->{
						like_com.setInteractionType(Emoji.Like);
						like_com.setUser(user2);
						like_com.setComm(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddloveComments(LikeCommentaire like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.LoveComments(com_id, user_id)==0) {
				if (user2.getId()==user_id) {
					
					commentaireRepository.findById((long) com_id).map(c ->{
						like_com.setInteractionType(Emoji.love);
						like_com.setUser(user2);
						like_com.setComm(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddHahaComments(LikeCommentaire like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.HahaComments(com_id, user_id)==0) {
				if (user2.getId()==user_id) {
					
					commentaireRepository.findById((long) com_id).map(c ->{
						like_com.setInteractionType(Emoji.haha);
						like_com.setUser(user2);
						like_com.setComm(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddSadComments(LikeCommentaire like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.SadComments(com_id, user_id)==0) {
				if (user2.getId()==user_id) {
					
					commentaireRepository.findById((long) com_id).map(c ->{
						like_com.setInteractionType(Emoji.sad);
						like_com.setUser(user2);
						like_com.setComm(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddAngryComments(LikeCommentaire like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.AngryComments(com_id, user_id)==0) {
				if (user2.getId()==user_id) {
					
					commentaireRepository.findById((long) com_id).map(c ->{
						like_com.setInteractionType(Emoji.angry);
						like_com.setUser(user2);
						like_com.setComm(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}


}
