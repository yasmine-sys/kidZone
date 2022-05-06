package tn.pi.spring.services;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Publication;
import tn.pi.spring.repository.PublicationRepository;
import tn.pi.spring.repository.UserRepository;



@Service
@Slf4j
public class PublicationImpl implements PublicationService {

	@Autowired
	PublicationRepository publicationRep;
	
	
	@Autowired
	UserRepository userRep;
	@Override
	public List<Publication> retrievAllPublications() {
		List<Publication> publications =null;
		try {
			log.info("In method retrievAllPublications : ");
			log.debug("Conenction à la base de données : ");
			publications = publicationRep.findAll();
			log.debug("Le nombre total de Stocks : " + publications.size());
			for (Publication publication : publications) 
			{
				log.debug(" Publication : " + publication.toString());
			}
			log.info("Out method retrievAllPublications without Errors");
		}
		catch (Exception e) {log.error("Error in retrievAllPublications : " + e);}
		return (publications);
	}
	
	@Override
	public String AddPublication(int user_id,Publication pub) throws Exception {
		
		userRep.findById((long) user_id).map(u ->{
			pub.setUser(u);
			return u;
		});
		pub.setCreatedAt(new Date());
		pub.setUpdatedAt(new Date());
		publicationRep.save(pub);
		return "pub added successfully";


	}


	@Override
	public List<Publication> RetrievePublication() {
		// TODO Auto-generated method stub
		List<Publication> pub = (List<Publication>) publicationRep.findAll();
		return pub;
	}

	@Override
	public void UpdatePublicationById(Publication pub, int id) {
		// TODO Auto-generated method stub
		pub.setUpdatedAt(new Date());
		pub.setCreatedAt(new Date());
		this.publicationRep.save(pub);
	}


	@Override
	public void DeletePublication(int id) {
		// TODO Auto-generated method stub

		this.publicationRep.deleteById(id);
	}


	@Override
	public Publication GetPubById(int pubId) {
		// TODO Auto-generated method stub

		return publicationRep.findById(pubId).get();

	}

	
	
	@Override
	public String AddPublication(Publication pub) {
		 publicationRep.save(pub);
		 return "pub";
	}
	
	
	 public void uploadImage(final MultipartFile file) throws IOException {
	        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
	        File convertFile = new File("C:\\Angular\\Kiddy\\src\\assets\\photos\\" + imgGeneratedId + file.getOriginalFilename());
	        Publication foundPost = publicationRep.findFirstByOrderByIdDesc();
	        foundPost.setImageUrl("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
	        convertFile.createNewFile();
	        FileOutputStream fout = new FileOutputStream(convertFile);
	        fout.write(file.getBytes());
	        fout.close();
	        publicationRep.save(foundPost);
}
	 
	 
}
	 





	





