package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pi.spring.entity.Chauffeur;

@Repository
public interface ChauffeurRepository extends CrudRepository<Chauffeur,Long>{

}
