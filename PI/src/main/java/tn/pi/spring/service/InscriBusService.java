package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.InscriBus;
import tn.pi.spring.iservice.IinscriBus;
import tn.pi.spring.repository.InscriBusRepository;

@Service 
@Slf4j
public class InscriBusService implements IinscriBus{
	@Autowired
	InscriBusRepository inscriBusRepository;

	@Override
	public List<InscriBus> retrieveAllInscriBus() {
		List<InscriBus> inscriBuss = (List<InscriBus>) inscriBusRepository.findAll();
		for (InscriBus inscriBus : inscriBuss) {
			log.info(" InscriBus : " + inscriBus);
		}
		return inscriBuss;
	}

	@Override
	public InscriBus addInscriBus(InscriBus i) {
		log.info("In method addInscriBus");
		return inscriBusRepository.save(i);
	}

	@Override
	public void deleteInscriBus(Long id) {
		log.info("In method deleteInscriBus");
		inscriBusRepository.deleteById(id);
		
	}

	@Override
	public InscriBus updateInscriBus(InscriBus i) {
		log.info("In method updateInscriBus");
		return inscriBusRepository.save(i);
	}

	@Override
	public InscriBus retrieveInscriBus(Long id) {
		InscriBus inscriBus = inscriBusRepository.findById(id).orElse(null);
		return inscriBus;
	}

	@Override
	public List<InscriBus> getEnfantsByBus(Long idBus) {
		return (List<InscriBus>) inscriBusRepository.getEnfantsByBus(idBus);
	}

	@Override
	public int getNombreEnfantsInscriJPQL() {
		return inscriBusRepository.getNombreEnfantsInscriJPQL();
	}

	@Override
	public int getNombreEnfantsInscriByBusJPQL(Long idBus) {
		return inscriBusRepository.getNombreEnfantsInscriByBusJPQL(idBus);
	}

}
