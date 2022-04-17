package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IEnfantService;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
@Slf4j
public class EnfantService implements IEnfantService {
	@Autowired
     EnfantRepository enfantRepository ;
	@Autowired
	UserRepository userRepository;
	@Override
	public List<EnfantEntity> retrieveAllChildren() {
		return (List<EnfantEntity>) enfantRepository.findAll() ;
	}

	@Override
	public EnfantEntity addChild(EnfantEntity c) {
		enfantRepository.save(c) ;
	   
			return c;
	}

	@Override
	public void deleteChild(String id) {
		enfantRepository.deleteById((long) Integer.parseInt(id));
		
	}

	@Override
	public EnfantEntity updateChild(EnfantEntity c) {
		enfantRepository.save(c) ;
		return c;
	}

	@Override
	public EnfantEntity retrieveChild(String id) {
		return	enfantRepository.findById((long) Integer.parseInt(id)).orElse(null);
	}

	@Override
	public void affecterchildAparent(Long idEnfant, Long parentId) {
		UserEntity p = userRepository.findById(parentId).get();
		EnfantEntity c =  enfantRepository.findById(idEnfant).get() ;
		
		p.getEnfant().add(c);
		userRepository.save(p) ;
		
	}

}
