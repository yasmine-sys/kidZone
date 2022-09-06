package tn.pi.spring.control;

<<<<<<< Updated upstream
import java.io.IOException;

=======
>>>>>>> Stashed changes
import java.sql.Date;
import java.util.List;
//AUTHOR ABDESSALEM BENCHRIFA
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
<<<<<<< Updated upstream
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.models.media.MediaType;
import tn.pi.spring.configuration.APIResponse;
import tn.pi.spring.entity.Commentaire;

import tn.pi.spring.entity.Publication;
import tn.pi.spring.repository.CommentaireRepository;

import tn.pi.spring.repository.PublicationRepository;
import tn.pi.spring.repository.UserRepository;

import tn.pi.spring.services.PublicationService;


@CrossOrigin("*")
=======
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.pi.spring.configuration.APIResponse;
import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;
import tn.pi.spring.services.PublicationService;

>>>>>>> Stashed changes
@RestController
@RequestMapping("/publication")
@Api(tags = "Gestion Publications")
public class PublicationRestControl {
<<<<<<< Updated upstream
	
	@Autowired
	PublicationService pub_service;
	@Autowired
	UserRepository user_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	CommentaireRepository com_rep;
	
	
	/*private byte[] bytes;
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}*/
	
	 @PostMapping(value = "/upload")
	    public ResponseEntity<Object> uploadImageOnServer(@RequestParam("file") MultipartFile file) throws IOException {
	        this.pub_service.uploadImage(file);
	        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	    }
	
	
	@GetMapping("/RetrievePublication")
	public List<Publication> retrieveAllPublications(){
		List<Publication> pub = pub_service.RetrievePublication();
		return pub;
	}
	
	@PostMapping("/AddPublication/{id}")
	public String AddPub(@RequestBody Publication pub,@PathVariable("id") int id) throws Exception{
		
		
		return pub_service.AddPublication(id, pub);
	}
	
	@PostMapping("/RetrievePublication")
	public String AddPub(@RequestBody Publication pub) throws Exception{
	
		
		return pub_service.AddPublication(pub);
	}
	
	
	
	@PutMapping("/UpdatePublication/{id}/{user_id}")
	public String UpdatePub(@PathVariable("id") int id ,@RequestBody Publication pub,@PathVariable("user_id") int user_id) {
		pub.setId(id);
		user_rep.findById((long) user_id).map(u ->{
			pub.setUser(u);
			this.pub_service.UpdatePublicationById(pub, id);	
			return u;
		});
		return "pub Update successfully";
	}
	
	/*@PutMapping("/UpdatePublication/{id}")
	public String UpdatePub(@PathVariable("id") int id ,@RequestBody Publication pub) {
		pub.setId(id);
			this.pub_service.UpdatePublicationById(pub, id);	
		
		return "pub Update successfully";
	}
	
	*/
	
	@DeleteMapping("remove-publication/{id}")
	public void DeletePub(@PathVariable("id") int id){
		this.pub_service.DeletePublication(id);
	}
	
	@GetMapping("RetrievePublication/{id}")
	public Publication getPubByID(@PathVariable(value = "id")int id){
		
		
		return pub_service.GetPubById(id);
		
	}
	
	
	/*@GetMapping("RetrievePublication/")
	public Publication getPubByID(Long id){
		
		
		Publication publication = pub_rep.findById(id).orElse(null);
		return publication;
		
	}*/
	
	@GetMapping("RetrieveComments/{id}")
	public List<Commentaire> retrieveCOmmentsById(@PathVariable(value = "id")int id){
		
		return com_rep.RelevantComments(id);
	}
	
	
	
	

	
=======

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
>>>>>>> Stashed changes
}
