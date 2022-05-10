package tn.pi.spring.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.Iservice.IinscriBus;
import tn.pi.spring.entity.Bus;
import tn.pi.spring.entity.Enfant;
import tn.pi.spring.entity.InscriBus;
import tn.pi.spring.repository.BusRepository;
import tn.pi.spring.repository.EnfantRepository;
import tn.pi.spring.repository.InscriBusRepository;
import tn.pi.spring.repository.TrajetRepository;

@Service 
@Slf4j
@Transactional
public class InscriBusService implements IinscriBus{
	@Autowired
	InscriBusRepository inscriBusRepository;
	@Autowired
	BusRepository busRepository;
	@Autowired
	TrajetRepository trajetRepository;
	@Autowired
	EnfantRepository enfantRepository;
	

	@Override
	public List<InscriBus> retrieveAllInscriBus() {
		/*List<InscriBus> inscriBuss = (List<InscriBus>) inscriBusRepository.findAll();
		for (InscriBus inscriBus : inscriBuss) {
			log.info(" InscriBus : " + inscriBus);
		}
		return inscriBuss;*/
		return (List<InscriBus>) inscriBusRepository.findAll();
	}
	
	@Override
	public InscriBus addInscriBus(InscriBus i) {
		log.info("In method addInscriBus");
		return inscriBusRepository.save(i);
	}


	@Override
	public InscriBus addInscriBus1(InscriBus i, Long idBus, Long idEnfant) {
		Bus bus = busRepository.findById(idBus).get();
		Enfant enfant = enfantRepository.findById(idEnfant).get();
		i.setEnfants(enfant);
		int n1= inscriBusRepository.getNombreEnfantsInscriByBusJPQL(idBus);
		int n2= busRepository.findById(idBus).get().getNombre_enfants_max();
		if (n1 < n2) {
			i.setBuss(bus);	
			return inscriBusRepository.save(i);	
		}
		else {
		System.out.println("bus complet");
		};
						
		log.info("In method addInscriBus");
		return null;
	}

	@Override
	public void deleteInscriBus(Long id) {
		log.info("In method deleteInscriBus");
		inscriBusRepository.deleteById(id);
		
	}

	@Override
	public InscriBus updateInscriBus(InscriBus i) {
		log.info("In method updateInscriBus");
		return inscriBusRepository.save(i);
	}

	@Override
	public InscriBus retrieveInscriBus(Long id) {
		InscriBus inscriBus = inscriBusRepository.findById(id).orElse(null);
		return inscriBus;
	}

	@Override
	public List<InscriBus> getEnfantsByBus(Long idBus) {
		return (List<InscriBus>) inscriBusRepository.getEnfantsByBus(idBus);
	}

	@Override
	public int getNombreEnfantsInscriJPQL() {
		return inscriBusRepository.getNombreEnfantsInscriJPQL();
	}

	@Override
	public int getNombreEnfantsInscriByBusJPQL(Long idBus) {
		return inscriBusRepository.getNombreEnfantsInscriByBusJPQL(idBus);
	}

	
	//ASSIGN
	@Override
	public void ajouterEtAffecterInscriptionAEnfantetBUS(InscriBus inscription, Long idBus, Long idEnfant) {
		log.info("In method addInscri");
		Bus b = busRepository.findById(idBus).orElse(null);
		inscription.setBuss(b);
		Enfant e = enfantRepository.findById(idEnfant).orElse(null);
		inscription.setEnfants(e);
		int n1= inscriBusRepository.getNombreEnfantsInscriByBusJPQL(idBus);
		int n2= busRepository.findById(idBus).get().getNombre_enfants_max();
		if (n1 < n2) {
			inscription.setBuss(b);	
			inscriBusRepository.save(inscription);
		}
		else {
		System.out.println("bus complet");
		};
						
		log.info("In method addInscriBus");
	
		
	}

	/*@Override
	public List<InscriBus> getTrajetsville(String ville) {
		InscriBus inscriBus = inscriBusRepository.
		List<Trajet> trajet = (List<Trajet>) trajetRepository.findAll();
		for (int i = 4; i < trajet.size(); i++) {
		      System.out.println(trajet.get(i));
	    }
		
		// TODO Auto-generated method stub
		return null;
	}*/

}
