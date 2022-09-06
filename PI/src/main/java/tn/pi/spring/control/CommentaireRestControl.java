package tn.pi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.pi.spring.entity.Commentaire;
<<<<<<< Updated upstream

import tn.pi.spring.entity.LikeCommentaire;

import tn.pi.spring.repository.CommentaireRepository;

import tn.pi.spring.services.CommentaireService;

@CrossOrigin(origins= "http://localhost:4200")
=======
import tn.pi.spring.services.CommentaireService;

>>>>>>> Stashed changes
@RestController
@RequestMapping("/commentaire")
@Api(tags = "Gestion commentaires")
public class CommentaireRestControl 
{

	@Autowired
	CommentaireService comentaireService;
<<<<<<< Updated upstream
	
	
	@Autowired
	CommentaireRepository com_rep;
=======
>>>>>>> Stashed changes

	// URL : http://localhost:8081/SpringMVC/commentaire/retrieve-all-commentaires
	@GetMapping("/retrieve-all-commentaires")
	public List<Commentaire> retrieveAllCommentaires() 
	{
		List<Commentaire> list = comentaireService.retrievAllCommentaires();
		return list ;
	}

<<<<<<< Updated upstream
	/*@PostMapping("/add-commentaire")
=======
	@PostMapping("/add-commentaire")
>>>>>>> Stashed changes
	public Commentaire addCommentaire(@RequestBody Commentaire p) 
	{
		return comentaireService.addCommentaire(p);
	}
<<<<<<< Updated upstream
*/
	
	
	@PostMapping("/AddComments/{userId}/{pubId}")
	public String AddCommentaire(@RequestBody Commentaire com,@PathVariable(value = "userId") int userId,@PathVariable(value = "pubId") int pubId){
		comentaireService.AddComments(com,userId, pubId);
					return "comments added succesfully";

	}

	
	@PostMapping("AddLikesComments/{userId}/{comId}")
	public void AddLikeCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeCommentaire like){
		comentaireService.AddLikesComments(like, user_id, comId);
	}
	@PostMapping("AddloveComments/{userId}/{comId}")
	public void AddloveCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeCommentaire like){
		comentaireService.AddloveComments(like, user_id, comId);
	}
	@PostMapping("AddhahaComments/{userId}/{comId}")
	public void AddHahaCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeCommentaire like){
		comentaireService.AddHahaComments(like, user_id, comId);
	}
	@PostMapping("AddsadComments/{userId}/{comId}")
	public void AddsadCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeCommentaire like){
		comentaireService.AddSadComments(like, user_id, comId);
	}
	@PostMapping("AddangryComments/{userId}/{comId}")
	public void AddangryCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeCommentaire like){
		comentaireService.AddAngryComments(like, user_id, comId);
	}
	
=======
>>>>>>> Stashed changes


	@PutMapping("/modify-commentaire")
	public Commentaire modifyCommentaire(@RequestBody Commentaire commentaire) {
		return comentaireService.updateCommentaire(commentaire);
	}

<<<<<<< Updated upstream
@DeleteMapping("/remove-commentaire/{commentaire-id}")
	public void removeCommentaire(@PathVariable("commentaire-id") int commentaireId) 
=======
	@DeleteMapping("/remove-commentaire/{commentaire-id}")
	public void removeCommentaire(@PathVariable("commentaire-id") Long commentaireId) 
>>>>>>> Stashed changes
	{
		comentaireService.deleteCommentaire(commentaireId);
	}

	@GetMapping("/retrieve-commentaire/{commentaire-id}")
<<<<<<< Updated upstream
	public Commentaire retrieveCommentaire(@PathVariable("commentaire-id") int commentaireId) 
=======
	public Commentaire retrieveCommentaire(@PathVariable("commentaire-id") Long commentaireId) 
>>>>>>> Stashed changes
	{
		return comentaireService.retrieveCommentaire(commentaireId);
	}
}
