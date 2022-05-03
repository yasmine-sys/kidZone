package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.InscriCantine;

public interface IInscriCantine {
	List<InscriCantine> retrieveAllInscriCantine();

	InscriCantine addInscriCantine (InscriCantine e);

	void deleteInscriCantine (Long id);

	InscriCantine updateInscriCantine(InscriCantine e);
	
	InscriCantine retrieveInscriCantine(Long id);
}
