package tn.pi.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

//AUTHOR ABDESSALEM BENCHRIFA
import org.springframework.stereotype.Repository;


import tn.pi.spring.entity.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	
	
	/*//search
	@Query(value="SELECT * from event e where(e.titrePublication like %:word%" 
			+ "OR e.contenuPublication like %:word%" , nativeQuery =true)
public List<Publication> searchEvent(@Param("word") String word);
	*/
	
	/*@Query("SELECT p FROM Produit p WHERE p.publication=:publication")
	List<Commentaire> findCommentairewithpublication(@Param("publication") Publication publication);
	*/
	
	//nb des publications
	/*	@Query(value="SELECT count(*) from publication", nativeQuery =true)
		public int countPublication();
		
		@Query("SELECT c FROM Commentaire c WHERE c.publication.publicationId=:id")
		List<Commentaire> findCommentaire(@Param("id") Long id);
		
		@Query("SELECT p FROM Publication p WHERE p.dateDerniereModification=:date") 
		List<Publication> searchPublicationByDate(@Param("date") Date date);
		

	/*	//afficher la liste des publication d'un user 
		@Query("SELECT p FROM Publication p   WHERE   p.userPublication.id=:idUser")
		List<Publication> getPublicationsByUser(@Param("idUser")Long idUser);
	*/

}
