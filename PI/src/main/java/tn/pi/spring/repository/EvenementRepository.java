package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement,Long> {
	

}
