package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entity.Cantine;
import tn.pi.spring.Iservice.ICantine;
import tn.pi.spring.repository.CantineRepository;

@Service

public class CantineService implements ICantine {
	@Autowired
	CantineRepository cantineRepository;

	@Override
	public List<Cantine> retrieveAllCantine() {
		List<Cantine> cantines = (List<Cantine>) cantineRepository.findAll();
		return cantines;

	}

	@Override
	public Cantine addCantine(Cantine e) {
		
		return cantineRepository.save(e); 
	}

	@Override
	public void deleteCantine(Long id) {
		cantineRepository.deleteById(id);
		
	}

	@Override
	public Cantine updateCantine(Cantine e) {
		return cantineRepository.save(e);
	}

	@Override
	public Cantine retrieveCantine(Long id) {
		Cantine cantine = cantineRepository.findById(id).orElse(null);
		return cantine;
	}

}
