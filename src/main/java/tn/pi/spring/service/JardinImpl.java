package tn.pi.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.Iservice.JardinService;
import tn.pi.spring.Repository.JardinRepository;
import tn.pi.spring.entity.Jardin;



@Service
@Slf4j
public class JardinImpl implements JardinService {

	@Autowired
	JardinRepository jardinRepository;
	@Override
	public List<Jardin> retrievAllJardins() {
	return jardinRepository.findAll();
	}

	@Override
	public Jardin addJardin(Jardin p) {
		return jardinRepository.save(p);
	}

	@Override
	public void deleteJardin(Long id) {
		// TODO Auto-generated method stub
		jardinRepository.deleteById(id);
	}

	@Override
	public Jardin updateJardin(Jardin p) {
		return jardinRepository.save(p);
	}

	@Override
	public Jardin retrieveJardin(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return (jardinRepository.findById(id).get());
	}

	@Override
	public void updatejar(Long JardinId, Jardin p) {
		p=jardinRepository.findById(JardinId).orElse(null);
		jardinRepository.save(p);
		
		
	}
	
	@Override
	public List<Jardin> getAllJardin()
	{
		return jardinRepository.findAll();

	
	}



}

