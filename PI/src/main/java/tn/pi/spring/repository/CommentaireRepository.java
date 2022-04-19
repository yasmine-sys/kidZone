package tn.pi.spring.repository;





import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.Commentaire;



@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	
	//Collection<Commentaire> findByPublication_Id(final Long publicationId);
	/*//lister les commentaires by publiation 
		@Query(value="r.* from publication pb , commentaire r where r.id_publication=pb.id_publication ", nativeQuery =true)
		public List<Commentaire> getCommentaireByPublication();
		
		//afficher le detailscommentaire  d'un stockpublication
		   @Query("SELECT df FROM commentaire df WHERE df.produit.stock.idPublication=:idPublication  ")
		   List<Commentaire> getdetailsfacturebyStock(@Param("idStock") Long idStock );
		   

	
	@Query("SELECT p FROM Publication p WHERE p.commentaire.idCommentaire=:id")
	List<Publication> findPublication(@Param("id") Long id);*/
	
}
