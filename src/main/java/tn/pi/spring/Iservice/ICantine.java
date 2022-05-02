package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.Cantine;

public interface ICantine {
	List<Cantine> retrieveAllCantine();

	Cantine addCantine (Cantine e);

	void deleteCantine (Long id);

	Cantine updateCantine (Cantine e);
	
	Cantine retrieveCantine (Long id);

}
