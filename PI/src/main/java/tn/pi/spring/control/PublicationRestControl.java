package tn.pi.spring.control;

import java.sql.Date;
import java.util.List;
//AUTHOR ABDESSALEM BENCHRIFA
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.pi.spring.configuration.APIResponse;
import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;
import tn.pi.spring.services.PublicationService;

@RestController
@RequestMapping("/publication")
@Api(tags = "Gestion Publications")
public class PublicationRestControl {

	//couplage faible 
	@Autowired
	PublicationService publicationService;
	

	// URL : http://localhost:8081/SpringMVC/publication/retrieve-all-publications
	@GetMapping("/retrieve-all-publications")
	public List<Publication> retrieveAllPublications() 
	{
		List<Publication> list = publicationService.retrievAllPublications();
		return list ;
	}

	@PostMapping("/add-publication")
	public Publication addPublication(@RequestBody Publication p) 
	{
		return publicationService.addPublication(p);
	}


	@PutMapping("/modify-publication")
	public Publication modifyPublication(@RequestBody Publication publication) {
		return publicationService.updatePublication(publication);
	}

	@DeleteMapping("/remove-publication/{publication-id}")
	public void removePublication(@PathVariable("publication-id") Long publicationId) 
	{
		publicationService.deletePublication(publicationId);
	}

	@GetMapping("/retrieve-publication/{publication-id}")
	public Publication retrievePublication(@PathVariable("publication-id") Long publicationId) 
	{
		return publicationService.retrievePublication(publicationId);
	}
	
	@GetMapping("/NbrePublication")
	@ResponseBody
	public int getNombrePublicationJPQL() {
		return publicationService.getNombrePublicationJPQL();
	}
	
	 @ResponseBody
	 @GetMapping("Commentairepublication/{publication-id}")
	 @ApiOperation(value = "commentaire inclu dans une publication")
	 public List<Commentaire> findCommentaire( @PathVariable("publication-id") Long id) {
			return (List<Commentaire>) publicationService.findCommentaire(id);
		}
	 
	 @GetMapping("/getAllPublications")
		@ResponseBody
		@ApiOperation(value = "Récupérer la liste des Publications")
		public List<Publication> getpublications() {
		List<Publication> listPublication = publicationService.getAllPublications();
		return listPublication;
		}
	 
	 @GetMapping("sorting-PublicationBy/{field}")
	 @ApiOperation(value ="trier une publication")
		@ResponseBody
	    private APIResponse<List<Publication>> getPublicationsWithSort(@PathVariable String field) {
	        List<Publication> allStocks = publicationService.retrieveAllPublicationswithSorting(field);
	        return new APIResponse<>(allStocks.size(),allStocks);
	    }
	 
	 @GetMapping("/searchPublicationByDate/{date}")
		@ResponseBody
		@ApiOperation(value = "Recherche Publication avec date ")
	    public List<Publication> searchReclamationByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
			return publicationService.searchPublicationByDate(date);
	    }
	 
	 @GetMapping("/Publication-pagination/{pageNum}/{pageSize}")
	    @ApiOperation(value = "Publication-pagination")
	    private APIResponse<Page<Publication>> getPublicationsWithPagination(@PathVariable int pageNum, @PathVariable int pageSize) {
	        Page<Publication> PublicationsWithPagination = publicationService.findPublicationWithPagination(pageNum, pageSize);
	        return new APIResponse<>(PublicationsWithPagination.getSize(),PublicationsWithPagination);
	    }
	 
	
/*	//affichage de la liste des publications d'un user
			@GetMapping("/getPubicationsByUser/{idUser}")
			@ResponseBody
			public List<Publication> getPublicationsByUser(@PathVariable("idUser") Long idUser){
				return publicationService.getPublicationsByUser(idUser);
		}
	*/
}
