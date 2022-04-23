package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.Iservice.Ienfant;
import tn.pi.spring.entity.Enfant;
import tn.pi.spring.repository.EnfantRepository;

@Service 
@Slf4j
public class EnfantService implements Ienfant{
	@Autowired
	EnfantRepository enfantRepository;
	
	@Override
	public List<Enfant> retrieveAllEnfant() {
		/*List<Enfant> enfants = (List<Enfant>) enfantRepository.findAll();
		for (Enfant enfant : enfants) {
			log.info(" Enfant : " + enfant);
		}
		return enfants;*/
		return (List<Enfant>) enfantRepository.findAll();
	}

	@Override
	public Enfant addEnfant(Enfant e) {
		log.info("In method addEnfant");
		return enfantRepository.save(e);
	}

	@Override
	public void deleteEnfant(Long id) {
		log.info("In method deleteEnfant");
		enfantRepository.deleteById(id);
		
	}

	@Override
	public Enfant updateEnfant(Enfant e) {
		log.info("In method updateEnfant");
		return enfantRepository.save(e);
	}

	@Override
	public Enfant retrieveEnfant(Long id) {
		Enfant enfant = enfantRepository.findById(id).orElse(null);
		return enfant;
	}

}
