package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.EventEntity;
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
	//nombre des events
	@Query(value="SELECT count(*) from event", nativeQuery =true)
	public int countEvent();
	
	//lister tous les events par titre
	@Query(value="SELECT titre from event", nativeQuery =true)
	public List<String> getAllEventNames() ;

	//lister les events par titre sans doublons
	@Query(value="SELECT DISTINCT e.titre from event e where e.titre=:titre", nativeQuery =true)
	public EventEntity getEvent(@Param("titre") String titre);

	//getAllEvent = today
	@Query(value="SELECT * from event e where e.date_debut = CURRENT_DATE()", nativeQuery =true)
	public List<EventEntity> getAllEventPourToday();

	//getAllEvent Ordonne ParDate
	@Query(value="SELECT * from event e  order by e.date_debut", nativeQuery =true)
	public List<EventEntity> getAllEventOrdonneParDate();
	
	//searchEvent by titre or descp or prix
	/*@Query(value="SELECT * from event e where(e.titre like %:word%" 
					+ "OR e.description like %:word%"
					+ "OR e.prix like %:word% )" , nativeQuery =true)*/
	@Query(value="SELECT e.* from event e where e.titre like :word", nativeQuery =true)
	public List<EventEntity> Search(@Param("word") String word);
	
	//update event titre by id
	@Modifying
    @Transactional
    @Query(value="UPDATE event e SET e.titre=:titre where e.id_event=:idEvent", nativeQuery =true)
    public void mettreAjourTitreByEVentIdJPQL(@Param("titre")String titre, @Param("idEvent")Long idEvent);
	
	//getAllEventByEnfant
		@Query(value="SELECT DISTINCT ev.* from event ev , enfant e , reservation r where r.id_enfant=e.id_enfant AND r.id_event=ev.id_event AND r.id_enfant=:idEnfant", nativeQuery =true)
		public List<EventEntity> getAllEventByEnfant(@Param("idEnfant")Long idEnfant);


}
