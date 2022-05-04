package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.entity.Evenement;
import tn.pi.spring.Iservice.Ievenement;
import tn.pi.spring.repository.EvenementRepository;

@Service
@Slf4j
public class EvenementService implements Ievenement {
	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public List<Evenement> retrieveAllEvenement() {
		List<Evenement> evenements = (List<Evenement>) evenementRepository.findAll();
		return evenements;

	}

	@Override
	public Evenement addEvenement(Evenement e) {
		
		return evenementRepository.save(e); 
	}

	@Override
	public void deleteEvenement(Long id) {
		
		evenementRepository.deleteById(id);
		
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		
		return evenementRepository.save(e);
	}

	@Override
	public Evenement retrieveEvenement(Long id) {
     Evenement evenement = evenementRepository.findById(id).orElse(null);
		
		return evenement;
	
	}

}
