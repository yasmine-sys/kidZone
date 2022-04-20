package tn.pi.spring.iservice;

import java.util.List;

import tn.pi.spring.entity.InscriBus;

public interface IinscriBus {
	List<InscriBus> retrieveAllInscriBus();

	InscriBus addInscriBus (InscriBus i);

	void deleteInscriBus (Long id);

	InscriBus updateInscriBus (InscriBus i);

	InscriBus retrieveInscriBus (Long id);
	
	List<InscriBus> getEnfantsByBus(Long idBus);
	
	public int getNombreEnfantsInscriJPQL();
	
	public int getNombreEnfantsInscriByBusJPQL(Long idBus);
}
