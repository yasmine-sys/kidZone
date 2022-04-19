package tn.pi.spring.services;


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


@Service
@Slf4j
public class PublicationImpl implements PublicationService {

	@Autowired
	PublicationRepository publicationRepository;
	@Override
	public List<Publication> retrievAllPublications() {
		List<Publication> publications =null;
		try {
			log.info("In method retrievAllPublications : ");
			log.debug("Conenction à la base de données : ");
			publications = publicationRepository.findAll();
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

	

	





