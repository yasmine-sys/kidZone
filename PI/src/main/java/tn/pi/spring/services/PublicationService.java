package tn.pi.spring.services;

<<<<<<< Updated upstream

import java.io.IOException;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


=======
import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import tn.pi.spring.entity.Commentaire;
>>>>>>> Stashed changes
import tn.pi.spring.entity.Publication;

public interface PublicationService {
	
	List<Publication>retrievAllPublications();
<<<<<<< Updated upstream
	public String AddPublication(int user_id,Publication pub) throws Exception;
	public String AddPublication(Publication pub);
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub, int id);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
	public void uploadImage(final MultipartFile file) throws IOException ;
	/*public int getNombrePublicationJPQL();
=======
	Publication addPublication(Publication c);
	void deletePublication(Long id);
	Publication updatePublication(Publication c);
	Publication retrievePublication(Long id);
	public int getNombrePublicationJPQL();
>>>>>>> Stashed changes
	List<Commentaire> findCommentaire(Long id);
	List<Publication> getAllPublications();
	List <Publication> retrieveAllPublicationswithSorting( String filed);
	List<Publication> searchPublicationByDate(Date date);
	Page<Publication> findPublicationWithPagination(int offset, int pageSize);
<<<<<<< Updated upstream
	//List<Publication> getPublicationsByUser(Long idUser);*/
=======
	//List<Publication> getPublicationsByUser(Long idUser);
>>>>>>> Stashed changes


}