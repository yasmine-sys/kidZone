package tn.pi.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Bus;
import tn.pi.spring.entity.Trajet;
import tn.pi.spring.iservice.Itrajet;
import tn.pi.spring.repository.BusRepository;
import tn.pi.spring.repository.TrajetRepository;

@Service 
@Slf4j
public class TrajetService implements Itrajet{
	@Autowired
	TrajetRepository trajetRepository;
	@Autowired
	BusRepository busRepository;
	
	@Override
	public List<Trajet> retrieveAllTrajet() {
		List<Trajet> trajets = (List<Trajet>) trajetRepository.findAll();
		for (Trajet trajet : trajets) {
			log.info(" Trajet : " + trajet);
		}
		return trajets;
	}

	@Override
	public Trajet addTrajet(Trajet t,Long idBus ) {
		Bus bus = busRepository.findById(idBus).orElse(null);
		t.getBuus().add(bus);
		log.info("In method addTrajet");
		return trajetRepository.save(t);
	}

	@Override
	public void deleteTrajet(Long id) {
		log.info("In method deleteTrajet");
		trajetRepository.deleteById(id);
		
	}

	@Override
	public Trajet updateTrajet(Trajet t) {
		log.info("In method updateTrajet");
		return trajetRepository.save(t);
	}

	@Override
	public Trajet retrieveTrajet(Long id) {
		Trajet trajet = trajetRepository.findById(id).orElse(null);
		return trajet;
	}

	@Override
	public List<Trajet> retrieveTrajetByLongeurTrajet(Long l) {
		return(List<Trajet>)trajetRepository.retrieveTrajetByLongeurTrajet(l);
	}

}
