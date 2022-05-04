package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.ReservationEntity;
import tn.esprit.spring.entity.ReservationPK;
import tn.esprit.spring.interfaces.IReservationService;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.ReservationRepository;

@Service
public class ReservationService implements IReservationService {

	@Autowired
	EnfantRepository enfantRepoistory;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	EventRepository eventRepository;

	/*@Override
	public Long ajouter(EnfantEntity enfant) {
		enfantRepoistory.save(enfant);
		return enfant.getIdEnfant();
	}*/

	@Override
	public List<EnfantEntity> findAllEnfantByEventJPQL(Long idEvent) {
		return reservationRepository.findAllEnfantByEventJPQL(idEvent);
	}

	@Override
	public List<EventEntity> getAllEventByEnfant(Long idEnfant) {
		return reservationRepository.getAllEventByEnfant(idEnfant);
	}

	/*@Override
	public void ajouterReservation(Long idEnfant, Long idEvent, Date date) {
		ReservationPK reservationPK = new ReservationPK();
		reservationPK.setDateReservation(date);
		reservationPK.setIdEnfant(idEnfant);
		reservationPK.setIdEvent(idEvent);

		ReservationEntity rev = new ReservationEntity();
		rev.setReservationPK(reservationPK);
		rev.setValide(false); // par defaut non valide
		reservationRepository.save(rev);
	}*/
	/*
	 * @Override public void validerReservation(Long idParent, Long idEvent, Date
	 * date, Long idDirecteur) { System.out.println("In valider Reservation"); User
	 * validateur = userRepository.findById(idEvent).get(); ReservationEntity rev =
	 * missionRepository.findById(missionId).get(); //verifier s'il est un chef de
	 * departement (interet des enum)
	 * if(!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){ System.out.
	 * println("l'employe doit etre chef de departement pour valider une feuille de temps !"
	 * ); return; } //verifier s'il est le chef de departement de la mission en
	 * question boolean chefDeLaMission = false; for(Departement dep :
	 * validateur.getDepartements()){ if(dep.getId() ==
	 * mission.getDepartement().getId()){ chefDeLaMission = true; break; } }
	 * if(!chefDeLaMission){ System.out.
	 * println("l'employe doit etre chef de departement de la mission en question");
	 * return; } // TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId,
	 * dateDebut, dateFin); Timesheet timesheet
	 * =timesheetRepository.findBytimesheetPK(timesheetPK);
	 * timesheet.setValide(true);
	 * 
	 * //Comment Lire une date de la base de données SimpleDateFormat dateFormat =
	 * new SimpleDateFormat("dd/MM/yyyy"); System.out.println("dateDebut : " +
	 * dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));
	 * 
	 * 
	 * }
	 */

	@Override
	public ReservationEntity addReservation(ReservationEntity s) {
		return reservationRepository.save(s);
	}

	@Override
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
		
	}

	@Override
	public List<ReservationEntity> retrieveAllReservationEntities() {
		return reservationRepository.findAll();
	}

}
