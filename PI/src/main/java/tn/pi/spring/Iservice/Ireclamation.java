package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.Reclamation;


public interface Ireclamation {
	List<Reclamation> retrieveAllReclamation();

	Reclamation addReclamation (Reclamation r);

	void deleteReclamation (Long id);

	Reclamation updateReclamation (Reclamation r);
	
	Reclamation retrieveReclamation (Long id);
}
