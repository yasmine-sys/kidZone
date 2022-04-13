package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.entity.Evenement;
import tn.pi.entity.Reclamation;
import tn.pi.spring.Iservice.Ievenement;
import tn.pi.spring.Iservice.Ireclamation;
import tn.pi.spring.repository.ReclamationRepository;

@Service
@Slf4j
public class ReclamationService implements Ireclamation {
	@Autowired
	ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> retrieveAllReclamation() {

		List<Reclamation> evenements = (List<Reclamation>) reclamationRepository.findAll();
		return evenements;
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Long id) {
		reclamationRepository.deleteById(id);

	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		Reclamation evenement = reclamationRepository.findById(id).orElse(null);

		return evenement;

	}

}
