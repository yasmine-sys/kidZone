package tn.pi.spring.iservice;

import java.util.List;

import tn.pi.spring.entity.Trajet;

public interface Itrajet {
	List<Trajet> retrieveAllTrajet();

	Trajet addTrajet (Trajet t);

	void deleteTrajet (Long id);

	Trajet updateTrajet (Trajet t);

	Trajet retrieveTrajet (Long id);
}
