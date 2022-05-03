package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.ReservationEntity;
import tn.esprit.spring.entity.ReservationPK;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

	/*//findAll Enfant ByEventJPQL
	@Query(value="SELECT DISTINCT e.* from event ev , enfant e , reservation r where r.id_enfant=e.id_enfant AND r.id_event=ev.id_event AND r.id_event=:idEvent", nativeQuery =true)
	public List<EnfantEntity> findAllEnfantByEventJPQL(@Param("idEvent")Long idEvent);
	*/
	
	/*//getAllEventByEnfant
	@Query(value="SELECT DISTINCT ev.titre from event ev , enfant e , reservation r where r.id_enfant=e.id_enfant AND r.id_event=ev.id_event AND r.id_enfant=:idEnfant", nativeQuery =true)
	public List<EventEntity> getAllEventByEnfant(@Param("idEnfant")Long idEnfant);*/
	
	//lister les reservations by event and date 
	@Query(value="r.* from event ev , reservation r where r.id_event=ev.id_event and r.date_reservation=:daterev", nativeQuery =true)
	public List<ReservationEntity> getReservationByEventAndDate(@Param("daterev")ReservationEntity reservation);

}
