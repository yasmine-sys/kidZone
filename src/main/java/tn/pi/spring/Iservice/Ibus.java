package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.Bus;

public interface Ibus {
	List<Bus> retrieveAllBus();
	
	Bus addBus (Bus b);

	Bus addBus (Bus b, Long idTrajet, Long idChauffeur);
	
	void deleteBus (Long idBus);

	Bus updateBus (Bus b);

	Bus retrieveBus (Long id);
}
