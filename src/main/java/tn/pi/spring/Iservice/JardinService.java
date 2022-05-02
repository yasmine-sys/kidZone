package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.Jardin;


public interface JardinService {
	
	List<Jardin>retrievAllJardins();
	Jardin addJardin(Jardin p);
	void deleteJardin(Long id);
	Jardin updateJardin(Jardin p);
	Jardin retrieveJardin(Long id);
	void updatejar(Long JardinId,Jardin p);
	List<Jardin> getAllJardin();

}
