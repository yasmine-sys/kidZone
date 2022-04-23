package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.Iservice.Ichauffeur;
import tn.pi.spring.entity.Chauffeur;
import tn.pi.spring.repository.ChauffeurRepository;

@Service 
@Slf4j
public class ChauffeurService implements Ichauffeur{
	@Autowired
	ChauffeurRepository chauffeurRepository;

	@Override
	public List<Chauffeur> retrieveAllChauffeur() {
		/*List<Chauffeur> chauffeurs = (List<Chauffeur>) chauffeurRepository.findAll();
		for (Chauffeur chauffeur : chauffeurs) {
			log.info(" Chauffeur : " + chauffeur);
		}
		return chauffeurs;*/
		return (List<Chauffeur>) chauffeurRepository.findAll();
	}

	@Override
	public Chauffeur addChauffeur(Chauffeur c) {
		log.info("In method addChauffeur");
		return chauffeurRepository.save(c);
	}

	@Override
	public void deleteChauffeur(Long id) {
		log.info("In method deleteChauffeur");
		chauffeurRepository.deleteById(id);
		
	}

	@Override
	public Chauffeur updateChauffeur(Chauffeur c) {
		log.info("In method updateChauffeur");
		return chauffeurRepository.save(c);
	}

	@Override
	public Chauffeur retrieveChauffeur(Long id) {
		Chauffeur chauffeur = chauffeurRepository.findById(id).orElse(null);
		return chauffeur;
	}

}
