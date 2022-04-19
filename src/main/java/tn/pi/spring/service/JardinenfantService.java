package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.entity.Jardinenfant;
import tn.pi.spring.Iservice.IJardinenfant;
import tn.pi.spring.repository.JardinenfantRepository;

@Service 
@Slf4j
public class JardinenfantService implements IJardinenfant {
	@Autowired
	JardinenfantRepository jardinenfantRepository;
	
	@Override
	public List<Jardinenfant> retrieveAllJardinenfant() {
		List<Jardinenfant> Jardinenfant = (List<Jardinenfant>) jardinenfantRepository.findAll();
		for (Jardinenfant Jardinenfant1 : Jardinenfant) {
			log.info(" Jardinenfant : " + Jardinenfant1);
		}
		return Jardinenfant;
	}

	@Override
	public Jardinenfant addJardinenfant(Jardinenfant e) {
		log.info("In method addInscriCantine");
		return jardinenfantRepository.save(e);
	}

	@Override
	public void deleteJardinenfant(Long id) {
		log.info("In method deleteInscriCantine");
		jardinenfantRepository.deleteById(id);
		
	}

	@Override
	public Jardinenfant updateJardinenfant(Jardinenfant e) {
		log.info("In method updateInscriCantine");
		return jardinenfantRepository.save(e);
	}

	@Override
	public Jardinenfant retrieveJardinenfant(Long id) {
		Jardinenfant Jardinenfant = jardinenfantRepository.findById(id).orElse(null);
		return Jardinenfant;
	}
}
