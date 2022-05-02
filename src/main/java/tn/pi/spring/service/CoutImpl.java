package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.spring.Iservice.CoutService;
import tn.pi.spring.Repository.CoutRepository;
import tn.pi.spring.Repository.JardinRepository;
import tn.pi.spring.entity.Cout;
import tn.pi.spring.entity.Jardin;



@Service
public class CoutImpl implements CoutService {
@Autowired	
CoutRepository coutrepository;
@Autowired
JardinRepository jardinrepository;

	@Override
	public void affectercoutjardin(List<Cout> lc, Long JardinId) {
		// TODO Auto-generated method stub
		Jardin jardin=jardinrepository.findById(JardinId).orElse(null);
		for(Cout cout:lc) {cout.setJardin(jardin);
		coutrepository.save(cout);
		}
	}

}
