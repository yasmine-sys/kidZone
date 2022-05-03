package tn.esprit.spring.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


//import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entity.EventEntity;

import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IEventService;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.UserRepository;

import org.springframework.util.StringUtils;

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
		return (List<EventEntity>) eventRepository.Search(mot);
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

	/*@Override
	public ResponseEntity<String> ajoutByDirecteurJardin(Long eventId, Long userId,MultipartFile file) {
		EventEntity k = eventRepository.findById(eventId).orElse(null);
		UserEntity u =userRepository.findById(userId).orElse(null);
		if (u.getRole().toString() == "parent") {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if (fileName.contains("..")) {
				System.out.println("not a a valid file");
			}
			try {
				k.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			eventRepository.save(k);
			return ResponseEntity.ok("Event added successfully");
		}
		return ResponseEntity.ok("ajout non autorisé");
	}*/
	
	@Override
	public List<EventEntity> getAllEventByEnfant(Long idEnfant) {
		return eventRepository.getAllEventByEnfant(idEnfant);
	}

	@Override
	public void addEventByUser(EventEntity s, Long idUser) {
		UserEntity u = userRepository.findById(idUser).get();
		s.setUser(u);

		eventRepository.save(s);
		
	}

	/*@Override
	public void updateEvente(EventEntity e, Long idEvent, MultipartFile file) {
		
		EventEntity event = eventRepository.findById(idEvent).get();
		event.setDateDebut(e.getDateDebut());
		event.setDateFin(e.getDateFin());
		event.setDescription(e.getDescription());
		event.setTitre(e.getTitre());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			event.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eventRepository.save(event);

	}*/

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
