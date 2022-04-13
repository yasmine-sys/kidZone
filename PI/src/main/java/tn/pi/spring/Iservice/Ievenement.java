package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.Evenement;

public interface Ievenement {
	List<Evenement> retrieveAllEvenement();

	Evenement addEvenement (Evenement e);

	void deleteEvenement (Long id);

	Evenement updateEvenement (Evenement e);
	
	Evenement retrieveEvenement (Long id);

}
