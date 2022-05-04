package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.entity.EnfantEntity;


public interface IEnfantService {
	List<EnfantEntity> retrieveAllChildren();

	EnfantEntity addChild(EnfantEntity c);
	void deleteChild(String id);
	EnfantEntity updateChild(EnfantEntity c );
	EnfantEntity retrieveChild(String id);
	void affecterchildAparent(Long idEnfant, Long parentId) ;
}
