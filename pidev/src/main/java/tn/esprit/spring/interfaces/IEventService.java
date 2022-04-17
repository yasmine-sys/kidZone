package tn.esprit.spring.interfaces;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import tn.esprit.spring.entity.EventEntity;



public interface IEventService {

	//public Long addEvent(EventEntity e);
	public List<EventEntity> getAllEvents();

	public void deleteEventById(Long EventId);

	public int getNombreEventJPQL();

	public List<String> getAllEventNamesJPQL();

	//public void updateEvent(EventEntity e, Long idEvent);
	
	public ResponseEntity<String>  ajoutByDirecteurJardin(EventEntity event, Long userId);
	public List<EventEntity> getAllEventPourToday();

	public List<EventEntity> getAllEventOrdonneParDate();
	
	public List<EventEntity> Search(String mot);
	
	//public Map<EventEntity, Integer> NombreticketsRestant();

	//public Map<EventEntity, Integer> Nombretickets();
	
	public String getEventTitreById(Long idEvent);
	
	public void mettreAjourTitreByEVentIdJPQL(String titre, Long idEvent) ;
	//public void deleteEventTitreById(Long idEvent);
	EventEntity addEvent(EventEntity s);
	EventEntity updateEvent(EventEntity s);
	

}
