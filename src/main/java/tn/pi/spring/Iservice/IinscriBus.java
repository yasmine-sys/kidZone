package tn.pi.spring.Iservice;

import java.util.List;


import tn.pi.spring.entity.InscriBus;

public interface IinscriBus {
	List<InscriBus> retrieveAllInscriBus();

	InscriBus addInscriBus (InscriBus i);
	
	InscriBus addInscriBus1 (InscriBus i,Long idBus,Long idEnfant);

	void deleteInscriBus (Long id);

	InscriBus updateInscriBus (InscriBus i);

	InscriBus retrieveInscriBus (Long id);
		
	List<InscriBus> getEnfantsByBus(Long idBus);
	
	public int getNombreEnfantsInscriJPQL();
	
	public int getNombreEnfantsInscriByBusJPQL(Long idBus);
	
	public void ajouterEtAffecterInscriptionAEnfantetBUS (InscriBus inscription,Long idBus,Long idEnfant);
	
	
	
	//public List<Trajet> searchTrajet(String word);
	
	//List<InscriBus> getTrajetsville(String ville);
}
