package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.Enfant;

public interface Ienfant {
	List<Enfant> retrieveAllEnfant();

	Enfant addEnfant (Enfant e);

	void deleteEnfant (Long id);

	Enfant updateEnfant (Enfant e);

	Enfant retrieveEnfant (Long id);
}
