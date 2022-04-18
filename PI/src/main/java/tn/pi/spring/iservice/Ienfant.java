package tn.pi.spring.iservice;

import java.util.List;

import tn.pi.spring.entity.Enfant;

public interface Ienfant {
	List<Enfant> retrieveAllEnfant();

	Enfant addEnfant (Enfant e);

	void deleteEnfant (Long id);

	Enfant updateEnfant (Enfant e);

	Enfant retrieveEnfant (Long id);
}
