package tn.pi.spring.services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;

public interface PublicationService {
	
	List<Publication>retrievAllPublications();
	public String AddPublication(int user_id,Publication pub) throws Exception;
	public String AddPublication(Publication pub);
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub, int id);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
	/*public int getNombrePublicationJPQL();
	List<Commentaire> findCommentaire(Long id);
	List<Publication> getAllPublications();
	List <Publication> retrieveAllPublicationswithSorting( String filed);
	List<Publication> searchPublicationByDate(Date date);
	Page<Publication> findPublicationWithPagination(int offset, int pageSize);
	//List<Publication> getPublicationsByUser(Long idUser);*/


}