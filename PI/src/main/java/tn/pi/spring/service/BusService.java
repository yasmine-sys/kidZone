package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Bus;
import tn.pi.spring.iservice.Ibus;
import tn.pi.spring.repository.BusRepository;

@Service 
@Slf4j
public class BusService implements Ibus{
	@Autowired
	BusRepository busRepository;
		
	@Override
	public List<Bus> retrieveAllBus() {
		List<Bus> buss = (List<Bus>) busRepository.findAll();
		for (Bus bus : buss) {
			log.info(" Bus : " + bus);
		}
		return buss;
	}

	@Override
	public Bus addBus(Bus b) {
		log.info("In method addBus");
		return busRepository.save(b);
	}

	@Override
	public void deleteBus(Long id) {
		log.info("In method deleteBus");
		busRepository.deleteById(id);
		
	}

	@Override
	public Bus updateBus(Bus b) {
		log.info("In method updateBus");
		return busRepository.save(b);
	}

	@Override
	public Bus retrieveBus(Long id) {
		Bus bus = busRepository.findById(id).orElse(null);
		return bus;
	}

}
