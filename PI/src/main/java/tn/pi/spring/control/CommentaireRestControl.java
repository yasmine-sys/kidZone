package tn.pi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tn.pi.spring.services.CommentaireService;

@RestController
@RequestMapping("/commentaire")
@Api(tags = "Gestion commentaires")
public class CommentaireRestControl 
{

	@Autowired
	CommentaireService comentaireService;

	// URL : http://localhost:8081/SpringMVC/commentaire/retrieve-all-commentaires
	@GetMapping("/retrieve-all-commentaires")
	public List<Commentaire> retrieveAllCommentaires() 
	{
		List<Commentaire> list = comentaireService.retrievAllCommentaires();
		return list ;
	}

	@PostMapping("/add-commentaire")
	public Commentaire addCommentaire(@RequestBody Commentaire p) 
	{
		return comentaireService.addCommentaire(p);
	}


	@PutMapping("/modify-commentaire")
	public Commentaire modifyCommentaire(@RequestBody Commentaire commentaire) {
		return comentaireService.updateCommentaire(commentaire);
	}

	@DeleteMapping("/remove-commentaire/{commentaire-id}")
	public void removeCommentaire(@PathVariable("commentaire-id") Long commentaireId) 
	{
		comentaireService.deleteCommentaire(commentaireId);
	}

	@GetMapping("/retrieve-commentaire/{commentaire-id}")
	public Commentaire retrieveCommentaire(@PathVariable("commentaire-id") Long commentaireId) 
	{
		return comentaireService.retrieveCommentaire(commentaireId);
	}
}
