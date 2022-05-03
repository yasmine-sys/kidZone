package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.Jardinenfant;

public interface IJardinenfant {
	List<Jardinenfant> retrieveAllJardinenfant();

	Jardinenfant addJardinenfant (Jardinenfant e);

	void deleteJardinenfant (Long id);

	Jardinenfant updateJardinenfant(Jardinenfant e);
	
	Jardinenfant retrieveJardinenfant(Long id);
}
