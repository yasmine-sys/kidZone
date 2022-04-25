package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.Chauffeur;

public interface Ichauffeur {
	List<Chauffeur> retrieveAllChauffeur();

	Chauffeur addChauffeur (Chauffeur c);

	void deleteChauffeur (Long id);

	Chauffeur updateChauffeur (Chauffeur c);

	Chauffeur retrieveChauffeur (Long id);
}
