package tn.pi.spring.services;


<<<<<<< Updated upstream

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

=======
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;
import tn.pi.spring.repository.PublicationRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
>>>>>>> Stashed changes


@Service
@Slf4j
public class PublicationImpl implements PublicationService {

	@Autowired
<<<<<<< Updated upstream
	PublicationRepository publicationRep;
	
	
	@Autowired
	UserRepository userRep;
=======
	PublicationRepository publicationRepository;
>>>>>>> Stashed changes
	@Override
	public List<Publication> retrievAllPublications() {
		List<Publication> publications =null;
		try {
			log.info("In method retrievAllPublications : ");
			log.debug("Conenction à la base de données : ");
<<<<<<< Updated upstream
			publications = publicationRep.findAll();
=======
			publications = publicationRepository.findAll();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	
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
	 




=======

	@Override
	public Publication addPublication(Publication c) {
		return publicationRepository.save(c);
	}

	@Override
	public void deletePublication(Long id) {
		// TODO Auto-generated method stub
		publicationRepository.deleteById(id);
	}

	@Override
	public Publication updatePublication(Publication c) {
		return publicationRepository.save(c);
	}

	@Override
	public Publication retrievePublication(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return (publicationRepository.findById(id).get());
	}

	
	@Override
	public int getNombrePublicationJPQL() {
		return publicationRepository.countPublication();
	}

	@Override
	public List<Commentaire> findCommentaire(Long id) {
		return (List<Commentaire>) publicationRepository.findCommentaire(id);
	}

	@Override
	public List<Publication> getAllPublications() {
		return (List<Publication>)publicationRepository.findAll();
	}

	@Override
	public List<Publication> retrieveAllPublicationswithSorting(String filed) {
		 return  publicationRepository.findAll(Sort.by(Sort.Direction.ASC,filed));
	}

	@Override
	public List<Publication> searchPublicationByDate(Date date) {
			LocalDate d = LocalDate.now();
			Date dateDuJour = java.sql.Date.valueOf(d);
			if(date.after(dateDuJour )){
				System.out.println("Please Check Your Data .. date could not be after Today");
			}
			return publicationRepository.searchPublicationByDate(date);	
		}

	@Override
	public Page<Publication> findPublicationWithPagination(int offset, int pageSize) {
		Page<Publication> Publications = publicationRepository.findAll(PageRequest.of(offset, pageSize));
        return  Publications;
	}
}

	

	/*@Override
	public List<Publication> getPublicationsByUser(Long idUser) {
		return (List<Publication>) publicationRepository.getPublicationsByUser(idUser);
	}

*/

	
>>>>>>> Stashed changes

	





