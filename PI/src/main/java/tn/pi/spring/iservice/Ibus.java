package tn.pi.spring.iservice;

import java.util.List;
import tn.pi.spring.entity.Bus;

public interface Ibus {
	List<Bus> retrieveAllBus();

	Bus addBus (Bus b);

	void deleteBus (Long id);

	Bus updateBus (Bus b);

	Bus retrieveBus (Long id);
}
