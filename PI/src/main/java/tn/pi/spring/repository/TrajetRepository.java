package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pi.spring.entity.Trajet;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet,Long>{

}
