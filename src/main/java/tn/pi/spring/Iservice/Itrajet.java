package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.Trajet;

public interface Itrajet {
	List<Trajet> retrieveAllTrajet();

	Trajet addTrajet (Trajet t);

	void deleteTrajet (Long id);

	Trajet updateTrajet (Trajet t);

	Trajet retrieveTrajet (Long id);
	
<<<<<<< Updated upstream
	List<Trajet> retrieveTrajetByLongeurTrajet(Long l);
=======
	List<Trajet> retrieveTrajetByLongueurTrajet(Long l);
>>>>>>> Stashed changes
}
