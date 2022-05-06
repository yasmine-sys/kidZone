package tn.esprit.spring.interfaces;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.ReservationEntity;

public interface IReservationService {
	//public Long ajouter(EnfantEntity enfant);
	//public void affecterEnfantToEvent(Long missionId, Long depId);
	//public void ajouterReservation(Long missionId, Long employeId,Date date);
	//public void validerReservation(Long missionId, Long employeId, Date date, Long idDirecteur);
	public List<EnfantEntity> findAllEnfantByEventJPQL(Long idEvent);
	public List<EventEntity> getAllEventByEnfant(Long idEnfant);
	ReservationEntity addReservation(ReservationEntity s);
	void deleteReservation(Long id);
	List<ReservationEntity> retrieveAllReservationEntities();
}
