package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IEnfantService;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.ReservationRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
@Slf4j
public class EnfantService implements IEnfantService {
	@Autowired
     EnfantRepository enfantRepository ;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ReservationRepository  reservationRepository;
	
	@Override
	public List<EnfantEntity> findAllEnfantByEventJPQL(Long idEvent) {
		return enfantRepository.findAllEnfantByEventJPQL(idEvent);
	}
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
	public void affecterchildAparent(Long childId, Long parentId) {
		EnfantEntity c = enfantRepository.findById(childId).orElse(null);
		UserEntity p = userRepository.findById(parentId).orElse(null);
		c.setUser(p);
		userRepository.save(p);
		
	
	}
	@Override
	public void addEnfantByUser(EnfantEntity s, Long idUser) {
		UserEntity u = userRepository.findById(idUser).get();
		s.setUser(u);

		enfantRepository.save(s);
		
	}

}
