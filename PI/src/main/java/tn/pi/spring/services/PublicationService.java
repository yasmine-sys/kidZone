package tn.pi.spring.services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;

public interface PublicationService {
	
	List<Publication>retrievAllPublications();
	Publication addPublication(Publication c);
	void deletePublication(Long id);
	Publication updatePublication(Publication c);
	Publication retrievePublication(Long id);
	public int getNombrePublicationJPQL();
	List<Commentaire> findCommentaire(Long id);
	List<Publication> getAllPublications();
	List <Publication> retrieveAllPublicationswithSorting( String filed);
	List<Publication> searchPublicationByDate(Date date);
	Page<Publication> findPublicationWithPagination(int offset, int pageSize);
	//List<Publication> getPublicationsByUser(Long idUser);


}