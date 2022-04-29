package tn.pi.spring.control;

import java.io.IOException;

import java.sql.Date;
import java.util.List;
//AUTHOR ABDESSALEM BENCHRIFA
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.pi.spring.configuration.APIResponse;
import tn.pi.spring.entity.Commentaire;

import tn.pi.spring.entity.Publication;
import tn.pi.spring.repository.CommentaireRepository;

import tn.pi.spring.repository.PublicationRepository;
import tn.pi.spring.repository.UserRepository;

import tn.pi.spring.services.PublicationService;


@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/publication")
@Api(tags = "Gestion Publications")
public class PublicationRestControl {
	
	@Autowired
	PublicationService pub_service;
	@Autowired
	UserRepository user_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	CommentaireRepository com_rep;
	
	
	private byte[] bytes;
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
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
	
	
	
	

	
}
