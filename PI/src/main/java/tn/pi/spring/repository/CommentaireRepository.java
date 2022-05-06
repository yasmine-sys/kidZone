package tn.pi.spring.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pi.spring.entity.Commentaire;




@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	
	@Query(value="SELECT comments.* from commentaire join like_comments on comments.id = like_comments.com_id where pub_id_id = :publicationId GROUP by like_comments.com_id order by COUNT(like_comments.com_id) DESC",nativeQuery=true)
	List<Commentaire> RelevantComments(@Param("publicationId") int id);
	
	
	
	
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
