package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IEventService;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class EventService implements IEventService {
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	UserRepository userRepository;
	
	/*@Override
	public Long addEvent(EventEntity e) {

		eventRepository.save(e);
		return e.getIdEvent();
	}*/
	@Override
	public List<EventEntity> getAllEvents() {
		return (List<EventEntity>) eventRepository.findAll();
	}
	
	@Override
	public String getEventTitreById(Long idEvent) {
		EventEntity e = eventRepository.findById(idEvent).get();
		return e.getTitre();
	}
	@Override
	public void deleteEventById(Long idEvent) {
		EventEntity e = eventRepository.findById(idEvent).orElse(null);
		eventRepository.delete(e);
	}

	@Override
	public int getNombreEventJPQL() {
		return eventRepository.countEvent();
	}

	@Override
	public List<String> getAllEventNamesJPQL() {
		return eventRepository.getAllEventNames();
	}

	@Override
	public void mettreAjourTitreByEVentIdJPQL(String titre, Long idEvent) {
		eventRepository.mettreAjourTitreByEVentIdJPQL(titre, idEvent);
		
	}

	@Override
	public List<EventEntity> getAllEventPourToday() {
		return eventRepository.getAllEventPourToday();
	}

	@Override
	public List<EventEntity> getAllEventOrdonneParDate() {
		return eventRepository.getAllEventOrdonneParDate();
	}

	@Override
	public List<EventEntity> Search(String mot) {
		return (List<EventEntity>) eventRepository.searchEvent(mot);
	}
	/*@Override
	public ResponseEntity<String> ajoutByDirecteur (EventEntity event, Long userId) {

		UserEntity u = userRepository.findById(userId).orElse(null);
		if (u.getRole().toString() == "Directeur") {
			event.setUser(u);
			}

			eventrep.save(event);
			return ResponseEntity.ok("Event added successfully");
		
		return ResponseEntity.ok("ajout non autorisé");
	}*/
	@Override
	public EventEntity addEvent(EventEntity s) {
		return eventRepository.save(s);
	}
	@Override
	public EventEntity updateEvent(EventEntity s) {
		return eventRepository.save(s);
	}

	@Override
	public ResponseEntity<String> ajoutByDirecteurJardin(EventEntity event, Long userId) {
		//EventEntity k = eventRepository.findById(eventId).orElse(null);
		UserEntity u =userRepository.findById(userId).orElse(null);
		if (u.getRole().toString() == "parent") {

			eventRepository.save(event);
			return ResponseEntity.ok("Event added successfully");
		}
		return ResponseEntity.ok("ajout non autorisé");
	}

	/*@Override
	public Map<EventEntity, Integer> NombreticketsRestant() {
		List<EventStat> tab = eventrepository.findTop(PageRequest.of(0, 3));

		Map<event, Integer> tabStats = new HashedMap();

		for (int i = 0; i < tab.size(); i++) {

			Integer nb = tab.get(i).getRemaining();

			tabStats.put(tab.get(i).getEvent(), nb);
		}
		return tabStats;
	}

	@Override
	public Map<EventEntity, Integer> Nombretickets() {
		// TODO Auto-generated method stub
		return null;
	}

*/	

}
