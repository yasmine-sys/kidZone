package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.entity.InscriCantine;
import tn.pi.spring.Iservice.IInscriCantine;
import tn.pi.spring.repository.InscriCantineRepository;

@Service 
@Slf4j
public class InscriCantineService implements IInscriCantine{
	@Autowired
	InscriCantineRepository inscriCantineRepository;
	
	@Override
	public List<InscriCantine> retrieveAllInscriCantine() {
		/*List<InscriCantine> InscriCantine = (List<InscriCantine>) inscriCantineRepository.findAll();
		for (InscriCantine InscriCantine1 : InscriCantine) {
			log.info(" InscriCantine : " + InscriCantine1);
		}
		*/
		return (List<InscriCantine>) inscriCantineRepository.findAll();
	}

	@Override
	public InscriCantine addInscriCantine(InscriCantine e) {
		log.info("In method addInscriCantine");
		return inscriCantineRepository.save(e);
	}

	@Override
	public void deleteInscriCantine(Long id) {
		log.info("In method deleteInscriCantine");
		inscriCantineRepository.deleteById(id);
		
	}

	@Override
	public InscriCantine updateInscriCantine(InscriCantine e) {
		log.info("In method updateInscriCantine");
		return inscriCantineRepository.save(e);
	}

	@Override
	public InscriCantine retrieveInscriCantine(Long id) {
		InscriCantine InscriCantine = inscriCantineRepository.findById(id).orElse(null);
		return InscriCantine;
	}

}
