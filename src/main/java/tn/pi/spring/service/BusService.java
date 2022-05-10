package tn.pi.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.Iservice.Ibus;
import tn.pi.spring.entity.Bus;
import tn.pi.spring.entity.Chauffeur;
import tn.pi.spring.entity.Trajet;
import tn.pi.spring.repository.BusRepository;
import tn.pi.spring.repository.ChauffeurRepository;
import tn.pi.spring.repository.TrajetRepository;

@Service 
@Slf4j
public class BusService implements Ibus{
	@Autowired
	BusRepository busRepository;
	@Autowired
	TrajetRepository trajetRepository;
	private List<Trajet> trajets;
	
	@Autowired
	ChauffeurRepository chaffeurRepository;
		
	@Override
	public List<Bus> retrieveAllBus() {
		//List<Bus> buss = (List<Bus>) busRepository.findAll();
		//for (Bus bus : buss) {
		//	log.info(" Bus : " + bus);
		//}
		//return buss;
		return (List<Bus>) busRepository.findAll();
	}
	
	@Override
	public Bus addBus(Bus b) {
		log.info("In method addEnfant");
		return busRepository.save(b);
	}

	@Override
	public Bus addBus(Bus b, Long idTrajet, Long idChauffeur) {
		Chauffeur chauffeur = chaffeurRepository.findById(idChauffeur).get();
		Trajet trajet= trajetRepository.findById(idTrajet).get();
		trajets= new ArrayList<Trajet>(); 
		trajets.add(trajet);
		b.setTrajets(trajets);
		b.setChauffeurs(chauffeur);
		busRepository.save(b);
		log.info("In method addBus");
		return b;
		
	}
	
	

	@Override
	public void deleteBus(Long idBus) {
		log.info("In method deleteBus");
		busRepository.deleteById(idBus);
		
	}

	@Override
	public Bus updateBus(Bus b) {
		log.info("In method updateBus");
		return busRepository.save(b);
	}

	@Override
	public Bus retrieveBus(Long id) {
		Bus bus = busRepository.findById(id).orElse(null);
		return bus;
	}

	


}
